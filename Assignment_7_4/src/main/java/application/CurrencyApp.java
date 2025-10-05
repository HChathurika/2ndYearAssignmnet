package application;

import dao.CurrencyDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;

public class CurrencyApp {
    public static void main(String[] args) {
        CurrencyDao currencyDao = new CurrencyDao();
        TransactionDao transactionDao = new TransactionDao();

        Currency eur = new Currency("EUR", "Euro", 1.0);
        Currency sek = new Currency("SEK", "Swedish Krona", 11.0);
        currencyDao.persist(eur);
        currencyDao.persist(sek);

        double amount = 100;
        double result = amount * sek.getRate() / eur.getRate();

        Transaction t = new Transaction(amount, result, eur, sek);
        transactionDao.persist(t);

        System.out.println("✅ Transaction stored successfully!");
        System.out.println(t);
    }
}
