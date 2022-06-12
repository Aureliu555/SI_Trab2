package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperAlarme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Alarme;

import java.util.List;

public class RepositoryAlarme implements IRepository<Alarme, Integer> {
    public Alarme find(Integer Id) throws Exception {

        MapperAlarme m = new MapperAlarme();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Alarme> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Alarme> l = em.createQuery("select a from Alarme a",Alarme.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void add(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.create(a);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void save(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.update(a);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(Alarme a) throws Exception {
        MapperAlarme m = new MapperAlarme();

        try {
            m.delete(a);
        }
        //to catch the errors
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
