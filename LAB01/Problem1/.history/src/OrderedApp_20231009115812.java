// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {

  private long[] a;
  private int nElems;
  private int comparisons;

  public OrdArray(int max) {
    a = new long[max];
    nElems = 0;
  }

  public void resetComparisons() {
    comparisons = 0;
  }

  public int getComparisons() {
    return comparisons;
  }

  public int find(long searchKey) {
    
    comparisons = 0;

    int lowerBound = 0; 
    int upperBound = nElems - 1;
    int curIn;

    while (true) {

      comparisons++;

      curIn = (lowerBound + upperBound) / 2;

      if (a[curIn] == searchKey)
        return comparisons;
      else if (lowerBound > upperBound) 
        return nElems;
      else {
        if (a[curIn] < searchKey)
          lowerBound = curIn + 1;    
        else
          upperBound = curIn - 1; 
      }

    }

  }

  // rest of class implementation

}
public class OrderedApp {

  public static void main(String[] args) {

    double[] avgComparisons = new double[11];

    for(int size=100; size<=1000; size+=100) {

      OrdArray arr = new OrdArray(size);

      // insert random items
      for(int i=0; i<size; i++) {
        arr.insert((int)(Math.random()*size));
      }

      double totalComparisons = 0;

      for(int trial=0; trial<100; trial++) {

        arr.resetComparisons();

        int randomKey = arr.a[(int)(Math.random()*size)];
        int index = arr.find(randomKey);

        totalComparisons += arr.getComparisons();

      }

      avgComparisons[size/100] = totalComparisons/100;

      System.out.println("Average comparisons for n=" + 
                         size + ": " + avgComparisons[size/100]);

    }

  }

}
	public static void main(String[] args) {
		int maxSize = 100; 
		OrdArray arr = arr = new OrdArray(maxSize); 
		OrdArray arr2 = arr2 = new OrdArray(maxSize); 

		arr.insert(1);
		arr.insert(3);
		arr.insert(2);

		arr2.insert(2);
		arr2.insert(77);
		arr2.insert(99);
		arr2.insert(44);
		arr2.insert(55);
		arr2.insert(22);
		arr2.insert(88);
		arr2.insert(11);
		arr2.insert(00);
		arr2.insert(66);
		arr2.insert(33);
		
		OrdArray mergedArray = arr.merge(arr2, 2*maxSize);
		System.out.println("Merged Array: ");
		mergedArray.display();
	} // end main()
} // end class OrderedApp
