package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Processado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperProcessado implements IMapper<Processado, Integer> {
    /**
     * Creates an object Processado saving it on database.
     * @param rp is the object Processado to be created.
     * @throws Exception
     */
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

    /**
     * Searches an object Processado based on its id.
     * @param id is the key of object Processado.
     * @return an object Processado which key is equals to id.
     * @throws Exception
     */
    public Processado read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Processado rp =  em.find(Processado.class, id,LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            ds.validateWork();
            return rp;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object Processado saving its changes on database.
     * @param rp is the object Processado to be updated.
     * @throws Exception
     */
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

    /**
     * Deletes an object Processado from database.
     * @param rp is the object Processado to be deleted.
     * @throws Exception
     */
    public void delete(Processado rp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Processado rp1 = em.find(Processado.class, rp.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT );
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
