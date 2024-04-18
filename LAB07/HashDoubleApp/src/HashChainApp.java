class HashChainApp {
  public HashChainApp() {
    hashTable = new HashTable();
  }

  // Assuming you have a HashTable class
  private HashTable hashTable;
  private int totalProbeLengthForInserts = 0;
  private int totalInserts = 0;

  // Method to insert a key into the hash table
  public void insert(int key) {
    int probeLength = hashTable.insert(key);
    totalProbeLengthForInserts += probeLength;
    totalInserts++;
    System.out.println("Inserted key " + key + " with probe length " + probeLength);
  }

  // Method to find a key in the hash table
  public void find(int key) {
    int probeLength = hashTable.find(key);
    System.out.println("Found key " + key + " with probe length " + probeLength);
  }

  // Method to get the average probe length for inserts
  public double getAverageProbeLengthForInserts() {
    return (double) totalProbeLengthForInserts / totalInserts;
  }

  // Method to get the load factor of the hash table
  public double getLoadFactor() {
    int capacity = (int) hashTable.getCapacity();
    if (capacity == 0) {
      return 0.0; // or some other value that makes sense in your context
    }
    return (double) hashTable.getSize() / capacity;
  }

  public static void main(String[] args) {
    HashChainApp app = new HashChainApp();
    app.hashTable = new HashTable();
    // Insert keys
    app.insert(1);
    app.insert(2);
    // Find keys
    app.find(1);
    // Print average probe length for inserts
    System.out.println("Average probe length for inserts: " + app.getAverageProbeLengthForInserts());
    // Print load factor
    System.out.println("Load factor: " + app.getLoadFactor());
  }
}