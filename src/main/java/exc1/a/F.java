package exc1.a;

import jakarta.persistence.*;

//Already functional (working)
public class F {
    public void processUnprocessedRegistration() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call process_registoNProcessado()");

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
