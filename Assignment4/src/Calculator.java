public class Calculator {
    private int value;

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.add(5);
        System.out.println("Current Value: " + calc.getValue()); // should print 5

        calc.add(10);
        System.out.println("After adding 10: " + calc.getValue()); // should print 15

        calc.reset();
        System.out.println("After reset: " + calc.getValue()); // should print 0

        // Uncomment this line to test exception:
        // calc.add(-3);
    }
}
