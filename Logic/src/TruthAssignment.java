import java.util.ArrayList;
import java.util.HashMap;

public class TruthAssignment {
    private HashMap<String, Boolean> theRep = new HashMap<>();

    public TruthAssignment(ArrayList<String> s, ArrayList<Boolean> b) {
        assert (s.size() == b.size());
        for (int i = 0; i < s.size(); i++) {
            theRep.put(s.get(i), b.get(i));
        }

    }

    public void put (String p, boolean v) {
        theRep.put(p, v);
    }

    public boolean get(String b) {
        return theRep.get(b);
    }

    public static TruthAssignment[] allTruthAssignments (ArrayList<String> a) {
        TruthAssignment[] out = new TruthAssignment[(int) Math.pow(2, a.size())];

    }
}
