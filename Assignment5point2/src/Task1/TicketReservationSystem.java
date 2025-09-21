package Task1;
import java.util.Random;

// Theater class manages available seats
class Theater {
    private int availableSeats;

    public Theater(int seats) {
        this.availableSeats = seats;
    }

    // Synchronized to prevent race conditions
    public synchronized boolean reserveSeats(String customerName, int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            System.out.println(customerName + " reserved " + seats + " tickets.");
            return true;
        } else {
            System.out.println(customerName + " couldn't reserve " + seats + " tickets.");
            return false;
        }
    }
}

// Customer thread tries to reserve tickets
class Customer extends Thread {
    private Theater theater;
    private int seats;

    public Customer(Theater theater, String name, int seats) {
        super(name);
        this.theater = theater;
        this.seats = seats;
    }

    @Override
    public void run() {
        theater.reserveSeats(getName(), seats);
    }
}

// Main class
public class TicketReservationSystem {
    public static void main(String[] args) {
        final int TOTAL_SEATS = 10;      // total seats in theater
        final int TOTAL_CUSTOMERS = 15;  // number of customers

        Theater theater = new Theater(TOTAL_SEATS);
        Random rand = new Random();

        // Create and start customer threads
        Thread[] customers = new Thread[TOTAL_CUSTOMERS];
        for (int i = 0; i < TOTAL_CUSTOMERS; i++) {
            int seatsToReserve = rand.nextInt(4) + 1; // each customer wants 1–4 tickets
            customers[i] = new Customer(theater, "Customer " + (i + 1), seatsToReserve);
            customers[i].start();
        }

        // Wait for all customers to finish
        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All customers have finished their reservations.");
    }
}
