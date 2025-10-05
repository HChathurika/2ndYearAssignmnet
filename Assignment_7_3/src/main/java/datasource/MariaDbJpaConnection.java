package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbJpaConnection {


    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static synchronized EntityManager getInstance() {
        // synchronized to avoid race in multi-threaded startup
        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }

    public static synchronized void close() {
        if (em != null) {
            if (em.isOpen()) em.close();
            em = null;
        }
        if (emf != null) {
            if (emf.isOpen()) emf.close();
            emf = null;
}
    }


}
