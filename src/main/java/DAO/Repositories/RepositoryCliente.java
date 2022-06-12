package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperCliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Cliente;

import java.util.List;

public class RepositoryCliente implements IRepository<Cliente, Integer> {

    /**
     * Finds a Cliente object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Cliente object in the data base
     * @throws Exception
     * @return the found Cliente object or null in case it doesn't find any
     */
    public Cliente find(Integer Id) throws Exception {

        MapperCliente m = new MapperCliente();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Cliente objects in the data base.
     * @throws Exception
     * @return the list containing all Cliente objects
     */
    public List<Cliente> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Cliente> l = em.createQuery("select c from Cliente c",Cliente.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new Cliente object passed as parameter to the data base.
     * @param c - the new Cliente object that will be added to the data base
     * @throws Exception
     */
    public void add(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.create(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the Cliente object passed as parameter in the data base.
     * @param c - the updated Cliente object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.update(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Cliente object passed as parameter from the data base.
     * @param c - the Cliente object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.delete(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
