package Task3;


public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;

    public AbstractVehicle(String type, String fuel, String color) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    // Default implementation of charge for non-electric vehicles
    @Override
    public void charge() {
        System.out.println(type + ": Not possible to charge.");
    }

    @Override
    public abstract String getInfo();
}

