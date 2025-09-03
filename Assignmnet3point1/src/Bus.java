class Bus extends Car {
    private int passengers;

    public Bus(String model, double speed, double fuelConsumption) {
        super(model, speed, fuelConsumption);
        this.passengers = 0;
    }

    public void passengerEnter(int count) {
        passengers += count;
        System.out.println(count + " passengers entered. Total: " + passengers);
    }

    public void passengerExit(int count) {
        passengers -= count;
        if (passengers < 0) passengers = 0;
        System.out.println(count + " passengers exited. Total: " + passengers);
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Passengers: " + passengers);
    }
}


