package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperGps;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Gps;

import java.util.List;

public class RepositoryGps implements IRepository<Gps, Integer> {
    public Gps find(Integer Id) throws Exception {

        MapperGps m = new MapperGps();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Gps> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Gps> l = em.createQuery("select g from Gps g",Gps.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void add(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.create(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void save(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.update(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(Gps g) throws Exception {
        MapperGps m = new MapperGps();

        try {
            m.delete(g);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
