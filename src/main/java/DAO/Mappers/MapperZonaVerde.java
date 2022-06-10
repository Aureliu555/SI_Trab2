package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.ZonaVerde;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ZonaverdeId;

public class MapperZonaVerde implements IMapper<ZonaVerde, ZonaverdeId> {
    public void create(ZonaVerde zv) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(zv);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public ZonaVerde read(ZonaverdeId id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ZonaVerde zv =  em.find(ZonaVerde.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return zv;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void update(ZonaVerde zv) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ZonaVerde zv1 = em.find(ZonaVerde.class, zv.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (zv1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            zv1.setId(zv.getId());
            ds.validateWork();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    public void delete(ZonaVerde zv) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ZonaVerde zv1 = em.find(ZonaVerde.class, zv.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (zv1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(zv1);
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
