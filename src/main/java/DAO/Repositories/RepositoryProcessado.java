package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Processado;

import java.util.List;

public class RepositoryProcessado implements IRepository<Processado, Integer> {

    /**
     * Finds a Processado object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Processado object in the data base
     * @throws Exception
     * @return the found Processado object or null in case it doesn't find any
     */
    public Processado find(Integer Id) throws Exception {

        MapperProcessado m = new MapperProcessado();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Processado objects in the data base.
     * @throws Exception
     * @return the list containing all Processado objects
     */
    public List<Processado> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Processado> l = em.createQuery("select rp from Processado rp",Processado.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new Processado object passed as parameter to the data base.
     * @param rp - the new Processado object that will be added to the data base
     * @throws Exception
     */
    public void add(Processado rp) throws Exception {
        MapperProcessado m = new MapperProcessado();

        try {
            m.create(rp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the Processado object passed as parameter in the data base.
     * @param rp - the updated Processado object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Processado rp) throws Exception {
        MapperProcessado m = new MapperProcessado();

        try {
            m.update(rp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Processado object passed as parameter from the data base.
     * @param rp - the Processado object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Processado rp) throws Exception {
        MapperProcessado m = new MapperProcessado();

        try {
            m.delete(rp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
