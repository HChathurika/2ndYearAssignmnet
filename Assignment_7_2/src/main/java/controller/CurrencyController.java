package controller;

import dao.CurrencyDao;

public class CurrencyController {

    private CurrencyDao currencyDao = new CurrencyDao();

    // Method to convert an amount from one currency to another
    public double convert(double amount, String fromCurrency, String toCurrency) {
        double fromRate = currencyDao.getExchangeRate(fromCurrency);
        double toRate = currencyDao.getExchangeRate(toCurrency);

        // Handle errors if currency not found or database issue
        if (fromRate == 0.0 || toRate == 0.0) {
            System.out.println("Error: Could not fetch one or both exchange rates. Please check the database.");
            return 0.0;
        }

        // Conversion formula
        return amount * (toRate / fromRate);
}
}