package controller;

import model.Currency;
import model.CurrencyModel;
import database.CurrencyDAO;

import java.util.List;

public class CurrencyController {
    private CurrencyModel model;
    private CurrencyDAO dao;

    public CurrencyController(CurrencyModel model, CurrencyDAO dao) {
        this.model = model;
        this.dao = dao;
        loadCurrenciesFromDB();
    }

    private void loadCurrenciesFromDB() {
        List<Currency> currencies = dao.getAllCurrencies();
        for (Currency c : currencies) {
            model.addCurrency(c);
        }
    }

    public double convert(String from, String to, double amount) {
        Currency fromCurrency = model.getCurrencyByAbbreviation(from);
        Currency toCurrency = model.getCurrencyByAbbreviation(to);

        if (fromCurrency == null || toCurrency == null) {
            throw new IllegalArgumentException("Invalid currency abbreviation.");
        }

        double amountInUSD = amount / fromCurrency.getRateToUSD();
        return amountInUSD * toCurrency.getRateToUSD();
    }

    public List<Currency> getAllCurrencies() {
        return model.getCurrencies();
    }
}
