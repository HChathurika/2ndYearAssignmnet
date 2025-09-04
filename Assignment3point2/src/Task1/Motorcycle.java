package Task1;


public class Motorcycle implements Vehicle {
    private String fuel;
    private String color;

    public Motorcycle(String fuel, String color) {
        this.fuel = fuel;
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Motorcycle Information:\n" +
                "Type: Motorcycle\n" +
                "Fuel: " + fuel + "\n" +
                "Color: " + color;
    }
}


