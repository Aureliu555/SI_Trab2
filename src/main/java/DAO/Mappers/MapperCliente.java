package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperCliente implements IMapper<Cliente, Integer> {

    /**
     * Creates an object Cliente and then saves it on database.
     * @param c an object Cliente.
     * @throws Exception
     */
    public void create(Cliente c) throws Exception {

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
     * Searches an object Cliente on database based on its id and returns it.
     * @param id is the key of the object Cliente to be searched..
     * @return the object Cliente with the id passed as parameter.
     * @throws Exception
     */
    public Cliente read(Integer id) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Cliente c =  em.find(Cliente.class, id,LockModeType.PESSIMISTIC_READ );
            ds.validateWork();
            return c;

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * Updates an object Cliente saving its changes on database.
     * @param c is the object Cliente.
     * @throws Exception
     */
    public void update(Cliente c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Cliente c1 = em.find(Cliente.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            c1.setId(c.getId());
            ds.validateWork();
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }


    /**
     * Deletes an object Cliente from database permanently.
     * @param c is the object Cliente to be deleted.
     * @throws Exception
     */
    public void delete(Cliente c) throws Exception {
        try (DataScopeVehicleManager ds = new DataScopeVehicleManager()) {

            EntityManager em = ds.getEntityManager();
            em.flush();
            Cliente c1 = em.find(Cliente.class, c.getId(),LockModeType.PESSIMISTIC_WRITE );
            if (c1 == null)
                throw new java.lang.IllegalAccessException("Entidade inexistente");
            em.remove(c1);
            ds.validateWork();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
