package exc2.a;

import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperGps;
import DAO.Mappers.MapperRegistoNProcessado;
import DAO.Repositories.RepositoryInvalido;
import DAO.Repositories.RepositoryProcessado;

import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

// Implementation of exercice 2.f) from phase 1 using optimistic locking
public class F {

    /**
     * Processes the unprocessed registers dividing them into processed or invalid
     * @throws Exception
     */
    public void processUnprocessedRegisters() throws Exception {
        // creates a new session of work
        try (DataScopeVehicleManager vm = new DataScopeVehicleManager()) {

            MapperRegistoNProcessado mRnp = new MapperRegistoNProcessado();         // mapper for RegistoNProceeado objects
            MapperGps mGps = new MapperGps();                                       // mapper for Gps objects

            RepositoryInvalido ri = new RepositoryInvalido();                       // Invalido objects repository
            RepositoryProcessado rp = new RepositoryProcessado();                   // Processado objects repository

            List<RegistoNProcessado> listRNP = vm.getAllRegistoNProcessado();       // list of all RegistoNProcessado objects in the data base

            RegistoNProcessado rnp;
            Double rnpLgd;
            Double rnpLtd;
            LocalDate rnpDat;
            Integer rnpGps;
            for (RegistoNProcessado registoNProcessado : listRNP) {                 // loop to analyses all registoNProcessado objects
                rnp = registoNProcessado;
                rnpLgd = rnp.getLongitude();
                rnpLtd = rnp.getLatitude();
                rnpDat = rnp.getDat();
                rnpGps = rnp.getGps();

                // if that creates an Invalido object in case the latitude, longitude, date or gps of
                // the registoNProcessado object being analysed is null
                if (rnpLgd == null || rnpLtd == null || rnpDat == null || rnpGps == null) {
                    Invalido inv = new Invalido();
                    Integer rnpId = rnp.getId();
                    inv.setId(rnpId);
                    inv.setRegistonprocessado(rnp);

                    ri.add(inv);

                } else {
                    List<Processado> listProcessed = vm.getAllProcessado();         // list of all Processado objects in the data base
                    Processado p;
                    for (Processado processado : listProcessed) {                   // loop to analyses all Processado objects
                        p = processado;

                        // if that deletes a RegistoNProcessado object in case it is duplicated in the Processado repository
                        if (Objects.equals(p.getLongitude(), rnpLgd) && Objects.equals(p.getLatitude(), rnpLtd)
                                && p.getDat() == rnpDat && Objects.equals(p.getGps().getId(), rnpGps)) {
                            mRnp.delete(rnp);
                        }
                    }
                    Processado processed = new Processado();

                    processed.setLongitude(rnpLgd);
                    processed.setLatitude(rnpLtd);
                    processed.setDat(rnpDat);
                    processed.setGps(mGps.read(rnpGps));

                    rp.add(processed);                      // adds a new Processado object to the Processado repository

                    mRnp.delete(rnp);                       // deletes the RegistoNProcessado object beeing analysed

                }

            }
            vm.validateWork();
        }
    }
}
