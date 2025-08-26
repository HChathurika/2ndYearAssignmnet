import java.util.Arrays;
import java.util.Scanner;

public class FullNames {
    public static void main(String[] args) {
        String[] FirstNames = {"Elisa", "John", "Elina", "Joe", "Lauri"};
        String[] LastNames = {"Minski", "Brown", "Pixel", "Michal", "Jenni"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many random names you looking for ? : ");
        int count = scanner.nextInt();


        for (int i = 0; i < count; i++) {

            int index1 = (int) (Math.random() * FirstNames.length);
            int index2 = (int) (Math.random() * LastNames.length);

            String FullName = FirstNames[index1] + " " + LastNames[index2];
            System.out.println("Full name  " + (i + 1) + " is : " + FullName);
        }


    }


}

