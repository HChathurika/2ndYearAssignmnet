public class Car {
    private double speed;
    private double gasoline;
    private double capacity;
    private String typeName;

    public Car(String typeName) {
        this.typeName = typeName;
        this.gasoline = 0;
        this.speed = 0;
        this.capacity = 50;


    }

    public Car(String typeName, double initialSpeed, double Capacity) {
        this.typeName = typeName;
        this.capacity = capacity;
        this.speed = initialSpeed;
        this.gasoline = capacity;
    }
    public void accelerate() {
        if (gasoline > 0)
            speed += 10;

    }

    public void decelerate(int amount) {
        speed = Math.max(0, speed - amount);
    }
    public double getSpeed() {
        return speed;
    }
    public double getGasoline() {
        return gasoline;
    }
    public String getTypeName() {
        return typeName;

}
}
