package Task1;


    class OddPrinter implements Runnable {
        private int limit;

        OddPrinter(int limit) {
            this.limit = limit;
        }

        public void run() {
            for (int i = 1; i <= limit; i += 2) {
                System.out.println("Odd Thread: " + i);
                try {
                    Thread.sleep(100);  // small delay for alternation
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    class EvenPrinter implements Runnable {
        private int limit;

        EvenPrinter(int limit) {
            this.limit = limit;
        }

        public void run() {
            for (int i = 2; i <= limit; i += 2) {
                System.out.println("Even Thread: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public class NumberPrinting {
        public static void main(String[] args) {
            int limit = 20;

            Thread oddThread = new Thread(new OddPrinter(limit));
            Thread evenThread = new Thread(new EvenPrinter(limit));

            oddThread.start();
            evenThread.start();

            try {
                oddThread.join();
                evenThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Printing complete.");
        }
    }


