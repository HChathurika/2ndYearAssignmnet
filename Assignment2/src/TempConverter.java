import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = Double.parseDouble(reader.nextLine());

        double Celsius = (fahrenheit- 32) * 5 / 9;
        System.out.printf("The temperature " +fahrenheit+ " in Fahrenheit is: " +String. format("%6.2f" ,Celsius )+" celsius.\n");


        System.out.print("Enter the temperature in Celsius: ");
        double celsius = Double.parseDouble(reader.nextLine());


        double Fahrenheit = (celsius*9/5) +32;
        System.out.printf("The temperature " +celsius+ " in Celsius is: " +String. format("%6.2f" ,Fahrenheit )+" Fahrenheit ");



    }
}
