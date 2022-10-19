import java.util.HashSet;

public class Graph {
    public HashSet<Node> nodes;
    public HashSet<Edge> edges;

    /**
     * A constructor for Graph, initializes the Graph as input specifies.
     * @param n the set of Nodes to be in the Graph
     * @param e the set of Edges to be in the Graph
     */
    public Graph(HashSet<Node> n, HashSet<Edge> e) {
        for (Node i : n) nodes.add(i);
        for (Edge i : e) edges.add(i);
    }

    /**
     * Getter for the field nodes.
     * @return nodes.
     */
    public HashSet<Node> getNodes() {
        return nodes;
    }

    /**
     * Getter for the field edges.
     * @return edges.
     */
    public HashSet<Edge> getEdges() {
        return edges;
    }
}

