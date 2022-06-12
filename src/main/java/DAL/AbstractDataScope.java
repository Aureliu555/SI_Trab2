package DAL;

import jakarta.persistence.*;

// Object responsible for managing the current running session of work
public abstract class AbstractDataScope implements AutoCloseable {

    // This object idetifies an instant of work and creates a new connection to the data base using EntityManager
    protected class Session {
        private EntityManagerFactory ef;
        private EntityManager em;
        private boolean ok = true;

    }

    // identifies if I am the holder of the thread or not
    boolean isMine = true;

    // variable used to cancel the work in case not everybody voted for commit
    boolean voted = false;

    // creates a thread by which the session will be processed
    private static final ThreadLocal<Session> threadLocal = ThreadLocal.withInitial(() -> null);

    /**
     * Creates a new session of work in case the holder is me, otherwise it updates isMine variable to
     * false indicating that someone already started a session of work in the same thread
     */
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

    /**
     * @return the entityManager connection from the current session of work
     */
    public EntityManager getEntityManager() {return threadLocal.get().em;}


    /**
     * Closes the current session of work with commit or rollback
     */
    @Override
    public void close() throws Exception {
        if (isMine) {
            if(threadLocal.get().ok && voted)  {
                threadLocal.get().em.getTransaction().commit();
            }
            else
                threadLocal.get().em.getTransaction().rollback();
            threadLocal.get().em.close();
            threadLocal.get().ef.close();
            threadLocal.remove();
        }
        else
        if (!voted)
            cancelWork();
    }

    /**
     * Validates the work done until the moment of its call by update the variable voted to true
     */
    public void validateWork() {
        voted = true;
    }

    /**
     * Cancels the work done until the moment of its call by defining the current transaction's status to not ok
     * and updating the variable voted to true showing that the callers work is done
     */
    public void cancelWork() {
        threadLocal.get().ok = false;
        voted = true;
    }



}
