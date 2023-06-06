import java.util.ArrayList;

public class Permuter {
    public static ArrayList<ArrayList<Integer>> permute (ArrayList<Integer> x) {
        ArrayList<ArrayList<Integer>> out = new ArrayList<>();
        if (x.size() == 1) out.add(x);
        else {
            for (int i = 0; i < x.size(); i++) {
                Integer val = x.remove(i);
                for (ArrayList<Integer> perm : permute(x)) {
                    perm.add(0, val);
                    out.add(perm);
                }
            }
        }
        return out;
    }
}