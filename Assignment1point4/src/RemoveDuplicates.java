import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter  integer number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int[] uniqueNumbers = new int[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            boolean alraedyExists = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (numbers[j] == uniqueNumbers[j]) {
                    alraedyExists = true;
                    break;
                }
            }
            if (!alraedyExists) {
                uniqueNumbers[uniqueCount] = numbers[i];
                uniqueCount++;


            }

        }
        System.out.println("\nThe array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(uniqueNumbers[i] + " ");


        }
    }
}
