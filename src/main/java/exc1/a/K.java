package exc1.a;

import jakarta.persistence.*;


public class K {
    //procedure

    /**
     * Deletes existing objects Invalido that are longer than 15 days.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
    public void deleteInvalidRecordsFromUnprocessed() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call delete_Invalido_in_registoNProcessado()");

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
