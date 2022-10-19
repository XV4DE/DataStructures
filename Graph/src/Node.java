public class Node {
    private final int val;

    /**
     * A constructor, initializes the value of the node to input.
     * @param val the value that the Node should assume.
     */
    public Node (int val) {
        this.val = val;
    }

    /**
     * Converts the Node to a String.
     * @return the Node's value as a String.
     */
    public String toString () {
        return ((Integer) val).toString();
    }
}
