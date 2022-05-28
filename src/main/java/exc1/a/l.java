package exc1.a;

import jakarta.persistence.*;

public class l {
    public void disableClientOnDeletion(Boolean condition) throws Exception {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("call disable_Cliente_on_deletion(?1)");

            q.setParameter(1, condition);
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
