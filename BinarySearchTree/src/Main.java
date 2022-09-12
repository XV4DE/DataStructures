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

        System.out.println("passed " + pass + ", failed " + fail);
    }

    public static boolean testDefaultConstructor() {
        Node n = new Node();
        return n.getLchild() == null && n.getRchild() == null && n.getParent() == null;
    }

    public static boolean testConstructor() {
        Node fe = new Node(3);
        return fe.getKey() == 3;
    }

    public static boolean testInsert() {
        Node fn = new Node(2);
        fn.insert(3);
        return fn.getRchild().getKey() == 3;
    }

    public static boolean testInsert2() {
        Node fn = new Node(2);
        fn.insert(3);
        fn.insert(4);
        return fn.getRchild().getRchild().getKey() == 4;
    }

    public static boolean testInsert3() {
        Node fn = new Node(3);
        fn.insert(2);
        return fn.getLchild().getKey() == 2;
    }

    public static boolean testInsert4() {
        Node fn = new Node(3);
        Node sn = new Node(2);
        fn.insert(2);
        return fn.getLchild().getParent().equals(fn);
    }
}
