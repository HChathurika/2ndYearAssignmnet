package dao;

import datasource.MariaDbJpaConnection;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TransactionDao {

    private final EntityManager em = MariaDbJpaConnection.getInstance();

    public void persist(Transaction transaction) {
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    public Transaction findById(Long id) {
        return em.find(Transaction.class, id);
    }

    public List<Transaction> findAll() {
        TypedQuery<Transaction> query = em.createQuery("SELECT t FROM Transaction t", Transaction.class);
        return query.getResultList();
    }

    public void delete(Long id) {
        Transaction transaction = findById(id);
        if (transaction != null) {
            em.getTransaction().begin();
            em.remove(transaction);
            em.getTransaction().commit();
        }
    }
}
