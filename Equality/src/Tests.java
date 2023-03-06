public class Tests {
    public static boolean testEqualsSame () {
        int i = 0;
        if (!Equality.equals(i, i)) return false;
        String s = "";
        if (!Equality.equals(s, s)) return false;
        int[] a = new int[0];
        if (!Equality.equals(a, a)) return false;
        return true;
    }
}
