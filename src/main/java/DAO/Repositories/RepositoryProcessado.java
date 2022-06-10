package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Processado;

import java.util.List;

public class RepositoryProcessado implements IRepository<Processado, Integer> {
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
