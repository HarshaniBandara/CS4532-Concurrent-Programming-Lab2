import java.util.concurrent.Semaphore;

public class Rider implements Runnable {
    private int riderId;
    private Semaphore mutex;
    private Semaphore bus;
    private Semaphore boarded;

    public Rider(int riderId, Semaphore mutex, Semaphore bus, Semaphore boarded) {
        this.riderId = riderId;
        this.mutex = mutex;
        this.bus = bus;
        this.boarded = boarded;
    }

    private void boardBus() {
        System.out.println("Rider " + riderId + " has boarded");
    }

    @Override
    public void run() {
        try {
            mutex.acquire();
            Main.waiting= Main.waiting+1;
            System.out.println("Rider "  + riderId +  " is waiting");
            mutex.release();
            bus.acquire();
            boardBus();
            boarded.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
