public class Calculator {
    private int value;


    public Calculator() {
        value = 0;
    }


    public void reset() {
        value = 0;
    }



    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        value += number;
    }


    public void addNumbersFor(int[] numbers) {
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            value += num;
        }
    }


    public void addNumbersWhile(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            value += numbers[i];
            i++;
        }
    }


    public int getValue() {
        return value;
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            calc.add(5);
            calc.add(10);
            System.out.println("Current value: " + calc.getValue()); // 15

            int[] nums = {1, 2, 3};
            calc.addNumbersFor(nums);
            System.out.println("After addNumbersFor: " + calc.getValue()); // 21

            calc.reset();
            System.out.println("After reset: " + calc.getValue()); // 0




            calc.addNumbersWhile(new int[]{4, 6});
            System.out.println("After addNumbersWhile: " + calc.getValue()); // 10


            System.out.println("Now testing negative input...");
            calc.add(-1);

        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
