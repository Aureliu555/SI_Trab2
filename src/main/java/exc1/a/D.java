package exc1.a;

import jakarta.persistence.*;

//Already functional
public class D {
    /**
     * Creates an object Cliente and an object ClienteParticular (with 'cpNif' property) with theirs associations and
     * save them on database.
     * @param cc is the 'cc' of the new object ClienteParticular.
     * @param nif is the property 'nif' for both Cliente and ClienteParticular new objects.
     * @param name is the property 'name' for the new object Cliente.
     * @param telephone is the property 'telefone' for the new object Cliente.
     * @param address is the property 'morada' for the new object Cliente.
     * @param cpRef is the property 'cpnif' for the new object Cliente.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
    public void addPrivateClient(Integer cc, Integer nif, String name, String telephone, String address, Integer cpRef) throws Exception {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
            EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6)");

            q.setParameter(1, cc);
            q.setParameter(2, nif);
            q.setParameter(3, name);
            q.setParameter(4, telephone);
            q.setParameter(5, address);
            q.setParameter(6, cpRef);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }


    /**
     * Creates an object Cliente (without property 'cpNif') and an object ClienteParticular with theirs associations and
     * save them on database.
     * @param cc is the 'cc' of the new object ClienteParticular.
     * @param nif is the property 'nif' for both Cliente and ClienteParticular new objects.
     * @param name is the property 'name' for the new object Cliente.
     * @param telephone is the property 'telefone' for the new object Cliente.
     * @param address is the property 'morada' for the new object Cliente.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
    public void addPrivateClient(Integer cc, Integer nif, String name, String telephone, String address) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5)");

            q.setParameter(1, cc);
            q.setParameter(2, nif);
            q.setParameter(3, name);
            q.setParameter(4, telephone);
            q.setParameter(5, address);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Deletes an object ClienteParticular from database permanently.
     * @param cc is the property 'cc' of the object ClienteParticular to be deleted.
     * @throws Exception if an object ClienteParticular in database with the property 'cc' equals to the passed as
     * parameter is not found.
     */
    public void removePrivateClient(Integer cc) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call remove_from_clienteParticular(?1)");

            q.setParameter(1, cc);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            assert em != null;
            em.close();
            emf.close();
        }
    }

    /**
     * Updates an object ClienteParticular and Cliente (with property 'cpNif') with the new data passed on parameters
     * and saves on database.
     * @param cc is the substitute 'cc' of the object ClienteParticular to be updated.
     * @param nif is the substitute of property 'nif' of both Cliente and ClienteParticular objects.
     * @param name is the substitute for property 'name' of object Cliente.
     * @param telephone is the substitute of property 'telefone' of object Cliente.
     * @param address is the substitute of property 'morada' of object Cliente to be updated.
     * @param oldNif is the old 'nif' property of the objects Cliente and ClienteParticular we want to update.
     * @param cpRef is the substitute of property 'cpNif' of object Cliente to be updated.
     * @throws Exception if any parameter violate the integrity constraints of any object (Cliente and ClienteParticular).
     */
    public void updatePrivateClient(Integer cc, Integer nif, String name, String telephone, String address,Integer oldNif,Integer cpRef) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call update_from_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6, ?7)");

            q.setParameter(1, cc);
            q.setParameter(2, nif);
            q.setParameter(3, name);
            q.setParameter(4, telephone);
            q.setParameter(5, address);
            q.setParameter(6, oldNif);
            q.setParameter(7, cpRef);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            assert em != null;
            em.close();
            emf.close();
        }
    }

    /**
     * Updates an object ClienteParticular and Cliente (without property 'cpNif') with the new data passed on parameters
     * and saves on database.
     * @param cc is the substitute 'cc' of the object ClienteParticular to be updated.
     * @param nif is the substitute of property 'nif' of both Cliente and ClienteParticular objects.
     * @param name is the substitute for property 'name' of object Cliente.
     * @param telephone is the substitute of property 'telefone' of object Cliente.
     * @param address is the substitute of property 'morada' of object Cliente to be updated.
     * @param oldNif is the old 'nif' property of the objects Cliente and ClienteParticular we want to update.
     * @throws Exception if any parameter violate the integrity constraints of any object (Cliente and ClienteParticular).
     */
    public void updatePrivateClient(Integer cc, Integer nif, String name, String telephone, String address,Integer oldNif) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call update_from_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6)");

            q.setParameter(1, cc);
            q.setParameter(2, nif);
            q.setParameter(3, name);
            q.setParameter(4, telephone);
            q.setParameter(5, address);
            q.setParameter(6, oldNif);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            assert em != null;
            em.close();
            emf.close();
        }
    }
}
