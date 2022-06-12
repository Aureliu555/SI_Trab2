package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperAlarme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Alarme;

import java.util.List;

public class RepositoryAlarme implements IRepository<Alarme, Integer> {

    /**
     * Finds an Alarme object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Alarme object in the data base
     * @throws Exception
     * @return the found Alarme object or null in case it doesn't find any
     */
    public Alarme find(Integer Id) throws Exception {

        MapperAlarme m = new MapperAlarme();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Alarme objects in the data base.
     * @throws Exception
     * @return the list containing all Alarme objects
     */
    public List<Alarme> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Alarme> l = em.createQuery("select a from Alarme a",Alarme.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new Alarme object passed as parameter to the data base.
     * @param a - the new Alarme object that will be added to the data base
     * @throws Exception
     */
    public void add(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.create(a);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the Alarme object passed as parameter in the data base.
     * @param a - the updated Alarme object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.update(a);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Alarme object passed as parameter from the data base.
     * @param a - the Alarme object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.delete(a);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
