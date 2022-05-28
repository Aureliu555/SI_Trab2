package exc1.a;

import jakarta.persistence.*;

public class m {
    //function
    public void updateVehicleAlarms() throws Exception {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("select update_vehicleAlarms()");

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
