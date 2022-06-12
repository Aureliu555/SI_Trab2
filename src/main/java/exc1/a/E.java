package exc1.a;

import jakarta.persistence.*;

import java.util.List;

public class E {
    /**
     * Returns the total number of objects Alarme for a given year and object Veiculo passed as parameters.
     * @param year is the year of alarms we want to count.
     * @param regTag is the reference of object Veiculo.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
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

    /**
     * Returns the total number of objects Alarme for a given year passed as parameter
     * @param year is the year of alarms we want to count.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
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

