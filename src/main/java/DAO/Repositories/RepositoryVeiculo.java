package DAO.Repositories;

import DAI.IRepository;
import DAL.DataScopeVehicleManager;
import DAO.Mappers.MapperVeiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Veiculo;

import java.util.List;

public class RepositoryVeiculo implements IRepository<Veiculo, String> {
    public Veiculo find(String Id) throws Exception {

        MapperVeiculo m = new MapperVeiculo();

        try {
            return m.read(Id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public List<Veiculo> getAll() throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            List<Veiculo> l = em.createQuery("select c from Veiculo c",Veiculo.class).setLockMode(LockModeType.PESSIMISTIC_READ)
                    .getResultList();
            ds.validateWork();
            return l;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void add(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.create(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    public void save(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.update(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void delete(Veiculo v) throws Exception {
        MapperVeiculo m = new MapperVeiculo();

        try {
            m.delete(v);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
