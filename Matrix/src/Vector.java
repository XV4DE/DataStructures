public class Vector {
    public int[] members;
    public Vector (int[] _members) {
        members = _members;
    }

    public Vector () {
        members = new int[0];
    }

    public Vector product (Vector other) {
        if (getMembers().length != other.getMembers().length) {
            throw new IllegalArgumentException("Vectors must have the same size to be dot producted.");
        }
        assert ();
        int[] outMembers = new int[members.length];
        for (int i = 0; i < getMembers().length; i++) {
            outMembers[i] = other.getMembers()[i] * getMembers()[i];
        }
        return new Vector(outMembers);
    }

    public int[] getMembers() {
        return members;
    }
}
