package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperZonaVerde;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ZonaVerde;
import model.ZonaverdeId;

import java.util.List;

public class RepositoryZonaVerde implements IRepository<ZonaVerde, ZonaverdeId> {
    public ZonaVerde find(ZonaverdeId Id) throws Exception {

        MapperZonaVerde m = new MapperZonaVerde();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<ZonaVerde> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<ZonaVerde> l = em.createQuery("select zv from ZonaVerde zv",ZonaVerde.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void add(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.create(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void save(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.update(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(ZonaVerde zv) throws Exception {
        MapperZonaVerde m = new MapperZonaVerde();

        try {
            m.delete(zv);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
