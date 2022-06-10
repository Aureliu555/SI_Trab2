package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.RegistoNProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperRegistoNProcessado implements IMapper<RegistoNProcessado, Integer> {
    public void create(RegistoNProcessado rnp) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(rnp);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public RegistoNProcessado read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp =  em.find(RegistoNProcessado.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return rnp;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(RegistoNProcessado rnp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp1 = em.find(RegistoNProcessado.class, rnp.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (rnp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            rnp1.setId(rnp.getId());
            ds.validateWork();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(RegistoNProcessado rnp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp1 = em.find(RegistoNProcessado.class, rnp.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (rnp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(rnp1);
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
