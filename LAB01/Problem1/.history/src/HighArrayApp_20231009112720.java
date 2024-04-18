import java.util.Random;

class HighArray {
    private long[] a; // ref to array a
    private int nElems; // number of data items
    private int comparisons; // counter for comparisons

    public HighArray(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
        comparisons = 0; // initialize comparisons counter
    }

    public void insert(long value) { // insert value into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public boolean find(long searchKey) { // find specified value
        int j;
        comparisons = 0; // reset comparisons counter
        for (j = 0; j < nElems; j++) { // for each element,
            comparisons++; // increment comparisons counter
            if (a[j] == searchKey) // found item?
                break; // exit loop before end
        }
        if (j == nElems) // gone to end?
            return false; // yes, can't find it
        else
            return true; // no, found it
    }

    public int getComparisons() {
        return comparisons;
    }

    public long[] getArray() {
        return a;
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array

        // Insert 100 random items
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            long value = random.nextInt(1000); // generate a random number
            arr.insert(value);
        }
        public int getNElems() {
            return nElems;
        }
        // Find a random item chosen at random
        int randomIndex = random.nextInt(arr.nElems);
        long randomItem = arr.getArray()[randomIndex];
        System.out.println("Random Item: " + randomItem);

        // Print the number of comparisons to find the random item
        boolean found = arr.find(randomItem);
        int comparisons = arr.getComparisons();
        if (found) {
            System.out.println("Number of comparisons: " + comparisons);
        } else {
            System.out.println("Item not found.");
        }

        // Compute and print the average number of comparisons to find a random item over 100 trials
        int totalComparisons = 0;
        int numTrials = 100;
        for (int i = 0; i < numTrials; i++) {
            randomItem = random.nextInt(1000); // generate a random item
            found = arr.find(randomItem);
            comparisons = arr.getComparisons();
            totalComparisons += comparisons;
        }
        double averageComparisons = (double) totalComparisons / numTrials;
        System.out.println("Average number of comparisons over 100 trials: " + averageComparisons);

        // Print the average number of comparisons to find a random item in arrays with 100, 200, 300, ..., 1000 items
        for (int size = 100; size <= 1000; size += 100) {
            arr = new HighArray(size); // create a new array with the given size
            totalComparisons = 0;
            numTrials = 100;
            for (int i = 0; i < numTrials; i++) {
                randomItem = random.nextInt(1000); // generate a random item
                found = arr.find(randomItem);
                comparisons = arr.getComparisons();
                totalComparisons += comparisons;
            }
            averageComparisons = (double) totalComparisons / numTrials;
            System.out.println("Average number of comparisons for array size " + size + ": " + averageComparisons);
        }
    }
}