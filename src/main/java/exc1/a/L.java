package exc1.a;

import jakarta.persistence.*;

public class L {
    //procedure
    public void disableClientOnDeletion(Boolean condition) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

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
