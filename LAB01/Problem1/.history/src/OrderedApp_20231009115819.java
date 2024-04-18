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