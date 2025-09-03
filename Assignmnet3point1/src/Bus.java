public class Bus extends SportsCar {
    private int passengers;

    // Constructor
    public Bus(String model, double speed, double fuelConsumption) {
        super(model, speed, fuelConsumption);
        this.passengers = 0;
    }

    // Add passengers
    public void passengerEnter(int count) {
        passengers += count;
        System.out.println(count + " passengers entered. Total passengers: " + passengers);
    }

    // Remove passengers
    public void passengerExit(int count) {
        passengers -= count;
        if (passengers < 0) passengers = 0;
        System.out.println(count + " passengers exited. Total passengers: " + passengers);
    }

    // Override displayInfo to include passengers
    @Override
    public void displayInfo() {
        super.displayInfo(); // call SportsCar displayInfo
        System.out.println("Passengers: " + passengers);
    }

    // Test the Bus class
    public static void main(String[] args) {
        Bus cityBus = new Bus("Volvo B12", 100, 20);

        cityBus.displayInfo();       // initial info
        cityBus.passengerEnter(10);  // 10 passengers enter
        cityBus.passengerExit(3);    // 3 passengers leave
        cityBus.accelerate();         // inherited from SportsCar
        cityBus.decelerate();         // inherited from SportsCar
        cityBus.displayInfo();       // final info
    }
}
