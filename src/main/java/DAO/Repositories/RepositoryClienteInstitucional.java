package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperClienteInstitucional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ClienteInstitucional;

import java.util.List;

public class RepositoryClienteInstitucional implements IRepository<ClienteInstitucional, Integer> {

    /**
     * Finds a ClienteInstitucional object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the ClienteInstitucional object in the data base
     * @throws Exception
     * @return the found ClienteInstitucional object or null in case it doesn't find any
     */
    public ClienteInstitucional find(Integer Id) throws Exception {

        MapperClienteInstitucional m = new MapperClienteInstitucional();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all ClienteInstitucional objects in the data base.
     * @throws Exception
     * @return the list containing all ClienteInstitucional objects
     */
    public List<ClienteInstitucional> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<ClienteInstitucional> l = em.createQuery("select c from ClienteInstitucional c",ClienteInstitucional.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new ClienteInstitucional object passed as parameter to the data base.
     * @param c - the new ClienteInstitucional object that will be added to the data base
     * @throws Exception
     */
    public void add(ClienteInstitucional c) throws Exception {
        MapperClienteInstitucional m = new MapperClienteInstitucional();

        try {
            m.create(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the ClienteInstitucional object passed as parameter in the data base.
     * @param c - the updated ClienteInstitucional object that will be saved in the data base.
     * @throws Exception
     */
    public void save(ClienteInstitucional c) throws Exception {
        MapperClienteInstitucional m = new MapperClienteInstitucional();

        try {
            m.update(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the ClienteInstitucional object passed as parameter from the data base.
     * @param c - the ClienteInstitucional object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(ClienteInstitucional c) throws Exception {
        MapperClienteInstitucional m = new MapperClienteInstitucional();

        try {
            m.delete(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
