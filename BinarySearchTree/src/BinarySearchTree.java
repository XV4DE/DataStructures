// Simon Chess 9/16/22
import java.util.ArrayList;

public class BinarySearchTree {
    public Node root;

    /**
     * Gets the root of this tree.
     * @return the root.
     */
    public Node getRoot() {return root;}

    /**
     * Inserts a new node into this tree while maintaining the binary search tree property.
     * @param a the key of the new node to be inserted
     */
    public void insert(int a) {
        if (root == null) root = new Node(a);
        else root.insert(a);
    }

    /**
     * Inserts a new node into this tree while maintaining the binary search tree property.
     * @param a the key of the new node to be inserted
     */
    public void insert(Node a) {
        if (root == null) root = a;
        else root.insert(a);
    }

    /**
     * Finds a node with the provided key in this tree.
     * @param n the key of the node to be found.
     * @return a node with key n or null if there is no such node in this tree.
     */
    public Node find(int n) {
        // Starts with the node with the smallest key in the tree and moves along in ascending order
        Node active = root.getFarLeft();
        while (active != null) {
            if (active.getKey() == n) return active;
            active = active.getSuccessor();
        }
        return null;
    }

    /**
     * Utilizes helper methods to delete a node from this tree while maintaining the binary search tree property.
     * @param n the node to be deleted from this tree.
     */
    public void delete(Node n) {
        int children = 0;
        if (n.getRchild() != null) children++;
        if (n.getLchild() != null) children++;

        if (children == 0) {
            trim(n);
        } else if (children == 1) {
            splice(n);
        } else {
            rotate(n);
        }
    }

    /**
     * A delete helper method, deletes a node with no children while maintaining the binary search tree property.
     * @param n the node to be deleted.
     */
    private void trim(Node n) {
        assert (n.getRchild() == null && n.getLchild() == null);

        if (n.getParent() != null) {
            // if n is a left child...
            if (n.getParent().getLchild().equals(n)) n.getParent().setLchild(null);
            else n.getParent().setRchild(null);
        }
    }

    /**
     * A delete helper method, deletes a node with one child while maintaining the binary search tree property.
     * @param n the node to be deleted.
     */
    private void splice(Node n) {
        // asserts that n has exactly one child
        assert (n.getRchild() != null || n.getLchild() != null) && !(n.getRchild() != null && n.getLchild() != null);

        Node child;
        if (n.getLchild() != null) child = n.getLchild();
        else child = n.getRchild();

        if (n.getParent() != null) {
            // if n is a left child...
            if (n.getParent().getLchild().equals(n)) n.getParent().setLchild(child);
            else n.getParent().setRchild(child);
        }

    }

    /**
     * A delete helper method, deletes a node with two children while maintaining the binary search tree property.
     * @param n the node to be deleted.
     */
    private void rotate(Node n) {
        assert (n.getRchild() != null && n.getLchild() != null);
        Node successor = n.getSuccessor();

        // make the successor's parent and children forget about it, so it's ready to be moved
        delete(successor);
        if (n.getParent() != null) {
            // if n is a left child...
            if (n.getParent().getLchild().equals(n)) n.getParent().setLchild(successor);
            else n.getParent().setRchild(successor);
        }
        // make the successor inherit all of the deleted node's children and parent.
        successor.setParent(n.getParent());
        successor.setLchild(n.getLchild());
        successor.setRchild(n.getRchild());
        n.getRchild().setParent(successor);
        n.getLchild().setParent(successor);
    }

    /**
     * Makes a sorted array (smallest to largest) of the keys of all of the nodes in the tree.
     * @return that sorted array.
     */
    public ArrayList<Integer> treeWalk() {
        ArrayList<Integer> keys = new ArrayList<>();
        Node active = root.getFarLeft();
        while (active != null) {
            keys.add(active.getKey());
            active = active.getSuccessor();
        }
        return keys;
    }

    /**
     * Finds the depth of this tree, a tree with one node has a depth of 0, two has 1, etc.
     * @return the depth of this tree.
     */
    public int depth() {
        return root.depth();
    }
}