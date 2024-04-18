import java.util.Arrays;
import java.util.Random;

class SortingAnalysis {
    private static int comparisons;
    private static int copies;
    private static int swaps;

    public static void resetCounters() {
        comparisons = 0;
        copies = 0;
        swaps = 0;
    }

    public static void insertionSort(int[] arr) {
        resetCounters();

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                copies++;
                swaps++;
                j--;
            }

            if (j >= 0) {
                comparisons++;
            }

            arr[j + 1] = key;
            copies++;
        }
    }

    public static void selectionSort(int[] arr) {
        resetCounters();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swaps++;
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                copies += 3;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        resetCounters();

        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    copies += 3;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arraySizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};

        System.out.println("Array Size\tInsertion Sort\tSelection Sort\tBubble Sort");
        System.out.println("-----------------------------------------------------------");

        for (int size : arraySizes) {
            int[] arr = generateRandomArray(size);

            int[] arrCopy = Arrays.copyOf(arr, arr.length);
            insertionSort(arrCopy);
            int insertionSortComparisons = comparisons;
            int insertionSortCopies = copies;
            int insertionSortSwaps = swaps;

            arrCopy = Arrays.copyOf(arr, arr.length);
            selectionSort(arrCopy);
            int selectionSortComparisons = comparisons;
            int selectionSortCopies = copies;
            int selectionSortSwaps = swaps;

            arrCopy = Arrays.copyOf(arr, arr.length);
            bubbleSort(arrCopy);
            int bubbleSortComparisons = comparisons;
            int bubbleSortCopies = copies;
            int bubbleSortSwaps = swaps;

            System.out.printf("%d\t\t%d\t\t%d\t\t%d\n", size, insertionSortComparisons, selectionSortComparisons, bubbleSortComparisons);
            System.out.printf(" \t\t%d\t\t%d\t\t%d\n", insertionSortCopies, selectionSortCopies, bubbleSortCopies);
            System.out.printf(" \t\t%d\t\t%d\t\t%d\n", insertionSortSwaps, selectionSortSwaps, bubbleSortSwaps);
            System.out.println("-----------------------------------------------------------");
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
}