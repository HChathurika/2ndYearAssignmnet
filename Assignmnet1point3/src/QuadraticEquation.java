import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The standard quadratic equation is: x = ax^2 + bx + c : \n");
        System.out.print("Enter the value for a =");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the value for b =");
        double b = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter the value for c =");
        double c = Double.parseDouble(scanner.nextLine());

        System.out.println("The quadratic equation is : x = " +a+"x^2 + " + b+"x + "+c);

        double x1=(-b + Math.sqrt(b*b-4*a*c))/(2*a);
        double x2=(-b - Math.sqrt(b*b-4*a*c))/(2*a);

        if (Math.pow(b,2)>= 4*a*c) {
            System.out.println("The equation have roots .\n");
            System.out.println("The roots are x1 = " + x1 + "\n");
            System.out.println("The roots are x2 = " + x2 + "\n");
        }

            else {

                System.out.println("The equation have no real roots .\n");
        }

    }
}
