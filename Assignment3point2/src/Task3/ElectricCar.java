package Task3;


public class ElectricCar extends AbstractVehicle {

    public ElectricCar(String color) {
        super("ElectricCar", "Electric", color);
    }

    @Override
    public String getInfo() {
        return "Electric Car Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color;
    }

    @Override
    public void charge() {
        System.out.println(type + " is charging...");
    }
}

