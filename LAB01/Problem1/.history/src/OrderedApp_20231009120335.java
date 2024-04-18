import java.util.Random;

class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        int comparisons = 0;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            comparisons++;
            if (a[curIn] == searchKey)
                return comparisons;
            else if (lowerBound > upperBound)
                return comparisons;
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        nElems++;
    }

    public long[] getArray() {
        return a;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
        Random rand = new Random();
        int randomIndex = rand.nextInt(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long value = rand.nextInt(1000);
            arr.insert(value);
        }

        long searchKey = arr.getArray()[randomIndex];
        int comparisons = arr.find(searchKey);
        System.out.println("Number of comparisons to find the random item: " + comparisons);

        int totalComparisons = 0;
        int numTrials = 100;
        for (int i = 0; i < numTrials; i++) {
            randomIndex = rand.nextInt(maxSize);
            searchKey = arr.getArray()[randomIndex];
            comparisons = arr.find(searchKey);
            totalComparisons += comparisons;
        }
        double averageComparisons = (double) totalComparisons / numTrials;
        System.out.println("Average number of comparisons over 100 trials: " + averageComparisons);

        int[] arraySizes = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
        for (int size : arraySizes) {
            OrdArray newArray = new OrdArray(size);
            for (int i = 0; i < size; i++) {
                long value = rand.nextInt(1000);
                newArray.insert(value);
            }
            totalComparisons = 0;
            numTrials = 100;
            for (int i = 0; i < numTrials; i++) {
                randomIndex = rand.nextInt(size);
                searchKey = newArray.getArray()[randomIndex];
                comparisons = newArray.find(searchKey);
                totalComparisons += comparisons;
            }
            averageComparisons = (double) totalComparisons / numTrials;
            System.out.println("Average number of comparisons for array size " + size + ": " + averageComparisons);
        }
    }
}