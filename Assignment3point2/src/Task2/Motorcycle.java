package Task2;


public class Motorcycle extends AbstractVehicle {

    public Motorcycle(String fuel, String color) {
        super("Motorcycle", fuel, color);
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color;
    }
}

