public class Edge {
    private Node start, end;

    /**
     * The constructor, sets the start and end fields to input.
     * @param start the start Node for the new Edge.
     * @param end the end Node for the new Edge.
     */
    public Edge (Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The getter for the start field.
     * @return the start field.
     */
    public Node getStart() {
        return start;
    }

    /**
     * The getter for the end field.
     * @return the end field.
     */
    public Node getEnd() {
        return end;
    }

    /**
     * Converts the Edge to a String.
     * @return a String including the start and end Nodes.
     */
    public String toString () {
        return start.toString() + " => " + end.toString();
    }
}
