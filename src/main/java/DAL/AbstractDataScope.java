package DAL;

import jakarta.persistence.*;

public abstract class AbstractDataScope implements AutoCloseable {

    protected class Session {
        private EntityManagerFactory ef;
        private EntityManager em;
        private boolean ok = true;

    }

    boolean isMine = true;
    boolean voted = false;

    private static final ThreadLocal<Session> threadLocal = ThreadLocal.withInitial(() -> null);


    public AbstractDataScope() {
        if (threadLocal.get()==null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("t41dg8");
            EntityManager em = emf.createEntityManager();
            Session s = new Session();
            s.ef = emf;
            s.ok = true;
            s.em = em;
            threadLocal.set(s);
            em.getTransaction().begin();
            isMine = true;
        }
        else
            isMine = false;
    }


    public EntityManager getEntityManager() {return threadLocal.get().em;}



    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        if (isMine) {
            if(threadLocal.get().ok && voted)  {
                threadLocal.get().em.getTransaction().commit();
            }
            else
                threadLocal.get().em.getTransaction().rollback();
            threadLocal.get().em.close();
            threadLocal.get().ef.close();
            threadLocal.remove();
            //ou:
            //threadLocal.set(null);
        }
        else
        if (!voted)
            cancelWork();

    }


    public void validateWork() {
        voted = true;
    }

    public void cancelWork() {
        threadLocal.get().ok = false;
        voted = true;
    }



}
