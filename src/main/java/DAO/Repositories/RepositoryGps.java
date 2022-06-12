package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperGps;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Gps;

import java.util.List;

public class RepositoryGps implements IRepository<Gps, Integer> {

    /**
     * Finds a Gps object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Gps object in the data base
     * @throws Exception
     * @return the found Gps object or null in case it doesn't find any
     */
    public Gps find(Integer Id) throws Exception {

        MapperGps m = new MapperGps();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Gps objects in the data base.
     * @throws Exception
     * @return the list containing all Gps objects
     */
    public List<Gps> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Gps> l = em.createQuery("select g from Gps g",Gps.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new Gps object passed as parameter to the data base.
     * @param g - the new Gps object that will be added to the data base
     * @throws Exception
     */
    public void add(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.create(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    /**
     * Saves the changes done to the Gps object passed as parameter in the data base.
     * @param g - the updated Gps object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.update(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Gps object passed as parameter from the data base.
     * @param g - the Gps object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.delete(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
