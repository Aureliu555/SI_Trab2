package exc1.b;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NoStoredProcedure {
    public void create_and_associate_Vehicle(String tag, Integer nifClient, String name, String tel, Integer alarms, Integer gps, Double lgtd, Double lttd, Double radius) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            int n;
            if (!((lgtd == null && lttd == null && radius == null) || (lgtd != null && lttd != null && radius != null)))
                em.getTransaction().rollback();

            Query q = em.createNativeQuery("select count(cliente.nif) from cliente where cliente.nif = nifClient");
            n = q.getFirstResult();
            if(n == 0) em.getTransaction().rollback();

            q = em.createNativeQuery("select count(cliente.nif) from cliente natural join clienteParticular " +
                    "where cliente.nif = nifClient");
            n = q.getFirstResult();
            if (n == 1) {
                q = em.createNativeQuery("select count(veiculo.nif) into n from veiculo where veiculo.nif = nifClient");
                n = q.getFirstResult();
                if (n < 3) {
                    q = em.createNativeQuery("insert into veiculo(matricula, nif, nomeCondutor, telefone, numAlarmes, gps) " +
                            "values(tag, nifClient, name, tel, alarms, gps)");
                    q.executeUpdate();
                } else em.getTransaction().rollback();
            }

            if (lgtd != null && lttd != null && radius != null) {
                q = em.createNativeQuery("insert into zonaVerde(longitude,latitude,raio,matricula) " +
                        "values (lgtd, lttd, radius, tag)");
                q.executeUpdate();
            }

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
