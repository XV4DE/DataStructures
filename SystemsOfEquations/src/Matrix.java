import java.util.Arrays;

public class Matrix {
    double[][] members;
    public final int width, height;

    public Matrix (double[][] _members) {
        members = _members.clone();
        height = _members.length;
        width = _members[0].length;
    }

    public double get(int r, int c) {
        return members[r][c];
    }

    public int size () {
        if (width == height) return width;
        else return -1;
    }

    public void set(int r, int c, double i) {
        members[r][c] = i;
    }

    public void addRow (int r0, int r1) {
        for (int i = 0; i < width; i++) {
            members[r0][i] += members[r1][i];
        }
    }

    public void multRow (int r, double x) {
        for (int i = 0; i < width; i++) {
            members[r][i] *= x;
        }
    }

    public void rowMult (int r, int i) {
        for (int a = 0; a < members[r].length; a++) {
            members[r][a] *= i;
        }
    }

    public void rowAdd (int r0, int r1) {
        for (int a = 0; a < members[r0].length; a++) {
            members[r0][a] += members[r1][a];
        }
    }

    public String toString() {
        String out = "";
        for (int r = 0; r < height; r++) {
            out += "[";
            for (int c = 0; c < width; c++) {
                out += get(r, c);
                if (c != width -1) {
                    out += ", ";
                }
            }
            out += "]";
            if (r != height-1) out += "\n";
        }
        return out;
    }

    public double[][] getMembers() {
        return members;
    }

    public boolean equals (Matrix other, double tolerance) {
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (Math.abs(other.get(r, c) - get(r, c)) > tolerance) return false;
            }
        }
        return true;
    }

    public boolean equals (Matrix other) {
        return equals(other, 0.01);
    }
}
