package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperClienteParticular;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ClienteParticular;

import java.util.List;

public class RepositoryClienteParticular implements IRepository<ClienteParticular, Integer> {

    /**
     * Finds a ClienteParticular object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the ClienteParticular object in the data base
     * @throws Exception
     * @return the found ClienteParticular object or null in case it doesn't find any
     */
    public ClienteParticular find(Integer Id) throws Exception {

        MapperClienteParticular m = new MapperClienteParticular();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all ClienteParticular objects in the data base.
     * @throws Exception
     * @return the list containing all ClienteParticular objects
     */
    public List<ClienteParticular> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<ClienteParticular> l = em.createQuery("select c from ClienteParticular c",ClienteParticular.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new ClienteParticular object passed as parameter to the data base.
     * @param c - the new ClienteParticular object that will be added to the data base
     * @throws Exception
     */
    public void add(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.create(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the ClienteParticular object passed as parameter in the data base.
     * @param c - the updated ClienteParticular object that will be saved in the data base.
     * @throws Exception
     */
    public void save(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.update(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the ClienteParticular object passed as parameter from the data base.
     * @param c - the ClienteParticular object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.delete(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
