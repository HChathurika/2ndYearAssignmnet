package dao;

import datasource.MariaDbJpaConnection;
import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CurrencyDao {

    private final EntityManager em = MariaDbJpaConnection.getInstance();

    public void persist(Currency currency) {
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public Currency findById(Long id) {
        return em.find(Currency.class, id);
    }

    public List<Currency> findAll() {
        TypedQuery<Currency> query = em.createQuery("SELECT c FROM Currency c", Currency.class);
        return query.getResultList();
    }

    public void update(Currency currency) {
        em.getTransaction().begin();
        em.merge(currency);
        em.getTransaction().commit();
    }

    public void delete(Long id) {
        Currency currency = findById(id);
        if (currency != null) {
            em.getTransaction().begin();
            em.remove(currency);
            em.getTransaction().commit();
        }
    }
}
