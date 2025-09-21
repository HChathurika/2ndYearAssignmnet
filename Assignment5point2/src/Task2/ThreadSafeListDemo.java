package Task2;

import java.util.ArrayList;
import java.util.List;

// Thread-safe wrapper around ArrayList
class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();

    // Synchronized method to add an element
    public synchronized void add(T element) {
        list.add(element);
        System.out.println(Thread.currentThread().getName() + " added: " + element);
    }

    // Synchronized method to remove an element
    public synchronized void remove(T element) {
        if (list.remove(element)) {
            System.out.println(Thread.currentThread().getName() + " removed: " + element);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to remove: " + element);
        }
    }

    // Synchronized method to get size
    public synchronized int size() {
        return list.size();
    }
}

// Worker thread to test thread-safety
class ListWorker extends Thread {
    private ThreadSafeList<String> tsList;

    public ListWorker(ThreadSafeList<String> tsList, String name) {
        super(name);
        this.tsList = tsList;
    }

    @Override
    public void run() {
        tsList.add(getName() + "-Item");
        if (Math.random() > 0.5) {
            tsList.remove(getName() + "-Item");
        }
    }
}

// Main class must match file name
public class ThreadSafeListDemo {
    public static void main(String[] args) {
        ThreadSafeList<String> tsList = new ThreadSafeList<>();

        // Create 10 threads to add/remove elements concurrently
        Thread[] workers = new Thread[10];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new ListWorker(tsList, "Worker-" + i);
            workers[i].start();
        }

        // Wait for all workers to finish
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final size of list: " + tsList.size());
    }
}

