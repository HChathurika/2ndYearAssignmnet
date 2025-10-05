package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MariaDbJpaConnection {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("currencyPU");
    private static EntityManager em = emf.createEntityManager();

    private MariaDbJpaConnection() {}

    public static EntityManager getInstance() {
        return em;
    }
}
