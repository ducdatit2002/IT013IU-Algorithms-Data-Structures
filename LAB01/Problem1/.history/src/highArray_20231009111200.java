import java.util.Random;

class HighArray {
    private long[] a; // reference to array a
    private int nElems; // number of data items
    private int comparisons; // counter for comparisons

    public HighArray(int max) {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    public boolean find(long searchKey) { // find specified value
        int j;
        for (j = 0; j < nElems; j++) { // for each element,
            comparisons++; // increment comparison counter
            if (a[j] == searchKey) // found item?
                break; // exit loop before end
        }
        return j != nElems; // returns true if found, false otherwise
    }

    public void insert(long value) { // put element into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) { // look for it
            if (value == a[j])
                break;
        }
        if (j == nElems) // can't find it
            return false;
        else { // found it
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--; // decrement size
            return true;
        }
    }

    public void display() { // displays array contents
        for (int j = 0; j < nElems; j++) // for each element
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    public long getMax() {
        if (nElems == 0) {
            return -1;
        } else {
            long max = a[0];
            for (int i = 1; i < nElems; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
            }
            return max;
        }
    }

    public void noDups() {
        for (int i = 0; i < nElems; i++) {
            long current = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (a[j] == current) {
                    delete(a[j]);
                    j--;
                }
            }
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public void resetComparisons() {
        comparisons = 0;
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array

        Random rand = new Random();

        // Insert 100 random items
        for (int i = 0; i < 100; i++) {
            arr.insert(rand.nextInt(1000) + 1);
        }

        // Find a random item
        int randomIndex = rand.nextInt(arr.nElems);
        long randomItem = arr.a[randomIndex];
        arr.resetComparisons(); // reset comparisons counter
        arr.find(randomItem);
        System.out.println("Number of comparisons to find a random item: " + arr.getComparisons());

        // Compute and print the average number of comparisons to find a random item over 100 trials
        int totalComparisons = 0;
        int numTrials = 100;
        for (int i = 0; i < numTrials; i++) {
            randomIndex = rand.nextInt(arr.nElems);
            randomItem = arr.a[randomIndex];
            arr.resetComparisons(); // reset comparisons counter
            arr.find(randomItem);
            totalComparisons += arr.getComparisons();
        }
        double averageComparisons = (double) totalComparisons / numTrials;
        System.out.println("Average number of comparisons over 100 trials: " + averageComparisons);

        // Print the average number of comparisons to find a random item in arrays with 100, 200, 300,...,1000 items
        for (int size = 100; size <= 1000; size += 100) {
            arr = new HighArray(size); // create a new array with the specified size

            // Insert random items
            for (int i = 0; i < size; i++) {
                arr.insert(rand.nextInt(1000) + 1);
            }

            totalComparisons = 0;
            numTrials = 100;
            //for (int i = I apologize for the incomplete response. Here's the complete code snippet for the remaining part:

//```java
            totalComparisons = 0;
            numTrials = 100;
            for (int i = 0; i < numTrials; i++) {
                randomIndex = rand.nextInt(arr.nElems);
                randomItem = arr.a[randomIndex];
                arr.resetComparisons(); // reset comparisons counter
                arr.find(randomItem);
                totalComparisons += arr.getComparisons();
            }
            averageComparisons = (double) totalComparisons / numTrials;
            System.out.println("Average number of comparisons for array size " + size + ": " + averageComparisons);
        }
    }
}