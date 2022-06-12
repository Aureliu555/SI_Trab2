package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.RegistoNProcessado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperRegistoNProcessado implements IMapper<RegistoNProcessado, Integer> {
    /**
     * Creates an object RegistoNProcessado saving it on database.
     * @param rnp is the object RegistoNProcessado to be created.
     * @throws Exception
     */
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

    /**
     * Searches an object RegistoNProcessado based on its id.
     * @param id is the key of object RegistoNProcessado.
     * @return an object RegistoNProcessado which key is equals to id.
     * @throws Exception
     */
    public RegistoNProcessado read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp =  em.find(RegistoNProcessado.class, id,LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            ds.validateWork();
            return rnp;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object RegistoNProcessado saving its changes on database.
     * @param rnp is the object RegistoNProcessado to be updated.
     * @throws Exception
     */
    public void update(RegistoNProcessado rnp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp1 = em.find(RegistoNProcessado.class, rnp.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            if (rnp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            rnp1.setId(rnp.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Deletes an object RegistoNProcessado from database.
     * @param rnp is the object RegistoNProcessado to be deleted.
     * @throws Exception
     */
    public void delete(RegistoNProcessado rnp) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            RegistoNProcessado rnp1 = em.find(RegistoNProcessado.class, rnp.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            if (rnp1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(rnp1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
