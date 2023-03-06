import java.util.Arrays;

public class Vector {
    public double[] members;
    public Vector (double[] _members) {
        members = _members;
    }

    public Vector () {
        members = new double[0];
    }

    public Vector product (Vector other) {
        if (getMembers().length != other.getMembers().length) {
            throw new IllegalArgumentException("Vectors must have the same size to be dot producted.");
        }
        double[] outMembers = new double[members.length];
        for (int i = 0; i < getMembers().length; i++) {
            outMembers[i] = other.getMembers()[i] * getMembers()[i];
        }
        return new Vector(outMembers);
    }

    public void add (Vector other) {
        for (int i = 0; i < members.length; i++) {
            members[i] += other.getMembers()[i];
        }
    }

    public void times (double x) {
        for (int i = 0; i < members.length; i++) {
            members[i] *= x;
        }
    }

    public double[] getMembers() {
        return members;
    }

    public boolean equals (Vector other) {
        return equals(this, other);
    }

    public static boolean equals (Vector v0, Vector v1) {
        for (int i = 0; i < v0.getMembers().length; i++) {
            if (Math.abs(v0.getMembers()[i] - v1.getMembers()[i]) > 0.000001) {
                return false;
            }
        }
        return true;
    }

    public double get (int i) {return members[i];}

    public void set (int i, double v) {members[i] = v;}

}
