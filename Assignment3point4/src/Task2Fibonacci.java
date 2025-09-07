import java.io.FileWriter;
import java.io.IOException;

public class Task2Fibonacci {
    public static void main(String[] args) {
        String filename = "fibonacci.csv"; // output file

        try (FileWriter writer = new FileWriter(filename)) {
            long a = 0, b = 1;


            writer.write("Index;Fibonacci\n");


            for (int i = 1; i <= 60; i++) {
                writer.write(i + ";" + a + "\n"); // save as index;number
                long next = a + b;
                a = b;
                b = next;
            }

            System.out.println("Fibonacci numbers written to " + filename);

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}


