import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Testing {
    public static int passes = 0;
    public static int tests = 0;

    public static void main(String[] args) {
        passOnTrue(pcConstructor());
        passOnTrue(sidedConstructor());
        passOnTrue(evaluate());
        passOnTrue(getAllPcs());
        passOnTrue(truthTable());
        System.out.println("Passed " + passes + " of " + tests + ".");
    }

    public static boolean pcConstructor () {
        for (int i = 1; i < 100; i++) {
            Phrase p = new Phrase(false, i);
            if (p.getPc() != i) return false;
        }
        return true;
    }

    public static boolean sidedConstructor () {
        Phrase p = new Phrase(false, 1);
        Phrase p1 = new Phrase(false, p, p);
        if (p1.getLeft().getPc() != 1 || p1.getRight().getPc() != 1) return false;
        Phrase p2 = new Phrase(false, p1, p1);
        if (p2.getLeft().getLeft().getPc() != 1) return false;
        return true;
    }

    public static boolean evaluate () {
        Phrase p = new Phrase(false, 1);
        if (!p.evaluate(new boolean[]{true})) return false;
        Phrase p1 = new Phrase (false, p, p);
        if (!p1.evaluate(new boolean[]{true})) return false;

        Phrase np = new Phrase (true, 1);
        Phrase p2 = new Phrase (false, p, np);
        if (p2.evaluate(new boolean[]{true})) return false;

        Phrase p3 = new Phrase(false, 2);
        Phrase p4 = new Phrase(true, p2, p3);
        if (!p4.evaluate(new boolean[]{true, false})) return false;
        return true;
    }

    public static boolean getAllPcs () {
        Phrase p = new Phrase(false, 1);
        if (!p.getAllPcs().equals(new HashSet<>(List.of(1)))) return false;
        Phrase p1 = new Phrase(false, p, p);
        if (!p1.getAllPcs().equals(new HashSet<>(List.of(1)))) return false;
        Phrase p2 = new Phrase(false, 2);
        Phrase p3 = new Phrase (false, p1, p2);
        if (!p3.getAllPcs().equals(new HashSet<>(List.of(1, 2)))) return false;
        return true;
    }

    public static boolean truthTable () {
        Phrase p = new Phrase(false, 1);
        TruthTable t = new TruthTable();
        t.put(new boolean[]{false}, false);
        t.put(new boolean[]{true}, true);
        if (!p.truthTable().equals(t)) return false;

        Phrase p1 = new Phrase(false, 2);
        Phrase p3 = new Phrase(false, p, p1);
        TruthTable t1 = new TruthTable();
        t1.put(new boolean[]{false, false}, false);
        t1.put(new boolean[]{true, false}, false);
        t1.put(new boolean[]{false, true}, false);
        t1.put(new boolean[]{true, true}, true);
        if (!p3.truthTable().equals(t1)) return false;
        return true;
    }

    public static void passOnTrue (boolean b) {
        tests++;
        if (b) passes++;
    }
}
