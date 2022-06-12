package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Invalido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperInvalido implements IMapper<Invalido, Integer> {
    public void create(Invalido ri) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(ri);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Invalido read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Invalido ri =  em.find(Invalido.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return ri;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(Invalido ri) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Invalido ri1 = em.find(Invalido.class, ri.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT  );
            if (ri1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            ri1.setId(ri.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(Invalido ri) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Invalido ri1 = em.find(Invalido.class, ri.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT  );
            if (ri1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(ri1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
