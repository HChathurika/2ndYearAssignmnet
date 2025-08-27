public class CoffeeUser {
    public static void main(String[] args) {
        CoffeeMachine myCoffee = new CoffeeMachine();

        myCoffee.turnOn();
        System.out.println("Coffee Machine is on");

        myCoffee.setCoffeeType("Capatuno");
        myCoffee.setCoffeeAmount(50);

        System.out.println("Coffee type is : " +myCoffee.getCoffeeType()) ;
        System.out.println("Coffee amount is :" + myCoffee.getCoffeeAmount() + "ml");

        myCoffee.turnOff();
        System.out.println("Coffee maker is off");
    }
}
