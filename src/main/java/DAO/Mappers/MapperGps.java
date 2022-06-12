package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Gps;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperGps implements IMapper<Gps, Integer> {
    /**
     * Creates an object Gps saving it on database.
     * @param g is the object Gps to be created.
     * @throws Exception
     */
    public void create(Gps g) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(g);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Searches an object Gps based on its id.
     * @param id is the key of object Gps.
     * @return an object Gps which key is equals to id.
     * @throws Exception
     */
    public Gps read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Gps g =  em.find(Gps.class, id, LockModeType.PESSIMISTIC_READ);
            ds.validateWork();
            return g;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }


    /**
     * Updates an object Gps saving its changes on database.
     * @param g is the object Gps to be updated.
     * @throws Exception
     */
    public void update(Gps g) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Gps g1 = em.find(Gps.class, g.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (g1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            g1.setId(g.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    /**
     * Deletes an object Gps from database.
     * @param g is the object Gps to be deleted.
     * @throws Exception
     */
    public void delete(Gps g) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Gps g1 = em.find(Gps.class, g.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (g1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(g1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
