import java.io.*;
import java.net.*;
import java.util.*;

public class Task1CSVAverage {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String targetDate = "01.01.2023"; // First day of January 2023
        List<Double> temperatures = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));


            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("CSV is empty.");
                reader.close();
                return;
            }
            String[] headers = headerLine.split(";");
            int colIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equals("UlkoTalo")) {
                    colIndex = i;
                    break;
                }
            }
            if (colIndex == -1) {
                System.out.println("'UlkoTalo' column not found.");
                reader.close();
                return;
            }


            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(";");
                if (cols.length > colIndex && cols[0].startsWith(targetDate)) {

                    String tempStr = cols[colIndex].replace(',', '.');
                    temperatures.add(Double.parseDouble(tempStr));
                }
            }

            reader.close();


            if (!temperatures.isEmpty()) {
                double sum = 0;
                for (double t : temperatures) sum += t;
                double average = sum / temperatures.size();
                System.out.printf("Average UlkoTalo temperature on %s: %.2f°C%n", targetDate, average);
            } else {
                System.out.println("No data for " + targetDate);
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e);
        }
    }
}
