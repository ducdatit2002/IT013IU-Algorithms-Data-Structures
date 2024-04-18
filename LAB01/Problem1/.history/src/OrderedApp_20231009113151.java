import java.util.Random;

class OrderedApp {
    private long[] a; // ref to array a
    private int nElems; // number of data items

    public OrdArray(int max) // constructor
    {
        a = new long[max]; // create array
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        int comparisons = 0; // counter for comparisons

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            comparisons++; // increment comparisons counter
            if (a[curIn] == searchKey)
                return comparisons; // return number of comparisons
            else if (lowerBound > upperBound)
                return comparisons; // return number of comparisons
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }
        }
    }

    public void insert(long value) // put element into array
    {
        int j;
        for (j = 0; j < nElems; j++) // find where it goes
            if (a[j] > value) // (linear search)
                break;
        for (int k = nElems; k > j; k--) // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value; // insert it
        nElems++; // increment size
    }

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
    }

    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        OrdArray arr; // reference to array
        arr = new OrdArray(maxSize); // create the array

        // Insert 100 random items
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            long value = random.nextInt(1000); // generate a random number
            arr.insert(value);
        }

        // Find a random item chosen at random
        int randomIndex = random.nextInt(arr.size());
        long randomItem = arr.getArray()[randomIndex];
        System.out.println("Random Item: " + randomItem);

        // Print the number of comparisons to find the random item using binary search
        int comparisons = arr.find(randomItem);
        System.out.println("Number of comparisons (Binary Search): " + comparisons);

        // Create a HighArray for linear search
        HighArray highArray = new HighArray(maxSize);

        // Copy elements from OrdArray to HighArray for linear search
        for (int i = 0; i < arr.size(); i++) {
            highArray.insert(arr.getArray()[i]);
        }

        // Print the number of comparisons to find the random item using linear search
        comparisons = highArray.find(randomItem) + 1; // Add 1 to account for the initial comparison in linear search
        System.out.println("Number of comparisons (Linear Search): " + comparisons);
    }
}