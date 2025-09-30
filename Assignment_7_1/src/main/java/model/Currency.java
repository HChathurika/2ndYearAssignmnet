package model;

public class Currency {
    private int id;
    private String abbreviation;
    private String name;
    private double rateToUSD;

    public Currency(int id, String abbreviation, String name, double rateToUSD) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getRateToUSD() { return rateToUSD; }
    public void setRateToUSD(double rateToUSD) { this.rateToUSD = rateToUSD; }

    @Override
    public String toString() {
        return abbreviation + " - " + name + " : " + rateToUSD;
    }
}
