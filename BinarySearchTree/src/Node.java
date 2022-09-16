// Simon Chess 9/16/22
public class Node {
    private Node parent;
    private Node rchild;
    private Node lchild;
    private int key;

    /**
     * The default constructor, all fields are initialized to null by default.
     */
    public Node() {

    }

    /**
     * A constructor that sets the key of the node.
     * @param _key the key of the new node.
     */
    public Node(int _key) {
        key = _key;
    }

    /**
     * A constructor that sets the key and the parent of the node.
     * @param _key the key of the new node.
     * @param _parent the parent of the new node.
     */
    public Node(int _key, Node _parent) {
        key = _key;
        parent = _parent;
    }

    /**
     * Getter function for key.
     * @return the key of this node.
     */
    public int getKey() {
        return key;
    }

    /**
     * Getter function for parent.
     * @return the parent of this node.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Getter function for right child.
     * @return the right child of this node.
     */
    public Node getRchild() {
        return rchild;
    }

    /**
     * Getter function for left child.
     * @return the left child of this node.
     */
    public Node getLchild() {
        return lchild;
    }

    /**
     * Finds the smallest node in the tree for which this node is the root.
     * @return the smallest node in the tree for which this node is the root.
     */
    public Node getFarLeft() {
        if (lchild == null) return this;
        else return lchild.getFarLeft();
    }

    /**
     * Finds the successor of this node, the node whose key would appear directly after this one were they in a sorted
     * list (lowest to highest) of all keys in the tree.
     * @return the successor of this node.
     */
    public Node getSuccessor() {
        if (rchild != null) {
            return rchild.getFarLeft();
        }
        // if this node is a left child...
        if (parent != null && parent.getLchild() != null && parent.getLchild().equals(this)) {
            return parent;
        }
        Node active = this;
        // go up the tree until you find a node that's a left child, when you do, that child's parent is the successor
        while (active.getParent() != null) {
            if (active.getParent().getLchild() != null && active.getParent().getLchild().equals(active)) {
                return active.getParent();
            }
            active = active.getParent();
        }
        return null;
    }

    /**
     * Sets the parent of the current node, I'm gonna be honest I don't think this should exist, but I'm not sure what
     * the way around it is.
     * @param _parent the new parent.
     */
    public void setParent(Node _parent) {
        parent = _parent;
    }

    /**
     * Sets the right child of this node, again, not sure if this should be a thing.
     * @param _rchild the new right child.
     */
    public void setRchild(Node _rchild) {
        rchild = _rchild;
    }

    /**
     * Sets the left child of this node.
     * @param _lchild the new left child.
     */
    public void setLchild(Node _lchild) {
        lchild = _lchild;
    }

    /**
     * Inserts a node into the tree for which this node is the root while maintaining the binary search tree property.
     * @param n the key of the new node to be inserted.
     */
    public void insert(int n) {
        // right child case
        if (n > key) {
            // don't insert into a made child
            if (rchild == null) {
                rchild = new Node(n, this);
            } else {
                rchild.insert(n);
            }
            // left child case
        } else {
            // don't insert into a made child
            if (lchild == null) {
                lchild = new Node(n, this);
            } else {
                lchild.insert(n);
            }
        }
    }

    /**
     * Inserts a node into the tree for which this node is the root while maintaining the binary search tree property.
     * @param n the new node to be inserted.
     */
    public void insert(Node n) {
        if (n.getKey() > key) {
            // don't insert into a made child
            if (rchild == null) {
                rchild = n;
                n.setParent(this);
            } else {
                rchild.insert(n);
            }
        } else {
            // don't insert into a made child
            if (lchild == null) {
                lchild = n;
                n.setParent(this);
            } else {
                lchild.insert(n);
            }
        }
    }

    /**
     * Finds the distance from the bottommost node of the tree.
     * @return the depth of this node.
     */
    public int depth() { // copied from the whiteboard in class
        if (lchild == null && rchild == null) return 0;
        else {
            if (lchild == null) return rchild.depth() + 1;
            if (rchild == null) return lchild.depth() + 1;
            return Math.max(rchild.depth(), lchild.depth()) + 1;
        }
    }
}


