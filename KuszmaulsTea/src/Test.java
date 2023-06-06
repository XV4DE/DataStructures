import java.util.Arrays;

public class Test {
    static int test = 0;
    static int pass = 0;

    public static void main(String[] args) {
        passOnTrue(timestampConstructor());
        passOnTrue(unitConstructor());
        passOnTrue(measurementConstructor());
        passOnTrue(nodeConstructor());
        passOnTrue(nodeHyperfloor());
        passOnTrue(nodeIsAPowerOfTwo());
        passOnTrue(nodeSubserve());
        passOnTrue(nodeUsurp());
        passOnTrue(treeInsert());

        System.out.println("Passed " + pass + " of " + test + " tests.");
    }

    public static boolean timestampConstructor() {
        for (int i = 0; i < 1000; i++) {
            Timestamp t = new Timestamp();
            long theTime = t.time;
            Timestamp a = Timestamp.testConstructor(theTime);
            if (!t.equals(a)) return false;
        }
        return true;
    }

    public static boolean measurementConstructor() {
        for (int i = 0; i < 1000; i++) {
            Unit C = new Unit("C");
            Measurement m = new Measurement(0, C);
            Measurement n = Measurement.testConstructor(0, C, m.time.time);
            if (!m.equals(n)) return false;
        }
        return true;
    }

    public static boolean unitConstructor() {
        Unit u = new Unit("C");
        Unit v = new Unit("C");
        if (!u.equals(v)) return false;
        Unit b = new Unit("mL");
        if (u.equals(b)) return false;
        return true;
    }

    public static boolean nodeConstructor() {
        for (int i = 0; i < 1000; i++) {
            Unit C = new Unit("C");
            Node n = new Node(new Measurement(0, C));
            Node m = new Node(Measurement.testConstructor(0, C, Timestamp.testConstructor(n.time)));
            if (!n.equals(m)) return false;
        }
        return true;
    }

    public static boolean nodeHyperfloor() {
        for (int i = 1; i < 10; i++) {
            int correct = Node.exp2(i);
            for (int j = 0; j < correct; j++) {
                int attempt = correct+j;
                if (Node.hyperfloor(attempt) != correct) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean nodeIsAPowerOfTwo() {
        for (int i = 1; i <= 262144; i*=2) {
            if (!Node.isAPowerOfTwo(i)) return false;
        }
        return true;
    }

    public static boolean nodeSubserve() {
        Unit C = new Unit("C");
        for (int i = 1000; i < 10000; i++) {
            Node n = new Node(new Measurement(i, C));
            Node m = new Node(new Measurement(i * Math.random(), C));
            n.subserve(m);
            if (!m.rChild.equals(n) || !n.parent.equals(m)) return false;
        }
        return true;
    }

    public static boolean nodeUsurp() {
        Unit C = new Unit("C");
        for (int i = 1000; i < 10000; i++) {
            Node n = new Node(new Measurement(i, C));
            Node m = new Node(new Measurement(i * Math.random(), C));
            n.usurp(m);
            if (!n.lChild.equals(m) || !m.parent.equals(n)) return false;
        }
        return true;
    }


    public static boolean treeInsert() {
        Unit C = new Unit("C");
        for (int i = 1; i < 10; i++) {
            Measurement[] measures = new Measurement[i];
            measures[0] = Measurement.testConstructor(i, C, Timestamp.testConstructor(0));
            TimeTree tree = new TimeTree(new Node(measures[0]));
            for (int j = 1; j < i; j++) {
                measures[j] = Measurement.testConstructor(i, C, Timestamp.testConstructor(j));
                tree.insert(measures[j]);
            }

            if (!Arrays.equals(measures, tree.getContents())) {
                System.out.println(tree);
                System.out.println(tree.getRoot().time);
                System.out.println(tree.getRoot().lChild.time);
                return false;
            }
        }
        return true;
    }

    private static void passOnTrue(boolean output) {
        test++;
        if (output) pass++;
    }
}
