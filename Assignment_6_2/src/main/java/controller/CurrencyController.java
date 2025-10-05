package controller;

import model.Currency;
import model.CurrencyModel;

import java.util.List;

public class CurrencyController {
    private final CurrencyModel model;

    public CurrencyController(CurrencyModel model) {
        this.model = model;
    }

    public List<Currency> getCurrencies() {
        return model.getCurrencies();
    }

    public double convert(double amount, String fromCode, String toCode) {
        return model.convert(amount, fromCode, toCode);
    }
}
