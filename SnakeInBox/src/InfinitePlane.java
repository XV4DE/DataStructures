public class InfinitePlane {
    private int[][] members;
    private int origin;
    int size;
    public InfinitePlane () {
        size = 1;
        members = new int[size][size];
        origin = 0;
    }

    public InfinitePlane (int[][] _members) {
        assert (_members.length % 2 == 1);
        members = _members.clone();
        origin = members.length/2;
        size = members.length;
    }

    public void expandPlane() {
        int ogSize = size;
        int ogOrigin = origin;
        size = size * 2 + 1;
        int[][] newMembers = new int[size][size];
        origin = size/2;
        for (int r = 0; r < ogSize; r++) {
            for (int c = 0; c < ogSize; c++) {
                newMembers[r+ogOrigin][c+ogOrigin] = members[r][c];
            }
        }
        members = newMembers;
    }

    public String toString () {
        int[] lengths = new int[size];
        for (int c = 0; c < size; c++) {
            int largest = 0;
            for (int r = 0; r < size; r++) {
                largest = Math.max(largest, (""+members[r][c]).length());
            }
            lengths[c] = largest;
        }

        String out = "";
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                out += members[r][c];
                for (int i = 0; i < lengths[c] - (""+members[r][c]).length(); i++) {
                    out+=" ";
                }
                out += " ";
            }
            out += "\n";
        }

        return out;
    }

    public int getPoint (int x, int y) {
        int rx = origin+x;
        int ry = origin-y;
        return members[ry][rx];
    }

    public void setPoint (int x, int y, int v) {
        int rx = origin+x;
        int ry = origin-y;
        members[ry][rx] = v;

    }
}
