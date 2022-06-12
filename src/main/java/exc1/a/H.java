package exc1.a;

import jakarta.persistence.*;

public class H {
    /**
     * Creates an object Veiculo with the respective object Veiculo information associated to the object Gps, and associates
     * it with an object Cliente.
     * @param regTag is the value of property 'matricula' of object Veiculo to be created.
     * @param clientNif is the value of property 'nif' of object Veiculo to be created.
     * @param name is the value of property 'nomecondutor' of object Veiculo to be created.
     * @param telephone is the value of property 'telefone' of object Veiculo to be created.
     * @param alarms is the value of property 'numalarmes' of object Veiculo to be created.
     * @param gps is the value of property 'gps' of object Veiculo to be created.
     * @param longitude is the value of property 'longitude' of object ZonaVerde to be created.
     * @param latitude is the value of property 'latitude' of object ZonaVerde to be created.
     * @param radius is the value of property 'raio' of object ZonaVerde to be created.
     * @throws Exception if any parameter violate the integrity constraints of any object.
     */
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
