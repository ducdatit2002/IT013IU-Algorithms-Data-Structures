public class FirstLastList {
    private Link first; // ref to first item
    private Link last; // ref to last item

    public FirstLastList() // constructor
    {
        first = null; // no items on the list yet
        last = null;
    }

    public boolean isEmpty() // true if no links
    {
        return first == null;
    }

    public void insertLast(long dd) // insert at the end of the list
    {
        Link newLink = new Link(dd); // make a new link
        if (isEmpty()) // if empty list,
            first = newLink; // first --> newLink
        else
            last.next = newLink; // old last --> newLink
        last = newLink; // newLink <-- last
    }

    public long deleteFirst() // delete the first link
    { // (assumes non-empty list)
        long temp = first.dData;
        if (first.next == null) // if only one item
            last = null; // null <-- last
        first = first.next; // first --> old next
        return temp;
    }

    public void displayList() {
        Link current = first; // start at the beginning
        while (current != null) // until the end of the list
        {
            current.displayLink(); // print data
            current = current.next; // move to the next link
        }
        System.out.println("");
    }
}