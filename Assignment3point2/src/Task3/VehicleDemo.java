package Task3;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");


        AbstractVehicle car = new Car("Petrol", "Red");
        car.start();
        car.stop();
        car.charge();
        System.out.println(car.getInfo() + "\n");


        AbstractVehicle eCar = new ElectricCar("Blue");
        eCar.start();
        eCar.stop();
        eCar.charge();
        System.out.println(eCar.getInfo() + "\n");


        AbstractVehicle motorcycle = new Motorcycle("Gasoline", "Black");
        motorcycle.start();
        motorcycle.stop();
        motorcycle.charge(); // Not possible to charge
        System.out.println(motorcycle.getInfo() + "\n");


        AbstractVehicle eMotorcycle = new ElectricMotorcycle("Green");
        eMotorcycle.start();
        eMotorcycle.stop();
        eMotorcycle.charge(); // ElectricMotorcycle charging
        System.out.println(eMotorcycle.getInfo() + "\n");


        AbstractVehicle bus = new Bus("Diesel", 40);
        bus.start();
        bus.stop();
        bus.charge(); // Not possible to charge
        System.out.println(bus.getInfo() + "\n");
    }
}
