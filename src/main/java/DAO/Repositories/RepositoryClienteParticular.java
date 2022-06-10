package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperClienteParticular;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ClienteParticular;

import java.util.List;

public class RepositoryClienteParticular implements IRepository<ClienteParticular, Integer> {
    public ClienteParticular find(Integer Id) throws Exception {

        MapperClienteParticular m = new MapperClienteParticular();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<ClienteParticular> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<ClienteParticular> l = em.createQuery("select c from ClienteParticular c",ClienteParticular.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void add(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.create(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    public void save(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.update(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(ClienteParticular c) throws Exception {
        MapperClienteParticular m = new MapperClienteParticular();

        try {
            m.delete(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
