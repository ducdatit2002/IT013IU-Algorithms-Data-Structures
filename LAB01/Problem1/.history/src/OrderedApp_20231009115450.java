import java.util.*;

public class OrdArray {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    // -----------------------------------------------------------

    public OrdArray(int max) { // constructor
        a = new long[max]; // create array
        nElems = 0;
    }

    // -----------------------------------------------------------

    public int size() {
        return nElems;
    }

    // -----------------------------------------------------------

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        int comparisons = 0;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            comparisons++;
            if (a[curIn] == searchKey)
                return curIn; // found it
            else if (lowerBound > upperBound)
                return nElems; // can't find it
            else // divide range
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            } // end else divide range
        } // end while
    } // end find()

    // -----------------------------------------------------------

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) // find where it goes
            if (a[j] > value) // (linear search)
                break;
        for (int k = nElems; k > j; k--) // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value; // insert it
        nElems++; // increment size
    } // end insert()

    // -----------------------------------------------------------

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) // can't find it
            return false;
        else // found it
        {
            for (int k = j; k < nElems; k++) // move bigger ones down
                a[k] = a[k + 1];
            nElems--; // decrement size
            return true;
        }
    } // end delete()

    // -----------------------------------------------------------

    public void display() { // displays array contents
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    // -----------------------------------------------------------

    public static int random(int max) {
        return (int) (Math.random() * max) + 1; // 1 <= randomNumber <= max
    }

    // -----------------------------------------------------------

    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
        OrdArray arr2 = new OrdArray(maxSize);

        for (int i = 0; i < 100; i++) {
            int randomNumber = OrdArray.random(maxSize);
            arr.insert(randomNumber);
            arr2.insert(randomNumber);
        }

        OrdArray mergedArray = arr.merge(arr2, 2 * maxSize);
        int randomIndex = (int) (Math.random() * mergedArray.nElems);
        long randomElement = mergedArray.a[randomIndex];
        int comparisons = mergedArray.find(randomElement);
        System.out.println("Number of comparisons: " + comparisons);

        // Print the average number of comparisons to find a random item
        // over 100 trials
        int totalComparisons = 0;
        for (int i = 0; i < 100; i++) {
            OrdArray mergedArray = arr.