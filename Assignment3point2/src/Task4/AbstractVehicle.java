package Task4;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fuel;
    protected String color;
    protected double fuelEfficiency; // km/l for fuel, kWh/km for electric

    public AbstractVehicle(String type, String fuel, String color, double fuelEfficiency) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public void charge() {
        System.out.println(type + ": Not possible to charge.");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public abstract String getInfo();
}

