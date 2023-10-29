import java.util.concurrent.Semaphore;

public class Bus implements Runnable {
    private int id; // ID of the bus
    private int capacity = 50; // maximum capacity of the bus
    private Semaphore mutex;
    private Semaphore bus;
    private Semaphore boarded;

    public Bus(int id, Semaphore mutex, Semaphore bus, Semaphore boarded) {
        this.id = id;
        this.mutex = mutex;
        this.bus = bus;
        this.boarded = boarded;
    }

    // print bus has arrived (with ID)
    public void arrive() {
        System.out.println("\n" + "Bus " + "(ID: " + id + ")" + " has arrived!" + " --- " + SenateBusProblem.waiting);
    }

    // print bus has departed (with ID)
    public void depart() {
        System.out.println("Bus " + "(ID: " + id + ")" + " has departed!" + " --- " + SenateBusProblem.waiting + "\n");
    }

    @Override
    public void run() {
        try {
            mutex.acquire();
            arrive();
            int n = Math.min(SenateBusProblem.waiting, capacity);

            for (int i = 0; i < n; i++) {
                bus.release();
                boarded.acquire();
            }

            SenateBusProblem.waiting=Math.max(SenateBusProblem.waiting - capacity, 0);
            mutex.release();

            depart();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
