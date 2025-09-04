package Task2;

public class Car extends AbstractVehicle {

    public Car(String fuel, String color) {
        super("Car", fuel, color);
    }

    @Override
    public String getInfo() {
        return "Car Information:\n" +
                "Type: " + type + "\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color;
    }
}

