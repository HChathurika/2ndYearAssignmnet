package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // amount in source currency
    @Column(nullable = false)
    private double amount;

    // converted result in target currency
    @Column(nullable = false)
    private double result;

    // many transactions can have the same source currency
    @ManyToOne
    @JoinColumn(name = "from_currency_id", nullable = false)
    private Currency fromCurrency;

    // many transactions can have the same target currency
    @ManyToOne
    @JoinColumn(name = "to_currency_id", nullable = false)
    private Currency toCurrency;

    // --- Constructors ---
    public Transaction() {
        // ✅ Default constructor (required by JPA)
    }

    public Transaction(double amount, double result, Currency fromCurrency, Currency toCurrency) {
        this.amount = amount;
        this.result = result;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", result=" + result +
                ", fromCurrency=" + fromCurrency.getCode() +
                ", toCurrency=" + toCurrency.getCode() +
                '}';
    }
}
