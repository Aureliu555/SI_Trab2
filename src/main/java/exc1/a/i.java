package exc1.a;

import jakarta.persistence.*;

public class i {
    public void createViewOfAlarm() throws Exception {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("t41dg8");
            em = emf.createEntityManager();
            Query q = em.createNativeQuery("create or replace view list_Alarme\n" +
                    "as select alarme, v.matricula, v.nomeCondutor, pr.longitude, pr.latitude\n" +
                    "from ((alarme inner join processado as pr on (alarme.id = pr.id)) inner join gps on " +
                    "(pr.gps = gps.id)) inner join veiculo as v\n" +
                    "\t\ton (gps.matricula = v.matricula)");


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
