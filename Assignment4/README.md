# Calculator Project
This project implements a simple calculator class in Java.  
It can reset the value, add positive integers, and return the current total.  
Negative numbers are not allowed and will throw an exception.

public class Calculator {
private int value;
```
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

```
*" Explain how the calculator  class works."*
The `Calculator` class maintains an internal integer value that represents the current total. It provides methods to manipulate this value, including resetting it to zero, adding positive integers, and adding arrays of integers using both for and while loops. If a negative integer is passed to any of the addition methods, an `IllegalArgumentException` is thrown to prevent invalid operations. The class also includes a `main` method that demonstrates its functionality and exception handling.
**Constructor**: Initializes the calculator with a value of zero.
 **reset()**: Resets the calculator's value to zero.
 **add(int number)**: Adds a positive integer to the current value. Throws an exception if a negative number is provided.
 **addNumbersFor(int[] numbers)**: Adds an array of positive integers using a for loop. Throws an exception if any negative number is found.
 **addNumbersWhile(int[] numbers)**: Adds an arra y of positive integers using a while loop. Throws an exception if
    any negative number is found.
    **getValue()**: Returns the current value of the calculator.
**main(String[] args)**: Demonstrates the functionality of the calculator, including exception handling for negative inputs.

