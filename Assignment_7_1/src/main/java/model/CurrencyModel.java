package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {
    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();
    }

    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByAbbreviation(String abbreviation) {
        return currencies.stream()
                .filter(c -> c.getAbbreviation().equalsIgnoreCase(abbreviation))
                .findFirst()
                .orElse(null);
    }
}

