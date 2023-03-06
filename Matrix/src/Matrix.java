public class Matrix {
    public Vector[] members;
    public Matrix (Vector[] _members) {
        members = _members;
    }

    public Matrix () {
        members = new Vector[0];
    }

    public Matrix matrixMultiply (Matrix other) {
        if (getMembers().length != other.getMembers().length) {
            throw new IllegalArgumentException("Matrixes must have the same size to be dot producted.");
        }

        Vector[] outMembers = new Vector[members.length];
        for (int i = 0; i < getMembers().length; i++) {
            outMembers[i] = getMembers()[i].product(other.getMembers()[i]);
        }
        return new Matrix(outMembers);
    }

    public Vector[] getMembers() {
        return members;
    }

    public void rowAdd (int r0, int r1) {
        members[r0].add(members[r1]);
    }

    public void rowMult (int r, double x) {members[r].times(x);}

    public double get (int x, int y) {return members[y].get(x);}

    public void set (int x, int y, double value) {members[y].set(x, value);}
}
