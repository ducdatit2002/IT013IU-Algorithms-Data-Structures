public class LinkQueue {
    private FirstLastList theList;
    private int size;

    public LinkQueue() 
    {
        theList = new FirstLastList(); // make a 2-ended list
        size = 0;
    }

    public boolean isEmpty() // true if the queue is empty
    {
        return theList.isEmpty();
    }

    public void insert(long j) // insert, rear of the queue
    {
        theList.insertLast(j);
        size++;
    }

    public long remove() // remove, front of the queue
    {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Replace with an appropriate value or exception handling.
        }
        size--;
        return theList.deleteFirst();
    }

    public long removeN(int n) // remove item N after N calls
    {
        if (isEmpty() || n <= 0 || n > size) {
            System.out.println("Invalid input for N.");
            return -1; // Replace with appropriate value or exception handling.
        }
        size--;
        long item = -1; // Default value if item N is not found.
        for (int i = 1; i < n; i++) {
            item = theList.deleteFirst();
            theList.insertLast(item);
        }
        return theList.deleteFirst();
    }

    public int size() {
        return size;
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
