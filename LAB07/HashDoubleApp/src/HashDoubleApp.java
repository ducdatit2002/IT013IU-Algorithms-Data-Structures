public class HashDoubleApp {
  private int size;
  private int[] table;
  private int probeCount;

  public HashDoubleApp(int size) {
    this.size = size;
    this.table = new int[size];
  }

  public void insert(int key) {
    int hash = key % size;
    int probes = 0;
    while (table[hash] != 0) {
      hash = (hash + 1) % size;
      probes++;
    }
    table[hash] = key;
    probeCount += probes;
    System.out.println("Inserted key " + key + " at position " + hash + " with " + probes + " probes.");
  }

  public void find(int key) {
    int hash = key % size;
    int probes = 0;
    while (table[hash] != key) {
      hash = (hash + 1) % size;
      probes++;
    }
    System.out.println("Found key " + key + " at position " + hash + " with " + probes + " probes.");
  }

  public void printAverageProbeLength() {
    System.out.println("Average probe length: " + (double) probeCount / size);
  }

  public static void main(String[] args) {
    HashDoubleApp hashTable = new HashDoubleApp(10); // Create a hash table of size 10

    // Insert keys into the hash table
    for (int i = 1; i <= 5; i++) {
      hashTable.insert(i);
    }

    // Find keys in the hash table
    for (int i = 1; i <= 5; i++) {
      hashTable.find(i);
    }

    // Print the average probe length
    hashTable.printAverageProbeLength();
  }

}