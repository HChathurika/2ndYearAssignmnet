import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstNumber = reader.nextInt();
        System.out.print("Enter the second number greater than first number: ");
        int secondNumber = reader.nextInt();

        System.out.println("The prime numbers are between "+firstNumber+ " and " +secondNumber+" are :" );

        for(int i=firstNumber;i<=secondNumber;i++){
            int number = 0;

            for(int j=1; j<=i  ;j++) {
                if( i % j ==0) {
                    number++;
                }


            }
            if(number == 2){
                System.out.print(i+" ,");
            }



        }

    }
}
