import java.util.Random;

class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot insert.");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot remove.");
            return -1;
        }
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long removeN(int n) {
        if (isEmpty() || n < 1 || n > nItems) {
            System.out.println("Invalid operation.");
            return -1;
        }
        long temp = -1;
        for (int i = 0; i < n; i++) {
            temp = remove();
        }
        return temp;
    }

    public void displayQueueInfo() {
        System.out.println("Front: " + front);
        System.out.println("Rear: " + rear);
        System.out.print("Queue: ");
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }

    public void displayQueueWithWraparound() {
        System.out.print("Queue: ");
        int tempFront = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[tempFront] + " ");
            tempFront = (tempFront + 1) % maxSize;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
}

public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(5);

        theQueue.insert(10);
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        theQueue.insert(50);
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);

        System.out.println("Displaying Queue Info:");
        theQueue.displayQueueInfo();

        System.out.println("Displaying Queue with Wraparound:");
        theQueue.displayQueueWithWraparound();

        System.out.println("Removing N items after N calls:");
        System.out.println(theQueue.removeN(3));

        System.out.println("Displaying Queue Info after N removals:");
        theQueue.displayQueueInfo();
    }
}
