public class QueueSimulator {
    public static void main(String[] args) {
        LinkQueue customerQueue = new LinkQueue();
        int simulationTime = 100; // Total simulation time
        int currentTime = 0;

        while (currentTime < simulationTime) {
            Customer newCustomer = new Customer();
            customerQueue.insert(newCustomer.getServiceTime());

            if (customerQueue.isEmpty()) {
                System.out.println("No customers in the queue.");
            } else {
                long serviceTime = customerQueue.remove();
                System.out.println("Customer served for " + serviceTime + " units of time.");
            }

            currentTime++;
        }
    }
}