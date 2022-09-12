public class Main {
    static int pass = 0;
    static int fail = 0;
    public static void main(String[] args) {

        testNodeConstructor();
        testTreeConstructor();
        testNodeInsert();
        testInsert();

        System.out.println("Run finished, passed " + pass + " tests, failed " + fail);
    }

    public static void testNodeConstructor () {
        Node no = new Node(3);
        passOnTrue(no.getKey() == 3);
        Node nt = new Node(4);
        passOnTrue(nt.getKey() == 4);
    }

    public static void testTreeConstructor () {
        Tree to = new Tree();
        passOnTrue(to.getRoot() == null);
    }

    public static void testNodeInsert () {
        Node no = new Node(3);
        no.insert(3);
        passOnTrue(no.getLeftChild().getKey() == 3);
        no.insert(4);
        passOnTrue(no.getRightChild().getKey() == 4);
        no.insert(2);
        passOnTrue(no.getLeftChild().getLeftChild().getKey() == 2);
        Node nt = new Node(5);
        no.insert(nt);
        passOnTrue(nt == no.getRightChild().getRightChild());


    }

    public static void testInsert () {
        Tree to = new Tree();
        to.insert(3);
        passOnTrue(to.getRoot().getKey() == 3);
        to.insert(4);
        passOnTrue(to.getRoot().getKey() == 3);
        passOnTrue(to.getRoot().getRightChild().getKey() == 4);
    }

    public static void testFindSuccessor () {
        Tree to = new Tree();
        Node no = new Node(3);
        to.insert(no);
        Node nt = new Node(2);
        to.insert(nt);
        passOnTrue(nt.findSuccessor() == no);
    }

    public static void passOnTrue (boolean b) {
        if (b) pass++;
        else fail++;
    }

}
