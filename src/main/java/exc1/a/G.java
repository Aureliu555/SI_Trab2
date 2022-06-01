package exc1.a;

import jakarta.persistence.*;

public class G {
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
