package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Processado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperProcessado implements IMapper<Processado, Integer> {
    public void create(Processado rp) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(rp);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Processado read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Processado rp =  em.find(Processado.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return rp;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(Processado rp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Processado rp1 = em.find(Processado.class, rp.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            if (rp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            rp1.setId(rp.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(Processado rp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Processado rp1 = em.find(Processado.class, rp.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT  );
            if (rp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(rp1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
