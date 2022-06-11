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

                TypedQuery<Cliente> qc = em.createQuery("select c from Cliente c where c.id = ?1",Cliente.class);
                List<Cliente> listC = qc.setParameter(1, clientNif).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();

                if (listC.size() == 0){
                    em.getTransaction().rollback();
                    throw new Exception("O nif que inseriu não pertence a nenhum cliente");
                }

                TypedQuery<ClienteParticular> q = em.createQuery("select cp from ClienteParticular as cp join Cliente as c on cp.id = c.id where cp.id = ?1", ClienteParticular.class);
                List<ClienteParticular> list = q.setParameter(1, clientNif).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();

                if (list.size() == 1) {
                    TypedQuery<Veiculo> qv = em.createQuery("select v from Veiculo as v where v.nif.id = ?1", Veiculo.class);
                    List<Veiculo> lv = qv.setParameter(1, clientNif).setLockMode(LockModeType.PESSIMISTIC_READ).getResultList();

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