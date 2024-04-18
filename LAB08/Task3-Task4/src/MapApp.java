import java.util.*;

class Node {
    String name;
    List<Edge> edges;

    Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    void addEdge(Node node, int weight) {
        edges.add(new Edge(node, weight));
    }
}

class Edge {
    Node to;
    int weight;

    Edge(Node to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Graph {
    private Map<String, Node> nodes = new HashMap<>();

    void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    void formGraph() {
        // Add nodes A through L
        for (char nodeName = 'A'; nodeName <= 'L'; nodeName++) {
            addNode(String.valueOf(nodeName));
        }

        // Add edges as per the figure provided
        addEdge("A", "B", 6);
        addEdge("A", "D", 10);
        addEdge("A", "E", 12);
        addEdge("B", "C", 11);
        addEdge("B", "D", 14);
        addEdge("C", "D", 4);
        addEdge("C", "F", 3);
        addEdge("D", "E", 4);
        addEdge("E", "F", 16);
        addEdge("E", "H", 12);
        addEdge("F", "G", 8);
        addEdge("G", "I", 8);
        addEdge("H", "I", 13);
        addEdge("H", "J", 9);
        addEdge("H", "K", 12);
        addEdge("I", "J", 18);
        addEdge("I", "L", 17);
        addEdge("J", "K", 15);
        addEdge("J", "L", 20);
        addEdge("K", "L", 9);
    }

    List<List<Node>> findAllPaths(Node start, Node end, Set<String> visited) {
        List<List<Node>> paths = new ArrayList<>();
        if (start.equals(end)) {
            List<Node> path = new ArrayList<>();
            path.add(start);
            paths.add(path);
            return paths;
        }

        visited.add(start.name);

        for (Edge edge : start.edges) {
            if (!visited.contains(edge.to.name)) {
                visited.add(edge.to.name);
                List<List<Node>> subPaths = findAllPaths(edge.to, end, visited);
                for (List<Node> subPath : subPaths) {
                    List<Node> newPath = new ArrayList<>();
                    newPath.add(start);
                    newPath.addAll(subPath);
                    paths.add(newPath);
                }
                visited.remove(edge.to.name);
            }
        }

        return paths;
    }

    void printAllPaths(String from, String to) {
        Node start = nodes.get(from);
        Node end = nodes.get(to);
        Set<String> visited = new HashSet<>();

        List<List<Node>> allPaths = findAllPaths(start, end, visited);
        System.out.println("Total paths found from " + from + " to " + to + ": " + allPaths.size());

        for (List<Node> path : allPaths) {
            System.out.print("Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).name);
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            int totalWeight = calculatePathWeight(path);
            System.out.println(", Total weight: " + totalWeight);
        }
    }

    int calculatePathWeight(List<Node> path) {
        int weight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node from = path.get(i);
            Node to = path.get(i + 1);
            for (Edge edge : from.edges) {
                if (edge.to.equals(to)) {
                    weight += edge.weight;
                    break;
                }
            }
        }
        return weight;
    }
}

public class MapApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.formGraph();
        graph.printAllPaths("A", "K");
    }
}
