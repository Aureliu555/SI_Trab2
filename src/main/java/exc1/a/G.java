package exc1.a;

import jakarta.persistence.*;

public class G {
    /**
     * Analyzes all objects Processado when it is created and that
     * generates the corresponding object Alarme if it is outside any of its objects ZonaVerde.
     * @throws Exception if any of data violates any rules of the database
     */
    public void test_alarm_trigger() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("insert into processado(longitude, latitude, dat, gps) values(5.8, 2.2, '2022-05-02', 1)");

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
