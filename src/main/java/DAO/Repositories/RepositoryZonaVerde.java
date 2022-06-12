package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperZonaVerde;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ZonaVerde;
import model.ZonaverdeId;

import java.util.List;

public class RepositoryZonaVerde implements IRepository<ZonaVerde, ZonaverdeId> {

    /**
     * Finds a ZonaVerde object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the ZonaVerde object in the data base
     * @throws Exception
     * @return the found ZonaVerde object or null in case it doesn't find any
     */
    public ZonaVerde find(ZonaverdeId Id) throws Exception {

        MapperZonaVerde m = new MapperZonaVerde();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all ZonaVerde objects in the data base.
     * @throws Exception
     * @return the list containing all ZonaVerde objects
     */
    public List<ZonaVerde> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<ZonaVerde> l = em.createQuery("select zv from ZonaVerde zv",ZonaVerde.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new ZonaVerde object passed as parameter to the data base.
     * @param zv - the new ZonaVerde object that will be added to the data base
     * @throws Exception
     */
    public void add(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.create(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the ZonaVerde object passed as parameter in the data base.
     * @param zv - the updated ZonaVerde object that will be saved in the data base.
     * @throws Exception
     */
    public void save(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.update(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the ZonaVerde object passed as parameter from the data base.
     * @param zv - the ZonaVerde object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.delete(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
