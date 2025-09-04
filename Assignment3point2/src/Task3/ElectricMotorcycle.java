package Task3;

public class ElectricMotorcycle extends AbstractVehicle {

    public ElectricMotorcycle(String color) {
        super("ElectricMotorcycle", "Electric", color);
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color;
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }
}

