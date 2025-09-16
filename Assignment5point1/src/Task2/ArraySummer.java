package Task2;

public class ArraySummer extends Thread {
    private int[] arr;
    private int start, end;
    private long partialSum = 0;

    public ArraySummer(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += arr[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}
