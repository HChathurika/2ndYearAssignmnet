import java.util .Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        Scanner reader  = new Scanner(System.in);


        System.out.print("Enter the length of leg1 : ");
        double leg1 = Double.parseDouble(reader.nextLine());

        System.out.print("Enter the length of leg2 : ");
        double leg2 = Double.parseDouble(reader.nextLine());

        double Hypotenuse = Math.sqrt(Math.pow(leg1,2)+ Math.pow(leg2,2));

        System.out.printf("The hypotenuse of right triangle within two legs of  "+leg1+" and " +leg2+ " is ="+ String.format("%6.2f",Hypotenuse));
    }

}
