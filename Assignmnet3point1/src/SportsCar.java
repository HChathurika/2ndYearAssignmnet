public class SportsCar {
    protected String model;
    protected double speed;
    protected double fuelConsumption;


    public SportsCar(String model, double speed, double fuelConsumption) {
        this.model = model;
        this.speed = speed * 1.5;
        this.fuelConsumption = fuelConsumption * 1.2;
    }

    // Methods
    public void accelerate() {
        System.out.println(model + " accelerates super fast to " + speed + " km/h!");
    }

    public void decelerate() {
        System.out.println(model + " decelerates quickly!");
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Speed: " + speed + " km/h, Fuel: " + fuelConsumption + " L/100km");
    }


    public static void main(String[] args) {
        SportsCar ferrari = new SportsCar("Ferrari F8", 200, 12);
        ferrari.displayInfo();
        ferrari.accelerate();
        ferrari.decelerate();
    }
}


