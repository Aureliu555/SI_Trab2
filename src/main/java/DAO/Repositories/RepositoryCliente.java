package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperCliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Cliente;

import java.util.List;

public class RepositoryCliente implements IRepository<Cliente, Integer> {
    public Cliente find(Integer Id) throws Exception {

        MapperCliente m = new MapperCliente();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Cliente> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Cliente> l = em.createQuery("select c from Cliente c",Cliente.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void add(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.create(c);
        }
        //to catch the error
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }


    public void save(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.update(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(Cliente c) throws Exception {
        MapperCliente m = new MapperCliente();

        try {
            m.delete(c);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
