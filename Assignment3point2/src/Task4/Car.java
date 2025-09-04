package Task4;

public class Car extends AbstractVehicle {
    public Car(String fuel, String color, double fuelEfficiency) {
        super("Car", fuel, color, fuelEfficiency);
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Fuel Efficiency: " + fuelEfficiency + " km/l";
    }
}

