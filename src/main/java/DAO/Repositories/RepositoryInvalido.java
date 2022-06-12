package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperInvalido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Invalido;

import java.util.List;

public class RepositoryInvalido implements IRepository<Invalido, Integer> {

    /**
     * Finds an Invalido object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the Invalido object in the data base
     * @throws Exception
     * @return the found Invalido object or null in case it doesn't find any
     */
    public Invalido find(Integer Id) throws Exception {

        MapperInvalido m = new MapperInvalido();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all Invalido objects in the data base.
     * @throws Exception
     * @return the list containing all Invalido objects
     */
    public List<Invalido> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Invalido> l = em.createQuery("select ri from Invalido ri",Invalido.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new Invalido object passed as parameter to the data base.
     * @param ri - the new Invalido object that will be added to the data base
     * @throws Exception
     */
    public void add(Invalido ri) throws Exception {
        MapperInvalido m = new MapperInvalido();

        try {
            m.create(ri);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the Invalido object passed as parameter in the data base.
     * @param ri - the updated Invalido object that will be saved in the data base.
     * @throws Exception
     */
    public void save(Invalido ri) throws Exception {
        MapperInvalido m = new MapperInvalido();

        try {
            m.update(ri);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the Invalido object passed as parameter from the data base.
     * @param ri - the Invalido object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(Invalido ri) throws Exception {
        MapperInvalido m = new MapperInvalido();

        try {
            m.delete(ri);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
