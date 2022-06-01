package exc1.a;

import jakarta.persistence.*;

public class H {
    public void createAndAssociateVehicle(String regTag, Integer clientNif, String name, String telephone, Integer alarms,
                                          Integer gps, Double longitude, Double latitude, Double radius) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Query q = em.createNativeQuery("call create_and_associate_Veiculo(?1, ?2, ?3, ?4, ?5, ?6, ?7::Real, ?8::Real, ?9::Real)");

            q.setParameter(1, regTag);
            q.setParameter(2, clientNif);
            q.setParameter(3, name);
            q.setParameter(4, telephone);
            q.setParameter(5, alarms);
            q.setParameter(6, gps);
            if (longitude != null) q.setParameter(7, longitude);
            if (latitude != null) q.setParameter(8, latitude);
            if (radius != null) q.setParameter(9, radius);

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
