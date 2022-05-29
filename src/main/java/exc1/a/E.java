package exc1.a;

import jakarta.persistence.*;

public class E {
    public void countAlarms(Integer year, String regTag) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createNativeQuery("select count_num_of_alarms(?1, ?2)");

            q.setParameter(1, year);
            q.setParameter(2, regTag);

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
