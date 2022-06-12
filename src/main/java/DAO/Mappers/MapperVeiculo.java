package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import model.Veiculo;

public class MapperVeiculo implements IMapper<Veiculo, String> {
    /**
     * Creates an object Veiculo saving it on database.
     * @param v is the object Veiculo to be created.
     * @throws Exception
     */
    public void create(Veiculo v) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(v);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Searches an object Veiculo based on its id.
     * @param id is the key of object Veiculo.
     * @return an object Veiculo which key is equals to id.
     * @throws Exception
     */
    public Veiculo read(String id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Veiculo v =  em.find(Veiculo.class, id, LockModeType.PESSIMISTIC_READ );
            ds.validateWork();

            return v;

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object Veiculo saving its changes on database.
     * @param v is the object Veiculo to be updated.
     * @throws Exception
     */
    public void update(Veiculo v) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            String vToSee = v.getId();
            Veiculo v1 = em.find(Veiculo.class, v.getId(),LockModeType.PESSIMISTIC_WRITE );

            if (v1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            v1.setId(v.getId());
            ds.validateWork();

        }

        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    /**
     * Deletes an object Veiculo from database.
     * @param v is the object Veiculo to be deleted.
     * @throws Exception
     */
    public void delete(Veiculo v) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Veiculo v1 = em.find(Veiculo.class, v.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (v1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(v1);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
