import java.util.Random;

public class Customer {
    private int serviceTime;

    public Customer() {
        Random rand = new Random();
        serviceTime = rand.nextInt(10) + 1; // Random service time between 1 and 10 units.
    }

    public int getServiceTime() {
        return serviceTime;
    }
}