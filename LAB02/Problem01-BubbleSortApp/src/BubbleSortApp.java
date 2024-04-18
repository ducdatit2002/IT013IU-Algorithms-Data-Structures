class ArrayBub {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   private int nSwaps; // number of swaps
   private int nComparisons; // number of comparisons

   public ArrayBub(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      nSwaps = 0; // no swaps yet
      nComparisons = 0; // no comparisons yet
   }

   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   public void bubbleSort() {
      int out, in;

      for (out = nElems - 1; out > 1; out--) {
         System.out.print("Array: ");
         display(); // display the array
         nComparisons += out; // increment number of comparisons

         for (in = 0; in < out; in++) {
            if (a[in] > a[in + 1]) {
               swap(in, in + 1); // swap them
            }
            nComparisons++; // increment number of comparisons
         }

         System.out.println("Number of swaps after inner loop: " + nSwaps);
         System.out.println("Number of comparisons after inner loop: " + nComparisons);
      }
   }

   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;

      nSwaps++; // increase number of swaps by 1
   }

   public int getSwapNumber() {
      return nSwaps;
   }

   public int getComparisonNumber() {
      return nComparisons;
   }
}

class BubbleSortApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      ArrayBub arr; // reference to array
      arr = new ArrayBub(maxSize); // create the array

      arr.insert(77); // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      System.out.print("Original array: ");
      arr.display(); // display items

      arr.bubbleSort(); // bubble sort them

      System.out.print("Sorted array: ");
      arr.display(); // display them again

      // display the number of swaps and comparisons
      System.out.println("Number of swaps: " + arr.getSwapNumber());
      System.out.println("Number of comparisons: " + arr.getComparisonNumber());
      System.out.println("Total number of comparisons: " + (arr.getComparisonNumber() + arr.getSwapNumber()));
      System.out.println("Algorithm complexity: O(n^2)");
   }
}