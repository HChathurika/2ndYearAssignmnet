Package Model;

// currency.java
public class currency {
    private String code;
    private String name;
    private double rateToUSD; // conversion rate compared to USD

    public currency(String code, String name, double rateToUSD) {
        this.code = code;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
