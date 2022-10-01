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
}
