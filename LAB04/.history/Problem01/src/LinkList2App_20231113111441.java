class Link {
    public int iData;
    public double dData;
    public Link next;
    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }
    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(int id, double dd) {
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;
    }

    public Link find(int key) {
        Link current = first;
        while (current != null) {
            if (current.iData == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current != null) {
            if (current.iData == key) {
                if (current == first) {
                    first = first.next;
                } else {
                    previous.next = current.next;
                }
                return current;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertAfter(int key, int id, double dd) {
        Link current = first;
        while (current != null) {
            if (current.iData == key) {
                Link newLink = new Link(id, dd);
                newLink.next = current.next;
                current.next = newLink;
                return;
            }
            current = current.next;
        }
        System.out.println("Item with key " + key + " not found in the list.");
    }
}

class LinkList2App {
    public static void main(String[] args) {
        LinkList theList = new LinkList();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        Link f = theList.find(44);
        if (f != null)
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(66);
        if (d != null)
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can't delete link");

        theList.displayList();

        theList.insertAfter(44, 55, 5.55); // Insert a new link with key 55 and data 5.55 after the link with key 44
        theList.displayList();
    }
}
