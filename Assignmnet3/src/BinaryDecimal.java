
import java.util.Scanner;

public class BinaryDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the binary number using 1 and 0 : ");
        String binary = scanner.next();
        Scanner reader  = new Scanner(System.in);


        int Decimal = 0;



        for(int i=0; i< binary.length();i++){
            char bit  = binary.charAt(binary.length() -1-i);

            if (bit == '1') {
                Decimal += Math.pow(2,i);

            }
        }
        System.out.println("The Decimal value of above binary number is : "+Decimal+ ".\n");

        }



    }

