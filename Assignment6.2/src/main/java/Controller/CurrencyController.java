package Controller;

import Model.CurrencyModel;

public class CurrencyController {
    private final CurrencyModel model;

    public CurrencyController(CurrencyModel model) {
        this.model = model;
    }

    public double convert(double amount, String from, String to) {
        double fromRate = model.getRate(from);
        double toRate = model.getRate(to);
        return amount * (toRate / fromRate);
    }
}
