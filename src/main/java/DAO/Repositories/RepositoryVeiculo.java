package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperVeiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Veiculo;

import java.util.List;

public class RepositoryVeiculo implements IRepository<Veiculo, String> {

    /**
     * Finds a Veiculo object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Veiculo object in the data base
     * @throws Exception
     * @return the found Veiculo object or null in case it doesn't find any
     */
    public Veiculo find(String Id) throws Exception {

        MapperVeiculo m = new MapperVeiculo();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Veiculo objects in the data base.
     * @throws Exception
     * @return the list containing all Veiculo objects
     */
    public List<Veiculo> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Veiculo> l = em.createQuery("select c from Veiculo c",Veiculo.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Adds the new Veiculo object passed as parameter to the data base.
     * @param v - the new Veiculo object that will be added to the data base
     * @throws Exception
     */
    public void add(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.create(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the Veiculo object passed as parameter in the data base.
     * @param v - the updated Veiculo object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.update(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Veiculo object passed as parameter from the data base.
     * @param v - the Veiculo object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.delete(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
