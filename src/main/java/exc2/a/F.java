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

public class F {
    public void processUnprocessedRegisters() throws Exception {
        try (DataScopeVehicleManager vm = new DataScopeVehicleManager()) {

            MapperRegistoNProcessado mRnp = new MapperRegistoNProcessado();
            MapperGps mGps = new MapperGps();

            RepositoryInvalido ri = new RepositoryInvalido();
            RepositoryProcessado rp = new RepositoryProcessado();

            List<RegistoNProcessado> listRNP = vm.getAllRegistoNProcessado();

            RegistoNProcessado rnp;
            Double rnpLgd;
            Double rnpLtd;
            LocalDate rnpDat;
            Integer rnpGps;
            for (RegistoNProcessado registoNProcessado : listRNP) {
                rnp = registoNProcessado;
                rnpLgd = rnp.getLongitude();
                rnpLtd = rnp.getLatitude();
                rnpDat = rnp.getDat();
                rnpGps = rnp.getGps();

                if (rnpLgd == null || rnpLtd == null || rnpDat == null || rnpGps == null) {
                    Invalido inv = new Invalido();
                    Integer rnpId = rnp.getId();
                    inv.setId(rnpId);
                    inv.setRegistonprocessado(rnp);

                    ri.add(inv);


                } else {
                    List<Processado> listProcessed = vm.getAllProcessado();
                    Processado p;
                    for (Processado processado : listProcessed) {
                        p = processado;
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

                    rp.add(processed);

                    mRnp.delete(rnp);

                }

            }
            vm.validateWork();
        }
    }
}
