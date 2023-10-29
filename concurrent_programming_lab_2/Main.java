import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {
    public static int waiting=0;
    public static void main(String[] args) {
        Semaphore mutex = new Semaphore(1);
        Semaphore bus = new Semaphore(0);
        Semaphore boarded = new Semaphore(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int riderCount = 1;
                while (true) {
                    new Thread((Runnable) new Rider(riderCount++, mutex, bus, boarded)).start();
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
                    new Thread((Runnable) new Bus(busCount++, mutex, bus, boarded)).start();
                    try {
                        Thread.sleep((int) (new Random().nextInt((int)(1000 * 10 - 1000 * 2.5)) + 1000 * 2.5));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}