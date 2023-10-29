import java.util.*;
import java.util.concurrent.Semaphore;

public class SenateBusProblem {
    public static int waiting=0;
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        Semaphore bus = new Semaphore(0);
        Semaphore board = new Semaphore(0);

        // Initialize user input to exit the system
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter key to exit at anytime.\n");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int riderCount = 1;
                while (true) {
                    new Thread((Runnable) new Rider(riderCount++, mutex, bus, board)).start();
                    try {
                        Thread.sleep((int) (new Random().nextInt((int)(1000 * 0.25 - 1000 * 0.05)) + 1000 * 0.05));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int busCount=1;
                while (true) {
                    new Thread((Runnable) new Bus(busCount++, mutex, bus, board)).start();
                    try {
                        System.out.println(SenateBusProblem.waiting+"waiting riders count now ");
                        Thread.sleep((int) (new Random().nextInt((int)(1000 * 10 - 1000 * 2.5)) + 1000 * 2.5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // Check user input to exit the system
        try {
            if (scanner.hasNextLine()) {
                scanner.close();
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            scanner.close();
            System.exit(1);
        }
    }
}