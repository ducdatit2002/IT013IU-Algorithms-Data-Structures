import java.util.Scanner;

class Link {
    public int data;
    public Link next;

    public Link(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}

class CircularLinkedList {
    private Link current;

    public CircularLinkedList(int n) {
        current = null;
        for (int i = 1; i <= n; i++) {
            insert(i);
        }
    }

    public void insert(int data) {
        Link newLink = new Link(data);
        if (current == null) {
            newLink.next = newLink;
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            current = newLink;
        }
    }

    public int delete() {
        int data = current.next.data;
        if (current.next == current) {
            current = null;
        } else {
            current.next = current.next.next;
        }
        return data;
    }

    public void displayList() {
        if (current != null) {
            Link temp = current.next;
            do {
                temp.displayLink();
                temp = temp.next;
            } while (temp != current.next);
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return current == null;
    }

    public void setCurrent(int data) {
        if (current == null) {
            return;
        }
        while (current.data != data) {
            current = current.next;
        }
    }
}

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int numPeople = scanner.nextInt();
        System.out.print("Enter the number used for counting off: ");
        int stepSize = scanner.nextInt();
        System.out.print("Enter the number of the person where counting starts: ");
        int startingPerson = scanner.nextInt();

        CircularLinkedList circle = new CircularLinkedList(numPeople);
        circle.setCurrent(startingPerson);

        System.out.println("Elimination order:");
        while (!circle.isEmpty()) {
            for (int i = 1; i < stepSize; i++) {
                circle.current = circle.current.next;
            }
            int eliminated = circle.delete();
            System.out.print(eliminated + " ");
        }

        System.out.println("\nLast person standing: " + circle.current.data);
    }
}
