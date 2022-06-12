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
    /**
     * Creates an object Veiculo with the respective object Veiculo information associated to the object Gps, and associates
     * it with an object Cliente.
     * @param regTag is the value of property 'matricula' of object Veiculo to be created.
     * @param clientNif is the value of property 'nif' of object Veiculo to be created.
     * @param name is the value of property 'nomecondutor' of object Veiculo to be created.
     * @param telephone is the value of property 'telefone' of object Veiculo to be created.
     * @param alarms is the value of property 'numalarmes' of object Veiculo to be created.
     * @param gps is the value of property 'gps' of object Veiculo to be created.
     * @param longitude is the value of property 'longitude' of object ZonaVerde to be created.
     * @param latitude is the value of property 'latitude' of object ZonaVerde to be created.
     * @param radius is the value of property 'raio' of object ZonaVerde to be created.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
    public void createAndAssociateVehicle(String regTag, Integer clientNif, String name, String telephone, Integer alarms,
                                          Integer gps, Double longitude, Double latitude, Double radius) throws Exception {
        try (DataScopeVehicleManager vm = new DataScopeVehicleManager()){
            EntityManager em = vm.getEntityManager();

            if (!((longitude == null && latitude == null && radius == null) || (longitude != null && latitude != null && radius != null))) {
                em.getTransaction().rollback();
                throw new Exception("Faltam argumentos para a criação de uma zona verde");
            }
                //Creates mapper for objects Cliente and Gps and also a repository for object Veiculo.
                MapperCliente mc = new MapperCliente();
                MapperGps mGps = new MapperGps();
                RepositoryVeiculo rv = new RepositoryVeiculo();

                //Finds an object Cliente based on its id.
                Cliente c = vm.findClient(clientNif);

                //if there's no object Cliente with that id, generates an exception.
                if (c == null){
                    em.getTransaction().rollback();
                    throw new Exception("O nif que inseriu não pertence a nenhum cliente");
                }

                //Finds an object ClienteParticular
                ClienteParticular cp = vm.findParticularClient(clientNif);

                //if the object ClienteParticular was found execute some tests
                if (cp != null) {

                    //Gets all objects Veiculo which property 'nif' is equal to clientNif
                    List<Veiculo> lv = vm.getAllVehiclesByClientNif(clientNif);

                    //Verifies if the objects associated with cp is less than 3, if true generates an object Veiculo
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
                        //Else generates an exception.
                        em.getTransaction().rollback();
                        throw new Exception("Não é possível associar mais veículos a este cliente");
                    }
                }
                //if the object ClienteParticular was not found, it means that is an object ClienteInstitucional.
                else {
                    //Then there's no limit in association of clientNif on objects Veiculo.
                    Veiculo vehicle = new Veiculo();
                    vehicle.setId(regTag);
                    vehicle.setNif(mc.read(clientNif));
                    vehicle.setNomecondutor(name);
                    vehicle.setTelefone(telephone);
                    vehicle.setNumalarmes(alarms);
                    vehicle.setGps(mGps.read(gps));

                    rv.add(vehicle);
                }

            //if these parameters are different of null, it's possible to create an object ZonaVerde
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

            //Validation of the instructions on database
            vm.validateWork();

        }

    }

}