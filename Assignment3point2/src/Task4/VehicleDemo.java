package Task4;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        AbstractVehicle car = new Car("Petrol", "Red", 15.0);
        car.start();
        car.stop();
        car.charge();
        System.out.println(car.getInfo() + "\n");

        AbstractVehicle eCar = new ElectricCar("Blue", 0.2); // kWh/km
        eCar.start();
        eCar.stop();
        eCar.charge();
        System.out.println(eCar.getInfo() + "\n");

        AbstractVehicle motorcycle = new Motorcycle("Gasoline", "Black", 35.0);
        motorcycle.start();
        motorcycle.stop();
        motorcycle.charge();
        System.out.println(motorcycle.getInfo() + "\n");

        AbstractVehicle eMotorcycle = new ElectricMotorcycle("Green", 0.1);
        eMotorcycle.start();
        eMotorcycle.stop();
        eMotorcycle.charge();
        System.out.println(eMotorcycle.getInfo() + "\n");

        AbstractVehicle bus = new Bus("Diesel", 40, 8.0);
        bus.start();
        bus.stop();
        bus.charge();
        System.out.println(bus.getInfo() + "\n");
    }
}

