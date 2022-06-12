package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.ClienteInstitucional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperClienteInstitucional implements IMapper<ClienteInstitucional, Integer> {
    /**
     * Creates an object ClienteInstitucional saving it on database.
     * @param c is the object ClienteInstitucional.
     * @throws Exception
     */
    public void create(ClienteInstitucional c) throws Exception {

        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.persist(c);
            ds.validateWork();

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Searches for an object ClienteInstitucional based on its id.
     * @param id is the key of the object ClienteInstitucional to be searched.
     * @return the object ClienteInstitucional with the id in case.
     * @throws Exception
     */
    public ClienteInstitucional read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteInstitucional c =  em.find(ClienteInstitucional.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return c;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object ClienteInstitucional saving its changes on database.
     * @param c is the object ClienteInstitucional to be updated.
     * @throws Exception
     */
    public void update(ClienteInstitucional c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteInstitucional c1 = em.find(ClienteInstitucional.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            c1.setId(c.getId());
            ds.validateWork();
        }

        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }

    /**
     * Deletes an object ClienteInstitucional from database.
     * @param c is the object ClienteInstitucional to be deleted.
     * @throws Exception
     */
    public void delete(ClienteInstitucional c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            ClienteInstitucional c1 = em.find(ClienteInstitucional.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(c1);
            ds.validateWork();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
