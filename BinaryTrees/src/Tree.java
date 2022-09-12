public class Tree {
    private Node root;

    public Tree () {

    }
    public Node getRoot () {
        return root;
    }

    public void insert (int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            root.insert(val);
        }
    }

    public void insert (Node val) {
        if (root == null) {
            root = val;
        } else {
            root.insert(val);
        }
    }
}
