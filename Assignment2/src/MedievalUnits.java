import java.util.Scanner;

public class MedievalUnits {
    public static void main(String[] args) {
        Scanner reader  = new Scanner(System.in);

        System.out.print("Enter the weight in grams: ");
        double grams = Double.parseDouble(reader.nextLine());

        int Leiviskä =(int)(grams/(13.28*32*20) );
        double remainderOfLeiviskä  =grams % 13.28*32*20;

        int Naula =(int)(remainderOfLeiviskä/(32*13.28) );
        double remainderOfNaula  = remainderOfLeiviskä % 13.28*32;

        int Luoti =(int)(remainderOfNaula/(13.28) );
        double remainderOfLuoti  =remainderOfNaula % 13.28;

        System.out.print("The "+ grams + "grams is equal to "+Leiviskä+ " leiviskeä " +Naula+ " naula " +Luoti +  " Luoti ");



    }
}
