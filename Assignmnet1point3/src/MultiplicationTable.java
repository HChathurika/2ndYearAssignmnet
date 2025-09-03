import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (true){
            int score=0;

            for (int i=1;i<=10;i++) {
                int number1 = (int)(Math.random()*10+1);
                int number2 = (int)(Math.random()*10+1);
                System.out.print("Enter your answer for the question number" +i+ " :" +number1+" * " + number2+"=");
                int userAnswer = scanner.nextInt();

                if (userAnswer== -1){
                    System.out.println("Wrong answer.You have to start in initial state");
                    scanner.close();
                    return;


                }

                int correctAnswer = number1*number2;

                if (userAnswer == correctAnswer) {
                    System.out.println("The answer is correct .\n");
                    score++;
                } else {
                    System.out.println("The answer is incorrect.And go to start.The correct answer is : " +(number1*number2));

                }
                System.out.print("your score is :" +score + "/10");
                if (score == 10) {
                    System.out.println(" Congratulations! You have mastered the multiplication tables!");
                    break;
                } else {
                    System.out.println("Try again! Let's practice another round.\n");
                }
            }

            scanner.close();
        }
        }


    }



