package exc1.a;

import jakarta.persistence.*;

public class g {
    public void zonaVerdeValida(Double zvLongitude, Double zvLatitude, Double zvRadius, Double regLongitude, Double regLatitude) throws Exception {
                EntityManager em = null;
                EntityManagerFactory emf = null;

        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("select zonaVerdeValida(?1, ?2, ?3, ?4, ?5)");

            q.setParameter(1, zvLongitude);
            q.setParameter(2, zvLatitude);
            q.setParameter(3, zvRadius);
            q.setParameter(4, regLongitude);
            q.setParameter(5, regLatitude);

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

    public void zonaVerdeValidaTest(Double regLatitude) throws Exception {
                EntityManager em = null;
                EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("select zonaVerdeValidaTest(?1)");

            q.setParameter(1, regLatitude);

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

    public void generateAlarm() throws Exception {
                EntityManager em = null;
                EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("select generate_alarme()");

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
