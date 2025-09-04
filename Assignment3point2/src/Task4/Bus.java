package Task4;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String fuel, int capacity, double fuelEfficiency) {
        super("Bus", fuel, "Yellow", fuelEfficiency);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Capacity: " + capacity + " passengers\n" +
                "Fuel Efficiency: " + fuelEfficiency + " km/l";
    }
}

