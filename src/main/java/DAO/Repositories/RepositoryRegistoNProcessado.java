package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperRegistoNProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.RegistoNProcessado;

import java.util.List;

public class RepositoryRegistoNProcessado implements IRepository<RegistoNProcessado, Integer> {

    /**
     * Finds a RegistoNProcessado object identified by the Id in the data base.
     * @param Id - the id (primary key) that indetifies the RegistoNProcessado object in the data base
     * @throws Exception
     * @return the found RegistoNProcessado object or null in case it doesn't find any
     */
    public RegistoNProcessado find(Integer Id) throws Exception {

        MapperRegistoNProcessado m = new MapperRegistoNProcessado();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Gets all RegistoNProcessado objects in the data base.
     * @throws Exception
     * @return the list containing all RegistoNProcessado objects
     */
    public List<RegistoNProcessado> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<RegistoNProcessado> l = em.createQuery("select rnp from RegistoNProcessado rnp",RegistoNProcessado.class).setLockMode(LockModeType.PESSIMISTIC_READ)
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
     * Adds the new RegistoNProcessado object passed as parameter to the data base.
     * @param rnp - the new RegistoNProcessado object that will be added to the data base
     * @throws Exception
     */
    public void add(RegistoNProcessado rnp) throws Exception {
        MapperRegistoNProcessado m = new MapperRegistoNProcessado();

        try {
            m.create(rnp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Saves the changes done to the RegistoNProcessado object passed as parameter in the data base.
     * @param rnp - the updated RegistoNProcessado object that will be saved in the data base.
     * @throws Exception
     */
    public void save(RegistoNProcessado rnp) throws Exception {
        MapperRegistoNProcessado m = new MapperRegistoNProcessado();

        try {
            m.update(rnp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes the RegistoNProcessado object passed as parameter from the data base.
     * @param rnp - the RegistoNProcessado object that will be deleted from the data base
     * @throws Exception
     */
    public void delete(RegistoNProcessado rnp) throws Exception {
        MapperRegistoNProcessado m = new MapperRegistoNProcessado();

        try {
            m.delete(rnp);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
