import java.util.concurrent.Semaphore;

public class Bus implements Runnable {
    private int busId;

    private Semaphore mutex;
    private Semaphore bus;
    private Semaphore boarded;

    public Bus(int busId, Semaphore mutex, Semaphore bus, Semaphore boarded) {
        this.busId = busId;
        this.mutex = mutex;
        this.bus = bus;
        this.boarded = boarded;
    }

    public void depart() {
        System.out.println("Bus " + busId  + " has departed " + " | " + Main.waiting +" riders are waiting");
    }

    @Override
    public void run() {
        try {
            mutex.acquire();
            System.out.println("Bus " +  busId +  " has arrived " + " | " + Main.waiting+" riders are waiting");

            int numberOfRidersToBoard = Math.min(Main.waiting, 50);

            for (int i = 0; i < numberOfRidersToBoard; i++) {
                bus.release();
                boarded.acquire();
            }

            Main.waiting=Math.max(Main.waiting - 50, 0);
            mutex.release();

            depart();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
