import java.util.Scanner;

public class SubArrayMaxSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter how many numbers of your array ?  : ");
        int count = scanner.nextInt();


        int[] Numbers = new int[count];

        for (int i = 0; i < Numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            Numbers[i] = scanner.nextInt();
        }

        int maxSum = Numbers[0];
        int StartIndex = 0;
        int EndIndex = 0;

        for (int start = 0; start < Numbers.length; start++) {
            int currentSum = 0;
            for (int end = start; end < Numbers.length; end++) {
                currentSum += Numbers[end];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    StartIndex = start;
                    EndIndex = end;
                }

            }
        }


        System.out.println("\nMaximum sum: "+maxSum);
        System.out.println("Integers: "+(StartIndex +1)+"-"+(EndIndex +1));

}

    }

