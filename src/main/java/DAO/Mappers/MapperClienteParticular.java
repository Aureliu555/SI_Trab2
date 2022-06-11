package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ClienteParticular;

public class MapperClienteParticular implements IMapper<ClienteParticular, Integer> {
    public void create(ClienteParticular c) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(c);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public ClienteParticular read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteParticular c =  em.find(ClienteParticular.class, id, LockModeType.PESSIMISTIC_READ );
            ds.validateWork();

            return c;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(ClienteParticular c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteParticular c1 = em.find(ClienteParticular.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            c1.setId(c.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(ClienteParticular c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteParticular c1 = em.find(ClienteParticular.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(c1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
