package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperRegistoNProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.RegistoNProcessado;

import java.util.List;

public class RepositoryRegistoNProcessado implements IRepository<RegistoNProcessado, Integer> {
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
