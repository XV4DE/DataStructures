import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TruthTable {
    private ArrayList<boolean[]> keys;
    private ArrayList<Boolean> values;

    public TruthTable () {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public TruthTable (ArrayList<boolean[]> _keys, ArrayList<Boolean> _values) {
        keys = _keys;
        values = _values;
    }

    public void put (boolean[] k, Boolean v) {
        keys.add(k);
        values.add(v);
    }

    public Boolean get (boolean[] k) {
        System.out.print("K: ");
        System.out.println(Arrays.toString(k));
        for (int i = 0; i < keys.size(); i++) {
            if (Arrays.equals(keys.get(i), k)){
                return values.get(i);
            }
        }
        return null;
    }

    public boolean equals (TruthTable other) {
        System.out.println("Self");
        System.out.println(this);

        System.out.println("Other");
        System.out.println(other);
        for (boolean[] k : keys) {
            if (!get(k).equals(other.get(k))) return false;
        }
        return true;
    }

    public ArrayList<boolean[]> getKeys () {return keys;}

    public ArrayList<Boolean> getValues () {return values;}

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < keys.size(); i++) {
            out += Arrays.toString(keys.get(i)) + " -> " + values.get(i) + "\n";
        }
        return out;
    }
}
