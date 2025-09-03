class Car {
    protected String model;
    protected double speed;
    protected double fuelConsumption;

    public Car(String model, double speed, double fuelConsumption) {
        this.model = model;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
    }

    public void accelerate() {
        System.out.println(model + " is accelerating at " + speed + " km/h");
    }

    public void decelerate() {
        System.out.println(model + " is decelerating");
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Speed: " + speed + " km/h, Fuel: " + fuelConsumption + " L/100km");
    }
}

class SportsCar extends Car {
    public SportsCar(String model, double speed, double fuelConsumption) {
        super(model, speed, fuelConsumption);
        this.speed *= 1.5;
        this.fuelConsumption *= 1.2;
    }

    @Override
    public void accelerate() {
        System.out.println(model + " accelerates super fast to " + speed + " km/h!");
    }

    @Override
    public void decelerate() {
        System.out.println(model + " decelerates quickly!");
    }
}


