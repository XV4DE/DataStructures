// Simon Chess 9/16/22
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args) {
        if (testConstructor()) pass++;
        else fail++;

        if (testDefaultConstructor()) pass++;
        else fail++;

        if (testInsert()) pass++;
        else fail++;

        if (testInsert2()) pass++;
        else fail++;

        if (testInsert3()) pass++;
        else fail++;

        if (testInsert4()) pass++;
        else fail++;

        if (testGetFarLeft()) pass++;
        else fail++;

        if (testGetSuccessor()) pass++;
        else fail++;

        if (testSetParent()) pass++;
        else fail++;

        if (testSetParent2()) pass++;
        else fail++;

        if (testSetLChild()) pass++;
        else fail++;

        if (testSetRChild()) pass++;
        else fail++;

        if (testTreeInsert()) pass++;
        else fail++;

        if (testFind()) pass++;
        else fail++;

        if (testTreeWalk()) pass++;
        else fail++;

        if (testTrim()) pass++;
        else fail++;

        if (testSplice()) pass++;
        else fail++;

        if (testRotate()) pass++;
        else fail++;

        if (testDepth()) pass++;
        else fail++;

        System.out.println("passed " + pass + ", failed " + fail);
    }

    /**
     * Tests the default Node constructor for creating a node.
     * @return whether the test was passed.
     */
    public static boolean testDefaultConstructor() {
        Node n = new Node();
        return n.getLchild() == null && n.getRchild() == null && n.getParent() == null;
    }

    /**
     * Tests the node constructor Node(int _key) for creating a node with a provided key.
     * @return whether the test was passed.
     */
    public static boolean testConstructor() {
        Node fe = new Node(3);
        return fe.getKey() == 3;
    }

    /**
     * Tests the insert method of the Node class for inserting and some maintenance of the binary search tree property.
     * @return whether the test was passed.
     */
    public static boolean testInsert() {
        Node fn = new Node(2);
        fn.insert(3);
        return fn.getRchild().getKey() == 3;
    }

    /**
     * Tests the insert method of the Node class for inserting and some maintenance of the binary search tree property.
     * @return whether the test was passed.
     */
    public static boolean testInsert2() {
        Node fn = new Node(2);
        fn.insert(3);
        fn.insert(4);
        return fn.getRchild().getRchild().getKey() == 4;
    }

    /**
     * Tests the insert method of the Node class for inserting and some maintenance of the binary search tree property.
     * @return whether the test was passed.
     */
    public static boolean testInsert3() {
        Node fn = new Node(3);
        fn.insert(2);
        return fn.getLchild().getKey() == 2;
    }

    /**
     * Tests the insert method of the Node class for inserting and some maintenance of the binary search tree property.
     * @return whether the test was passed.
     */
    public static boolean testInsert4() {
        Node fn = new Node(3);
        Node sn = new Node(2);
        fn.insert(sn);
        return fn.getLchild().getParent().equals(fn);
    }

    /**
     * Tests the Node method getFarLeft().
     * @return whether the test was passed.
     */
    public static boolean testGetFarLeft() {
        Node fn = new Node(3);
        fn.insert(3); //     3
        fn.insert(5); //   3    5
        fn.insert(4); //  3    4
        fn.insert(3); // 1
        fn.insert(1);
        return fn.getFarLeft().getKey() == 1;
    }

    /**
     * Tests the getSuccessor method of the Node class by imitating a tree walk.
     * @return whether the test was passed.
     */
    public static boolean testGetSuccessor() {
        Node fn = new Node(3);
        fn.insert(3); //     3
        fn.insert(5); //   3    5
        fn.insert(4); //  3    4
        fn.insert(3);//  1
        fn.insert(1);
        int[] out = new int[6];
        int idx = 0;
        Node active = fn.getFarLeft();
        while (active != null){
            out[idx++] = active.getKey();
            active = active.getSuccessor();
        }
        return Arrays.equals(out, new int[]{1, 3, 3, 3, 4, 5});
    }

    /**
     * Tests the method setParent of the Node class.
     * @return whether the test was passed.
     */
    public static boolean testSetParent() {
        Node fn = new Node();
        Node sn = new Node();
        sn.setParent(fn);
        return sn.getParent().equals(fn);
    }

    /**
     * Tests the method setLChild of the Node class
     * @return whether the test was passed.
     */
    public static boolean testSetLChild() {
        Node fn = new Node(3);
        Node sn = new Node(2);
        fn.setLchild(sn);
        return fn.getLchild().equals(sn);
    }

    /**
     * Tests the method setRChild of the Node class.
     * @return whether the test was passed.
     */
    public static boolean testSetRChild() {
        Node fn = new Node(3);
        Node sn = new Node(4);
        fn.setRchild(sn);
        return fn.getRchild().equals(sn);
    }

    /**
     * Tests the Node method setParent for a null case.
     * @return whether the test was passed.
     */
    public static boolean testSetParent2() {
        Node fn = new Node();
        Node sn = new Node();
        sn.setParent(fn);
        sn.setParent(null);
        return sn.getParent() == null;
    }

    /**
     * Tests the tree method insert.
     * @return whether the test was passed.
     */
    public static boolean testTreeInsert() {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(3);
        ft.insert(fn);
        Node sn = new Node(2);
        ft.insert(sn);
        return ft.getRoot() == fn && fn.getLchild().equals(sn);
    }

    /**
     * Tests the Tree method find.
     * @return whether the test was passed.
     */
    public static boolean testFind () {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(3);
        ft.insert(fn);
        Node sn = new Node(2);
        ft.insert(sn);
        return ft.find(3).equals(fn) && ft.find(2).equals(sn);
    }

    /**
     * Tests the Tree method treeWalk.
     * @return whether the test was passed.
     */
    public static boolean testTreeWalk() {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(7);                //        7
        ft.insert(fn);                              //      4   8
        ft.insert(4);                            //     2 5   10
        ft.insert(2);                            //    1
        ft.insert(1);
        ft.insert(5);
        ft.insert(8);
        ft.insert(10);

        ArrayList<Integer> correct = new ArrayList<>();
        correct.add(1);
        correct.add(2);
        correct.add(4);
        correct.add(5);
        correct.add(7);
        correct.add(8);
        correct.add(10);

        return ft.treeWalk().equals(correct);
    }

    /**
     * Tests the Tree method delete for the case where the deleted Node has no children
     * (expected to utilize the trim helper method).
     * @return whether the test was passed.
     */
    public static boolean testTrim () {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(3);
        ft.insert(fn);
        Node sn = new Node(2);
        ft.insert(sn);
        ft.delete(sn);
        fn.setLchild(null);
        return fn.getLchild() == null;
    }

    /**
     * Tests the Tree method delete for the case where the deleted Node has one child.
     * (expected to utilize the splice helper method).
     * @return whether the test was passed.
     */
    public static boolean testSplice () {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(3);
        ft.insert(fn);
        Node sn = new Node(2);
        ft.insert(sn);
        Node tn = new Node(1);
        ft.insert(tn);
        ft.delete(ft.find(2));
        return fn.getLchild().equals(tn);
    }

    /**
     * Tests the Tree method delete for the case where the deleted Node has two children
     * (expected to utilize the rotate helper method).
     * @return whether the test was passed.
     */
    public static boolean testRotate () {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(7);                //        7
        ft.insert(fn);                              //      4   8
        ft.insert(4);                            //     2 5   10
        ft.insert(2);                            //    1
        ft.insert(1);
        ft.insert(5);
        ft.insert(8);
        ft.insert(10);
        ft.delete(fn);

        BinarySearchTree st = new BinarySearchTree();
        st.insert(8);
        st.insert(4);
        st.insert(2);
        st.insert(1);
        st.insert(5);
        st.insert(10);

        return st.treeWalk().equals(ft.treeWalk());
    }

    /**
     * Tests the depth method of the Tree class.
     * @return whether the test was passed.
     */
    public static boolean testDepth() {
        BinarySearchTree ft = new BinarySearchTree();
        Node fn = new Node(7);                //        7
        ft.insert(fn);                              //      4   8
        ft.insert(4);                            //     2 5   10
        ft.insert(2);                            //    1
        ft.insert(1);
        ft.insert(5);
        ft.insert(8);
        ft.insert(10);
        if (ft.depth() != 3) return false;
        ft.delete(ft.find(1));
        return ft.depth() == 2;
    }
}
