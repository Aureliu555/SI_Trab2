package exc1;

import java.util.List;
import jakarta.persistence.*;

import model.*;

public class a {
    public void d() throws Exception{
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
            EntityManager em = emf.createEntityManager();
            Query q = em.createNativeQuery("call add_to_clienteParticular(?1, ?2, ?3, ?4, ?5, ?6)");

            q.setParameter(1, 1);
            q.setParameter(2, 1);
            q.setParameter(3, 1);
            q.setParameter(4, 1);
            q.setParameter(5, 1);
            q.setParameter(6, 1);

            q.executeUpdate();
            em.getTransaction().commit();

        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            em.close();
            emf.close();
        }

    }
}
