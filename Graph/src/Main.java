public class Main {
    static int pass, fail;

    public static void main(String[] args) {
        passOnTrue(testNode());
        passOnTrue(testEdge());

        System.out.println("Passed " + pass + ", failed " + fail);
    }

    /**
     * Tests the two methods of the Node class, the constructor and toString.
     * @return true if the test passed, false if it failed.
     */
    public static boolean testNode () {
        if (!new Node(6).toString().equals("6")) return false;
        if (!new Node(0).toString().equals("0")) return false;
        if (!new Node(-1).toString().equals("-1")) return false;

        return true;
    }

    /**
     * Tests the two methods of the Edge class, the constructor and toString
     * @return true if the test passed, false if it failed.
     */
    public static boolean testEdge () {
        if (!new Edge(new Node(6), new Node(-1)).toString().equals("6 => -1")) return false;
        if (!new Edge(new Node(-5), new Node(9)).toString().equals("-5 => 9")) return false;
        if (!new Edge(new Node(0), new Node(0)).toString().equals("0 => 0")) return false;

        return true;
    }


    /**
     * A helper method for making testing easier.
     * @param b a boolean, intended to be the output of a test.
     */
    public static void passOnTrue (boolean b) {
        if (b) pass++;
        else fail++;
    }
}
