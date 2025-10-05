package entity;

public class Currency {
    private String abbreviation;
    private double exchangeRate;

    public Currency(String abbreviation, double exchangeRate) {
        this.abbreviation = abbreviation;
        this.exchangeRate = exchangeRate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
