import java.util.NoSuchElementException;
public class Main {
    static int pass;
    static int fail;
    public static void main(String[] args) {
        pass = 0;
        fail = 0;

        passOnTrue(testDefaultConstructor());
        passOnTrue(testConstructor());
        passOnTrue(testInsert());


        System.out.println("passed " + pass + ", failed " + fail);
    }

    public static void passOnTrue (boolean b) {
        if (b) pass++; else fail++;
    }

    public static boolean testDefaultConstructor () {
        Heap fh = new Heap();
        try {
            fh.extractMaximum();
        } catch (NoSuchElementException e) {
            if (e.getMessage().equals("Cannot get the maximum of heap with no contents.")) return true;
        }
        return false;
    }

    public static boolean testConstructor () {
        Heap fh = new Heap(0);
        try {
            fh.extractMaximum();
        } catch (NoSuchElementException e) {
            if (e.getMessage().equals("Cannot get the maximum of heap with no contents.")) return true;
        }
        return false;
    }

    public static boolean testInsert () {
        Heap fh = new Heap(2);
        fh.insert(5);
        if (fh.extractMaximum() != 5) return false;
        fh.insert(4);
        if (fh.extractMaximum() != 5) return false;
        return true;
    }




}
