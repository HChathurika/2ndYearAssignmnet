package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CurrencyModel {
    private final Map<String, Currency> currencies = new LinkedHashMap<>();

    public CurrencyModel() {
        // Hardcoded for now
        add(new Currency("USD", "United States Dollar", 1.00));
        add(new Currency("EUR", "Euro", 1.08));
        add(new Currency("GBP", "British Pound", 1.27));
        add(new Currency("JPY", "Japanese Yen", 0.0068));
        add(new Currency("CAD", "Canadian Dollar", 0.72));
    }

    private void add(Currency c) {
        currencies.put(c.getCode(), c);
    }

    public List<Currency> getCurrencies() {
        return new ArrayList<>(currencies.values());
    }

    public Currency getByCode(String code) {
        return currencies.get(code);
    }

    public double convert(double amount, String fromCode, String toCode) {
        Currency from = getByCode(fromCode);
        Currency to = getByCode(toCode);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Unknown currency code");
        }
        double amountInUSD = amount * from.getRateToUSD();
        return amountInUSD / to.getRateToUSD();
    }
}
