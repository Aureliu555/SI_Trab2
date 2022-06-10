package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperInvalido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Invalido;

import java.util.List;

public class RepositoryInvalido implements IRepository<Invalido, Integer> {
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
