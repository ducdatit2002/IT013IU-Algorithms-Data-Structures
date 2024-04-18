import java.util.*;

class Node implements Comparable<Node> {
    public final String name;
    public int distance = Integer.MAX_VALUE;
    public Node previous = null;
    public final Map<Node, Integer> neighbours = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbour(Node neighbour, int weight) {
        neighbours.put(neighbour, weight);
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(distance, other.distance);
    }
}

class Graph {
    private final Map<String, Node> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addNode(String nodeName) {
        graph.put(nodeName, new Node(nodeName));
    }

    public void addEdge(String node1, String node2, int weight) {
        graph.get(node1).addNeighbour(graph.get(node2), weight);
        graph.get(node2).addNeighbour(graph.get(node1), weight); // For undirected graph
    }

    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            throw new NoSuchElementException("Node does not exist in the graph.");
        }
        final Node source = graph.get(startName);
        NavigableSet<Node> q = new TreeSet<>();

        // Set-up vertices
        for (Node v : graph.values()) {
            v.previous = v == source ? source : null;
            v.distance = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    // Implementation of dijkstra's algorithm using a binary heap.
// Modify the dijkstra method to track visited nodes
    private void dijkstra(final NavigableSet<Node> q) {
        Set<Node> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Node u = q.pollFirst(); // vertex with shortest distance
            if (visited.contains(u)) continue; // Skip nodes that have already been visited
            visited.add(u);

            // Look at distances to each neighbour
            for (Map.Entry<Node, Integer> a : u.neighbours.entrySet()) {
                Node v = a.getKey();

                final int alternateDist = u.distance + a.getValue();
                if (alternateDist < v.distance) { // Shorter path to neighbour found
                    q.remove(v); // These two lines are not necessary with the visited set
                    v.distance = alternateDist;
                    v.previous = u;
                    q.add(v); // And this line
                }
            }
        }
    }

    public List<String> getShortestPath(String endName) {
        if (!graph.containsKey(endName)) {
            throw new NoSuchElementException("Node does not exist in the graph.");
        }
        return getPath(graph.get(endName));
    }

    // This method returns the path from the source to the selected target and NULL if no path exists
    public List<String> getPath(Node target) {
        List<String> path = new ArrayList<>();
        for (Node at = target; at != null; at = at.previous) {
            if (path.contains(at.name)) {
                throw new IllegalStateException("Cycle detected in the path. This should not happen with Dijkstra's algorithm.");
            }
            path.add(at.name);
        }
        Collections.reverse(path);
        return path;
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        Graph g = new Graph();
        
        // Add all nodes
        for (char nodeName = 'A'; nodeName <= 'L'; nodeName++) {
            g.addNode(String.valueOf(nodeName));
        }

        // Add the edges as per your graph
        g.addEdge("A", "B", 6);
        g.addEdge("A", "D", 10);
        g.addEdge("A", "E", 12);
        g.addEdge("B", "C", 11);
        g.addEdge("B", "D", 14);
        g.addEdge("C", "D", 4);
        g.addEdge("C", "F", 3);
        g.addEdge("D", "E", 4);
        g.addEdge("E", "F", 16);
        g.addEdge("E", "H", 12);
        g.addEdge("F", "G", 8);
        g.addEdge("G", "I", 8);
        g.addEdge("H", "I", 13);
        g.addEdge("H", "J", 9);
        g.addEdge("H", "K", 12);
        g.addEdge("I", "J", 18);
        g.addEdge("I", "L", 17);
        g.addEdge("J", "K", 15);
        g.addEdge("J", "L", 20);
        g.addEdge("K", "L", 9);

        // Compute paths
        g.dijkstra("A");

        // Print shortest path
        System.out.println("Shortest path from A to J: " + g.getShortestPath("J"));
        System.out.println("Shortest path from B to L: " + g.getShortestPath("L"));
    }
}
