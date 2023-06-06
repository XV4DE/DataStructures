import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Phrase {
    public final boolean negated;
    private Phrase left;
    private Phrase right;
    private int pc;

    public Phrase (boolean _negated, Phrase _left, Phrase _right) {
        negated = _negated;
        left = _left;
        right = _right;
    }

    public Phrase (boolean _negated, int _pc) {
        negated = _negated;
        pc = _pc;
    }

    public boolean evaluate (boolean[] vals) {
        boolean simpleAns = false;
        if (pc != 0){
            simpleAns = vals[pc-1];
        } else if (left != null && right != null) {
            simpleAns = left.evaluate(vals) && right.evaluate(vals);
        }
        if (negated) return !simpleAns;
        return simpleAns;
    }

    public HashSet<Integer> getAllPcs() {
        HashSet<Integer> out = new HashSet<>();
        if (pc != 0) out.add(pc);
        else {
            out.addAll(left.getAllPcs());
            out.addAll(right.getAllPcs());
        }
        return out;
    }

    public TruthTable truthTable () {
        ArrayList<boolean[]> outK = new ArrayList<>();
        ArrayList<Boolean> outV = new ArrayList<>();
        int len = (int) Math.pow(2, getAllPcs().size());
        for (int i = 0; i < len; i++) {
            boolean[] k = getBits(i, getAllPcs().size());
            boolean v = evaluate(k);
            outK.add(k);
            outV.add(v);
        }
        return new TruthTable(outK, outV);
    }

    private int getBit (int n, int pos) {
        return (n >> pos) & 1;
    }

    private boolean[] getBits (int n, int len) {
        boolean[] out = new boolean[len];
        for (int i = 0; i < len; i++) {
            out[i] = getBit(n, i) == 1;
        }
        return out;
    }

    public int getPc () {
        return pc;
    }

    public Phrase getLeft () {
        return left;
    }

    public Phrase getRight () {
        return right;
    }
}
