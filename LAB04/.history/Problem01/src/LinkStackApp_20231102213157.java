import java.util.Stack;

class Link {
    public long dData;             // data item
    public Link next;              // next link in list

    public Link(long dd)           // constructor
    {
        dData = dd;
    }

    public void displayLink()      // display ourself
    {
        System.out.print(dData + " ");
    }
}

class LinkList {
    private Link first;            // ref to the first item on the list

    public LinkList()              // constructor
    {
        first = null;              // no items on the list yet
    }

    public Link getFirst() {
        return first;
    }

    public boolean isEmpty()       // true if the list is empty
    {
        return (first == null);
    }

    public void insertFirst(long dd) // insert at the start of the list
    {
        Link newLink = new Link(dd);
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }

    public long deleteFirst()      // delete the first item
    {
        Link temp = first;          // save a reference to the link
        first = first.next;         // delete it: first --> old next
        return temp.dData;          // return the deleted link
    }

    public void displayList() {
        Link current = first;       // start at the beginning of the list
        while (current != null)    // until the end of the list
        {
            current.displayLink();   // print data
            current = current.next;  // move to the next link
        }
        System.out.println("");
    }
}

class LinkStack {
    private LinkList theList;

    public LinkStack()             // constructor
    {
        theList = new LinkList();
    }

    public void push(long j)     // put an item on top of the stack
    {
        theList.insertFirst(j);
    }

    public long pop()            // take an item from the top of the stack
    {
        return theList.deleteFirst();
    }

    public boolean isEmpty()       // true if the stack is empty
    {
        return (theList.isEmpty());
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}

public class ReverseListWithStack {
    public static void reverseListUsingStack(LinkList originalList) {
        // Create a stack to store the elements from the original list.
        Stack<Long> stack = new Stack<>();

        // Traverse the original list and push each element onto the stack.
        Link current = originalList.getFirst();
        while (current != null) {
            stack.push(current.dData);
            current = current.next;
        }

        // Create a new list to store the reversed elements.
        LinkList reversedList = new LinkList();

        // Pop elements from the stack and insert them into the new list.
        while (!stack.isEmpty()) {
            long data = stack.pop();
            reversedList.insertFirst(data);
        }

        // Display the reversed list.
        System.out.print("Reversed List: ");
        reversedList.displayList();
    }

    public static void main(String[] args) {
        LinkList originalList = new LinkList();
        originalList.insertFirst(10);
        originalList.insertFirst(20);
        originalList.insertFirst(30);
        originalList.insertFirst(40);
        originalList.insertFirst(50);

        System.out.print("Original List: ");
        originalList.displayList();

        reverseListUsingStack(originalList);
    }
}
