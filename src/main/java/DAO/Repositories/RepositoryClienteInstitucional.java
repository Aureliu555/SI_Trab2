package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperClienteInstitucional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ClienteInstitucional;

import java.util.List;

public class RepositoryClienteInstitucional implements IRepository<ClienteInstitucional, Integer> {
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
