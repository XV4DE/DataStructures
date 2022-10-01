public class Datum {
    private int key, value;

    /**
     * The default constructor, key and value fields will both be 0.
     */
    public Datum () {
        key = 0;
        value = 0;
    }

    /**
     * A constructor, key and value fields will be initialized as specified.
     * @param _key the value that key will assume, must be positive.
     * @param _value the value that value will assume.
     */
    public Datum (int _key, int _value) {
        if (_key < 0) throw new IllegalArgumentException("key field of a Datum object cannot be negative, was " + _key);
        key = _key;
        value = _value;
    }

    /**
     * Getter method for the key field.
     * @return the key field.
     */
    public int getKey () {
        return key;
    }

    /**
     * Getter method for the value field.
     * @return the value field.
     */
    public int getValue () {
        return value;
    }
}
