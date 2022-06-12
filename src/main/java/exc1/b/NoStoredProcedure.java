package exc1.b;

import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperCliente;
import DAO.Mappers.MapperGps;
import DAO.Mappers.MapperVeiculo;
import DAO.Repositories.RepositoryVeiculo;
import DAO.Repositories.RepositoryZonaVerde;
import jakarta.persistence.*;
import model.*;

import java.util.List;

public class NoStoredProcedure {
    public void createAndAssociateVehicle(String regTag, Integer clientNif, String name, String telephone, Integer alarms,
                                          Integer gps, Double longitude, Double latitude, Double radius) throws Exception {
        try (DataScopeVehicleManager vm = new DataScopeVehicleManager()){
            EntityManager em = vm.getEntityManager();

            if (!((longitude == null && latitude == null && radius == null) || (longitude != null && latitude != null && radius != null))) {
                em.getTransaction().rollback();
                throw new Exception("Faltam argumentos para a criação de uma zona verde");
            }

                MapperCliente mc = new MapperCliente();
                MapperGps mGps = new MapperGps();
                RepositoryVeiculo rv = new RepositoryVeiculo();

                Cliente c = vm.findClient(clientNif);

                if (c == null){
                    em.getTransaction().rollback();
                    throw new Exception("O nif que inseriu não pertence a nenhum cliente");
                }

                ClienteParticular cp = vm.findParticularClient(clientNif);

                if (cp != null) {

                    List<Veiculo> lv = vm.getAllVehiclesByClientNif(clientNif);

                    if (lv.size() < 3){
                        Veiculo vehicle = new Veiculo();
                        vehicle.setId(regTag);
                        vehicle.setNif(mc.read(clientNif));
                        vehicle.setNomecondutor(name);
                        vehicle.setTelefone(telephone);
                        vehicle.setNumalarmes(alarms);
                        vehicle.setGps(mGps.read(gps));

                        rv.save(vehicle);
                    }
                    else {
                        em.getTransaction().rollback();
                        throw new Exception("Não é possível associar mais veículos a este cliente");
                    }
                }
                else {
                    Veiculo vehicle = new Veiculo();
                    vehicle.setId(regTag);
                    vehicle.setNif(mc.read(clientNif));
                    vehicle.setNomecondutor(name);
                    vehicle.setTelefone(telephone);
                    vehicle.setNumalarmes(alarms);
                    vehicle.setGps(mGps.read(gps));

                    rv.add(vehicle);
                }


            if (latitude != null && longitude != null && radius != null) {
                RepositoryZonaVerde rzv = new RepositoryZonaVerde();

                MapperVeiculo mv = new MapperVeiculo();

                ZonaverdeId zvId = new ZonaverdeId();

                zvId.setLongitude(longitude);
                zvId.setLatitude(latitude);

                ZonaVerde zv = new ZonaVerde();

                zv.setId(zvId);
                zv.setRaio(radius);
                zv.setMatricula(mv.read(regTag));

                rzv.save(zv);
            }


            vm.validateWork();

        }

    }

}