package Task4;
public class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle(String color, double efficiency) {
        super("ElectricMotorcycle", "Electric", color, efficiency);
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Efficiency: " + fuelEfficiency + " kWh/km";
    }
}

