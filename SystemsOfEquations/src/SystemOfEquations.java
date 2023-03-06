import java.util.Arrays;

public class SystemOfEquations {
    Matrix A, b;
    private char[] varNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};
    public SystemOfEquations (Matrix _A, Matrix _b) {
        A = _A;
        b = _b;
    }

    public String toString (char[] vars) {
        for (int r = 0; r < A.size(); r++) {
            for (int c = 0; c < A.size(); c++) {
                if (Math.abs(A.get(r, c)) < 0.0000001) A.set(r, c, 0);
            }
            if (Math.abs(b.get(r, 0)) < 0.0000001) b.set(r, 0, 0);
        }


        int[] lengths = new int[A.size()];
        for (int c = 0; c < A.size(); c++) {
            lengths[c] = (""+A.get(0, c)).length();
            for (int r = 1; r < A.size(); r++) {
                lengths[c] = Math.max(lengths[c], (""+A.get(r, c)).length());
            }
        }

        String out = "";
        for (int r = 0; r < A.size(); r++) {
            out += "[";
            for (int c = 0; c < A.size(); c++) {
                out += A.get(r, c);
                for (int i = 0; i < (lengths[c] - (""+A.get(r, c)).length()); i++) out += " ";
                if (!(c > A.size()-2)) {
                    out += ", ";
                }
            }
            out += "][" + vars[r%vars.length] + "]";
//            out += "][" + (char) r + "]";
            if (r == A.size()/2) out += " = ";
            else out += "   ";
            out += "[" + b.get(r, 0) + "]\n";

        }
        return out;
    }

    public String toString () {
        return toString(varNames);
    }

    public void backSub () {
        for (int i = A.size()-1; i >= 0; i--) {
            makeNonzeroOne(i, i);
            for (int j = A.size()-1; j > i; j--) {
                makeZero(i, j);
            }
        }
        makeNonzeroOne(0, 0);
    }

    public void twiangle () {
        removeAllZeros();
        for (int r = 1; r < A.size(); r++) {
            for (int c = 0; c < r; c++) {
                makeZero(r, c);
            }
        }
    }

    public void solve () {
        twiangle();
        backSub();
    }

    public void removeAllZeros () {
        firstRowNoZeros();
        for (int r = 0; r < A.size(); r++) {
            while (rowHasZero(r)) {
                addRow(r, 0);
            }
        }
    }

    private void firstRowNoZeros () {
        while (rowHasZero(0)) {
            for (int c = 0; c < A.size(); c++) {
                if (A.get(0, c) == 0) {
                    int r = rowWithoutZeroAt(c);
                    multRow(r, Math.random());
                    addRow(0, r);
                }
            }
        }
    }

    private boolean rowHasZero (int row) {
        for (int c = 0; c < A.size(); c++) {
            if (Math.abs(A.get(row, c)) < 0.00001) {
                return true;
            }
        }
        return false;
    }

    private int rowWithoutZeroAt (int c) {
        for (int r = 0; r < A.size(); r++) {
            if (A.get(r, c) != 0) return r;
        }
        return -1;
    }

    public void makeZero (int r, int c) {
        double val = A.get(r, c);
        multRow(r, 1/val);
        multRow(c, -1/A.get(c, c));
        addRow(r, c);
        multRow(c, -1);
    }

    public void makeNonzeroOne (int r, int c) {
        multRow(r, 1/A.get(r, c));
    }


    public void addRow(int r0, int r1) {
        b.addRow(r0, r1);
        A.addRow(r0, r1);
    }

    public void multRow(int r, double x) {
        b.multRow(r, x);
        A.multRow(r, x);
    }

    public Matrix getA() {
        return A;
    }

    public Matrix getb() {
        return b;
    }

    public boolean equals (SystemOfEquations other) {
        if (!A.equals(other.getA())) return false;
        if (!b.equals(other.getb())) return false;
        return true;
    }
}
