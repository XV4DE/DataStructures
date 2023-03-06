public class SystemOfEquations {
    public Matrix A, b;
    public SystemOfEquations (Matrix A_, Matrix b_) {
        A = A_;
        b = b_;
    }

    public void addRow (int r0, int r1) {
        A.rowAdd(r0, r1);
        b.rowAdd(r0, r1);
    }

    public void multRow (int r, double x) {
        A.rowMult(r, x);
        b.rowMult(r, x);
    }

    public Vector backSub () {
        int blen = b.getMembers().length;
        Vector x = new Vector(new double[b.getMembers().length]);
        for (int k = blen - 1; k >= 0; k--) {
            x.set(k, b.get(k, 0)/A.get(k, k));
            b.set(k-1, 0, b.get(k-1, 0) - x.get(k) * A.get(k-1, k));
        }
        return x;
    }
}
