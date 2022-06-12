package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Invalido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperInvalido implements IMapper<Invalido, Integer> {
    /**
     * Creates an object Invalido saving it on database.
     * @param ri is the object Invalido to be created.
     * @throws Exception
     */
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

    /**
     * Searches an object Invalido based on its id.
     * @param id is the key of object Invalido.
     * @return an object Invalido which key is equals to id.
     * @throws Exception
     */
    public Invalido read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Invalido ri =  em.find(Invalido.class, id,LockModeType.OPTIMISTIC_FORCE_INCREMENT );
            ds.validateWork();
            return ri;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object Invalido saving its changes on database.
     * @param ri is the object Invalido to be updated.
     * @throws Exception
     */
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

    /**
     * Deletes an object Invalido from database.
     * @param ri is the object Invalido to be deleted.
     * @throws Exception
     */
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
