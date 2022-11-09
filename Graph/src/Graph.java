import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    public ArrayList<Node> nodes;
    public Edge[][] edges;

    /**
     * A constructor for Graph, initializes the Graph as input specifies.
     * @param n the set of Nodes to be in the Graph
     * @param e the set of Edges to be in the Graph
     */
    public Graph(HashSet<Node> n, HashSet<Edge> e) {
        nodes = new ArrayList<>();
        edges = new Edge[n.size()][n.size()];
        nodes.addAll(n);
        for (Edge edge : e) {
            try {
                edges[nodes.indexOf(edge.getStart())][nodes.indexOf(edge.getEnd())] = edge;
            } catch (IndexOutOfBoundsException exc) {
                throw new IllegalArgumentException("All edges must start and end at nodes in the graph.");
            }
        }
    }

    /**
     * Getter for the field nodes.
     * @return nodes.
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * Getter for the field edges.
     * @return edges.
     */
    public Edge[][] getEdges() {
        return edges;
    }
}

