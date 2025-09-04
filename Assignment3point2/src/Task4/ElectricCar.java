package Task4;


public class ElectricCar extends AbstractVehicle {
    public ElectricCar(String color, double efficiency) {
        super("ElectricCar", "Electric", color, efficiency);
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color + "\n" +
                "Efficiency: " + fuelEfficiency + " kWh/km";
    }
}
