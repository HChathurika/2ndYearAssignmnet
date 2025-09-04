package Task1;


public class Bus implements Vehicle {
    private String fuel;
    private int capacity;

    public Bus(String fuel, int capacity) {
        this.fuel = fuel;
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Bus Information:\n" +
                "Type: Bus\n" +
                "Fuel: " + fuel + "\n" +
                "Capacity: " + capacity + " passengers";
    }
}
