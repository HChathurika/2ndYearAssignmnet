public class CarDriver {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Corolla");

        Car car2 = new Car("Honda",50,60);
        System.out.println(car2.getTypeName()+ "speed : "+car2.getSpeed());

        System.out.println(car2.getTypeName()+ "tank : "+car2.getGasoline());
    }
}
