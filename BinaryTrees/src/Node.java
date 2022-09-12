public class Node {
    private int key;
    private Node rchild, lchild, parent;

    public Node () {

    }

    public Node (int _key) {
        key = _key;
    }

    public int getKey () {
        return key;
    }

    public Node getRightChild () {
        return rchild;
    }

    public Node getLeftChild () {
        return lchild;
    }

    public void insert (int val) {
        if (val <= key) {
            if (lchild == null) lchild = new Node(val);
            else lchild.insert(val);
        } else {
            if (rchild == null) rchild = new Node(val);
            else rchild.insert(val);
        }
    }

    public void insert (Node val) {
        if (val.getKey() <= key) {
            if (lchild == null) lchild = val;
            else lchild.insert(val);
        } else {
            if (rchild == null) rchild = val;
            else rchild.insert(val);
        }
    }

    public Node findSuccessor () {
        return parent;
    }

//    public void delete () {
//        int children = 0;
//        if (lchild != null) children++;
//        if (rchild != null) children++;
//        if (children == 0) {
//            scrub
//        } else if (children == 1) {
//            splice
//        } else {
//            rotate
//        }
//    }
}
