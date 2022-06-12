package DAO.Mappers;

import DAI.IMapper;
import DAL.DataScopeVehicleManager;
import model.Alarme;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class MapperAlarme implements IMapper<Alarme, Integer> {
    /**
     * Creates an object Alarme and saves on database.
     * @param a is the object Alarme to be created.
     * @throws Exception if there's an object with the same id parameter in the database.
     */
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

    /**
     * Searches an object Alarme on database based on its id.
     * @param id is the key of the object Alarme to be searched.
     * @return the object Alarme with the id passed as parameter
     * @throws Exception if the object was not found.
     */
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

    /**
     * Updates an object Alarme saving it's changes on database.
     * @param a is the object Alarme to be updated.
     * @throws Exception
     */
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

    /**
     * Deletes an object Alarme from database permanently.
     * @param a is an object of type Alarme.
     * @throws Exception
     */
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
