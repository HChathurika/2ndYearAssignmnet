package dao;

import entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import datasource.MariaDbJpaConnection;

import java.util.List;

public class CurrencyDao {


    public void persist(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public Currency find(int id) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        return em.find(Currency.class, id);
    }

    public List<Currency> findAll() {
        EntityManager em = MariaDbJpaConnection.getInstance();
        TypedQuery<Currency> q = em.createQuery("select c from Currency c", Currency.class);
        return q.getResultList();
    }

    public void update(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public void delete(Currency c) {
        EntityManager em = MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(em.contains(c) ? c : em.merge(c));
        em.getTransaction().commit();
    }


}
