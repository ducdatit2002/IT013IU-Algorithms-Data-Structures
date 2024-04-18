import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Customer {
    private int id;
    private int serviceTime;

    public Customer(int id, int serviceTime) {
        this.id = id;
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public int getServiceTime() {
        return serviceTime;
    }
}

class CustomerQueue {
    private Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    public Customer serveCustomer() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class CustomerQueueSimulation {
    public static void main(String[] args) {
        int maxQueueSize = 10; // Maximum size of the customer queue
        int maxServiceTime = 10; // Maximum service time for customers

        Random rand = new Random();
        CustomerQueue customerQueue = new CustomerQueue();

        // Simulate customer arrivals and add them to the queue
        for (int customerId = 1; customerId <= maxQueueSize; customerId++) {
            int serviceTime = rand.nextInt(maxServiceTime) + 1;
            Customer customer = new Customer(customerId, serviceTime);
            customerQueue.addCustomer(customer);
            System.out.println("Customer " + customer.getId() + " entered the queue with a service time of " + customer.getServiceTime() + " units.");
        }

        // Serve customers in the order they arrived
        while (!customerQueue.isEmpty()) {
            Customer customer = customerQueue.serveCustomer();
            System.out.println("Serving Customer " + customer.getId() + " with a service time of " + customer.getServiceTime() + " units.");
            try {
                Thread.sleep(customer.getServiceTime() * 100); // Simulate service time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
