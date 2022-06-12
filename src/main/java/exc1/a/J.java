package exc1.a;

import jakarta.persistence.*;

public class J {
    /**
     * Not working.
     * @throws Exception
     */
    public void insertIntoAlarmsAndProcessedRegistration() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("select insert_into_Alarme_and_Processado()");

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
