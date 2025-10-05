package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import datasource.MariaDbJpaConnection;
import java.util.List;

public class CurrencyDao {

    /**
     * Persist a new currency into the database
     */
    public void persist(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error persisting currency: " + e.getMessage());
        }
    }

    /**
     * Find a currency by its ID
     */
    public Currency find(int id) {
        return MariaDbJpaConnection.getInstance().find(Currency.class, id);
    }

    /**
     * Retrieve all currencies from the database
     */
    public List<Currency> findAll() {
        return MariaDbJpaConnection.getInstance()
                .createQuery("SELECT c FROM Currency c", Currency.class)
                .getResultList();
    }

    /**
     * Update an existing currency
     */
    public void update(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error updating currency: " + e.getMessage());
        }
    }

    /**
     * Delete a currency from the database
     */
    public void delete(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        try {
            em.getTransaction().begin();
            // Must ensure the object is managed before removing
            if (!em.contains(c)) {
                c = em.merge(c);
            }
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
