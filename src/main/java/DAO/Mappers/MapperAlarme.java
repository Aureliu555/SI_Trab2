package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Alarme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperAlarme implements IMapper<Alarme, Integer> {
    public void create(Alarme a) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(a);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public Alarme read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Alarme a =  em.find(Alarme.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(Alarme a) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Alarme a1 = em.find(Alarme.class, a.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (a1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            a1.setId(a.getId());
            ds.validateWork();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(Alarme a) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Alarme a1 = em.find(Alarme.class, a.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (a1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(a1);
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
