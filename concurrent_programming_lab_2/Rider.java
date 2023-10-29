import java.util.concurrent.Semaphore;

public class Rider implements Runnable {
    private int id; // ID of the rider
    private Semaphore mutex;
    private Semaphore bus;
    private Semaphore boarded;

    public Rider(int id, Semaphore mutex, Semaphore bus, Semaphore boarded) {
        this.id = id;
        this.mutex = mutex;
        this.bus = bus;
        this.boarded = boarded;
    }

    // print rider is waiting (with ID)
    private void riderWait() {
        System.out.println("Rider " + "(ID: " + id + ")" + " is waiting!");
    }

    // print rider has boarded (with ID)
    private void boardBus() {
        System.out.println("Rider " + "(ID: " + id + ")" + " has boarded!");
    }

    @Override
    public void run() {
        try {
            mutex.acquire();

            SenateBusProblem.waiting=SenateBusProblem.waiting+1;
//            waiting.incrementCount();
            riderWait();
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
