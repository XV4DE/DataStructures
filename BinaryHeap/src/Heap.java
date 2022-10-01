import java.util.NoSuchElementException;

public class Heap {
    int[] contents;
    int count;

    /**
     * The default constructor.
     */
    public Heap () {
        contents = new int[0];
        count = 0;
    }

    /**
     * A constructor that creates a heap of variable size.
     * @param size the maximum number of elements that can be contained in the heap
     */
    public Heap (int size) {
        contents = new int[size];
        count = 0;
    }

    /**
     * Extracts the maximum value in the heap
     * @return the root of the heap
     */
    public int extractMaximum () {
        if (count == 0) throw new NoSuchElementException("Cannot get the maximum of heap with no contents.");
        return contents[0];
    }

    /**
     *
     * @param n the
     */
    public void insert (int n) {
        contents[count] = n;
    }

}
