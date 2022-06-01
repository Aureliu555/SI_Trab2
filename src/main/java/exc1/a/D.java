package exc1.a;

import jakarta.persistence.*;

//Already functional
public class D {
    public void addPrivateClient(Integer cc, Integer nif, String name, String telephone, String address, Integer cpRef) throws Exception {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
            EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query q;
            if (cpRef == 0){
                q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5)");
            }
            else {
                q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6)");
                q.setParameter(6, cpRef);
            }
            //Query q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6)");

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
}
