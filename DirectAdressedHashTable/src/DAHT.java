import java.util.NoSuchElementException;

public class DAHT {
    private Datum[] vals;

    /**
     * Default constructor.
     */
    public DAHT () {
        vals = new Datum[0];
    }

    /**
     * A constructor
     * @param size the maximum size of the hash table
     */
    public DAHT (int size) {
        vals = new Datum[size];
    }

    /**
     * Getter for the vals field
     * @return the field vals
     */
    public Datum[] getVals () {
        return vals;
    }

    /**
     * Inserts a Datum object into the table.
     * @param d the Datum object ot be inserted.
     */
    public void insert (Datum d) {
        try {
            if (vals[d.getKey()] != null) throw new RuntimeException("Keys must be unique.");
            vals[d.getKey()] = d;
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Cannot insert a datum into a table of length shorter than its key" +
                    " (because my hash function is actual garbage).");
        }
    }

    /**
     * Inserts a Datum with key equal to its value into the table using hashing.
     * @param key the key of the Datum to be inserted
     * @return the index the Datum was inserted into
     */
    public int hashedInsert (int key) {
        for (int i = 0; i < vals.length-1; i++) {
            int j = identityLinearProbingHash(key, i);
            if (vals[j] == null) {
                vals[j] = new Datum(key, key);
                return j;
            }
        }
        throw new RuntimeException("Hashtable overflow");
    }

    /**
     * Finds the Datum in the table with the given key.
     * @param k the key of the Datum to be found.
     * @return the Datum, or null if it does not exist.
     */
    public Datum search (int k) {
        if (k > 0 && k < vals.length) {
            return vals[k];
        }
        return null;
    }

    /**
     * Finds the position in the table of the Datum with key k, compatible with hashInsert.
     * @param k the key of the Datum to find.
     * @return the position of the Datum, or -1 if it isn't in the table.
     */
    public Integer hashSearch (int k) {
        for (int i = 0; i == vals.length-1 || vals[i] == null; ++i) {
            if (vals[i] == null) return -1;
            int j = identityLinearProbingHash(k, i);
            if (vals[j].getKey() == k) return j;
        }
        return -1;
    }

    /**
     * Deletes a Datum from the table.
     * @param d the Datum to be deleted.
     */
    public void delete (Datum d) {
        try {
            if (vals[d.getKey()] != d) {
                throw new NoSuchElementException("Cannot delete a Datum not in the table.");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException("Cannot delete a Datum not in the table (its key is too big).");
        }
        vals[d.getKey()] = null;
    }

    /**
     * Hashes the inputted using the identity function mod the table length, used for linear probing
     * @param key the key to be hashed
     * @param modifier the number of slots already tried
     * @return the hashed key
     */
    public int identityLinearProbingHash (int key, int modifier) {
        return (key % (vals.length-1)) + modifier;
    }
}
