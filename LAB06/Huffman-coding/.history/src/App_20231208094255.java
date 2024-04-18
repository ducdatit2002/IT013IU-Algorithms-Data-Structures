import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanTree {
    public static void main(String[] args) {
        String text = "I am a student at International University. My name is YOUR NAME. I am working on a DSA lak";
        HuffmanNode root = buildHuffmanTree(text);

        // Display the Huffman coding tree
        System.out.println("Huffman Coding Tree:");
        printHuffmanTree(root, "");
    }

    private static HuffmanNode buildHuffmanTree(String text) {
        // Step 1: Calculate frequencies of characters
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build a priority queue of Huffman nodes
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (char key : frequencyMap.keySet()) {
            priorityQueue.add(new HuffmanNode(key, frequencyMap.get(key)));
        }

        // Step 3: Build the Huffman coding tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            priorityQueue.add(parent);
        }

        // The remaining node is the root of the Huffman tree
        return priorityQueue.poll();
    }

    private static void printHuffmanTree(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.data + ": " + code);
        }

        printHuffmanTree(root.left, code + "0");
        printHuffmanTree(root.right, code + "1");
    }
}
