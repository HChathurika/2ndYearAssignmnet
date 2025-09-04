package Task3;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String fuel, int capacity) {
        super("Bus", fuel, "Yellow");
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Capacity: " + capacity + " passengers";
    }
}
