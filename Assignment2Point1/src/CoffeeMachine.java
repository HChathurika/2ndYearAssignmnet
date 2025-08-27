public class CoffeeMachine {
    private boolean on;
    private String CoffeeType;
    private int CoffeeAmount;

    public CoffeeMachine() {
        this.on = false;
        this.CoffeeType = "normal";
        this.CoffeeAmount = 10;

    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public boolean isOn() {
        return on;

    }

    public void setCoffeeType(String type) {
        if (on && (type.equals("Caputuno") || type.equals("espresso"))) {
            CoffeeType = type;
        }
    }

    public String getCoffeeType() {
        return CoffeeType;
    }

    public void setCoffeeAmount(int amount) {
        if (on && amount >= 10 && amount <= 80) {
            CoffeeAmount = amount;
        }
    }


    public int getCoffeeAmount() {
        return CoffeeAmount;


    }
}
