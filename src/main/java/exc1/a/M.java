package exc1.a;

import jakarta.persistence.*;

public class M {
    //function

    /**
     * Automatically, when an object Alarme is created, the property 'numalarme' number of object Veiculo is updated.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
    public void testNumAlarms_trigger() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("insert into processado(longitude, latitude, dat, gps, rnp)\n" +
                                              "\t\tvalues(90.8, 2.2, '2022-03-10', 1, 2);");

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
