package Task4;


public class Motorcycle extends AbstractVehicle {
    public Motorcycle(String fuel, String color, double fuelEfficiency) {
        super("Motorcycle", fuel, color, fuelEfficiency);
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Fuel Efficiency: " + fuelEfficiency + " km/l";
    }
}

