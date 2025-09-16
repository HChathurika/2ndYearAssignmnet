package Task2;

import java.util.Random;

public class ParallelSum {
    public static void main(String[] args) {
        int size = 100000;
        int[] numbers = new int[size];
        Random rand = new Random();


        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(100); // random integers 0-99
        }


        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cores: " + cores);


        ArraySummer[] workers = new ArraySummer[cores];
        int chunkSize = size / cores;


        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = (i == cores - 1) ? size : start + chunkSize;
            workers[i] = new ArraySummer(numbers, start, end);
            workers[i].start();
        }


        long totalSum = 0;
        for (ArraySummer worker : workers) {
            try {
                worker.join();
                totalSum += worker.getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total sum = " + totalSum);
    }
}
