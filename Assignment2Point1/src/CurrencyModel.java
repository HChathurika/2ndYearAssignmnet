package Model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyModel {
    private final Map<String, Double> rates;

    public CurrencyModel() {
        rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("GBP", 0.79);
        rates.put("JPY", 147.0);
    }

    public double getRate(String currency) {
        if (!rates.containsKey(currency)) {
            throw new IllegalArgumentException("Unknown currency: " + currency);
        }
        return rates.get(currency);
    }
}
