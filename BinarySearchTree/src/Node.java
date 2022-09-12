public class Node {
    private final Node parent;
    private Node rchild;
    private Node lchild;
    private int key;

    public Node() {
        parent = null;
    }

    public Node(int _key) {
        key = _key;
        parent = null;
    }

    public Node(int _key, Node _parent) {
        key = _key;
        parent = _parent;
    }

    public int getKey() {
        return key;
    }

    public Node getParent() {return parent;}

    public Node getRchild() {
        return rchild;
    }

    public Node getLchild() {return lchild;}

    public Node getSuccessor() {
        return null;
    }


    public void insert(int n) {
        // right child case
        if (n >= key) {
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
}


