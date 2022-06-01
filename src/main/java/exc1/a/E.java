package exc1.a;

import jakarta.persistence.*;

import java.util.List;

public class E {
    public List<Integer> countAlarms(Integer year, String regTag) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

              Query q = em.createNativeQuery("select count_num_of_alarms(?1, ?2)");

            q.setParameter(1, year);
            q.setParameter(2, regTag);

            List ret = q.getResultList();
            em.getTransaction().commit();
            return ret;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            assert em != null;
            em.close();
            emf.close();
        }
    }

    public List<Integer> countAlarms(Integer year) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("select count_num_of_alarms(?1)");

            q.setParameter(1, year);

            List ret = q.getResultList();
            em.getTransaction().commit();
            return ret;

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

