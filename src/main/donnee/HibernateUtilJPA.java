package igpde.gestion.donnee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


public class HibernateUtilJPA {
    private static final EntityManagerFactory entityManagerFactory;
    static {
    	entityManagerFactory = Persistence.createEntityManagerFactory( "igpde.jpa" );
    }

    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static EntityManager currentEntityManager() throws PersistenceException {
    	EntityManager em = (EntityManager) threadLocal.get();
        if (em == null) {
            em = entityManagerFactory.createEntityManager();
            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager() throws PersistenceException {
    	EntityManager em = (EntityManager) threadLocal.get();
        if (em != null) {
        	threadLocal.set(null);
            em.close();
        }
    }
}