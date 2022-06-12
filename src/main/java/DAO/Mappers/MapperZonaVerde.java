package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.ZonaVerde;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.ZonaverdeId;

public class MapperZonaVerde implements IMapper<ZonaVerde, ZonaverdeId> {
    /**
     * Creates an object ZonaVerde saving it on database.
     * @param zv is the object ZonaVerde to be created.
     * @throws Exception
     */
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

    /**
     * Searches an object ZonaVerde based on its id.
     * @param id is the key of object ZonaVerde.
     * @return an object ZonaVerde which key is equals to id.
     * @throws Exception
     */
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

    /**
     * Updates an object ZonaVerde saving its changes on database.
     * @param zv is the object ZonaVerde to be updated.
     * @throws Exception
     */
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

    /**
     * Deletes an object ZonaVerde from database.
     * @param zv is the object ZonaVerde to be deleted.
     * @throws Exception
     */
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
