public class Main {
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args) {
        if (testConstructor()) pass++;
        else fail++;

        if (testSetter()) pass++;
        else fail++;

        if (testSearch()) pass++;
        else fail++;

        if (testSearchne()) pass++;
        else fail++;

        if (testSearchte()) pass++;
        else fail++;

        if (testDelete1()) pass++;
        else fail++;

        if (testDelete2()) pass++;
        else fail++;

        System.out.println("passed " + pass + ", failed " + fail);
    }

    public static boolean testConstructor() {
        Element fe = new Element(3);
        return fe.getKey() == 3;
    }

    public static boolean testSetter() {
        Element fe = new Element(3);
        Element se = new Element(4);
        fe.setNext(se);
        return fe.getNext().getKey() == 4;
    }

    public static boolean testSearch() {
        LinkedList fl = new LinkedList();
        return fl.search(3) == null;
    }

    public static boolean testSearchne() {
        Element fe = new Element(3);
        LinkedList fl = new LinkedList();
        fl.insert(fe);
        return fl.search(3) == fe;
    }

    public static boolean testSearchte() {
        Element fe = new Element(3);
        Element se = new Element(4);
        LinkedList fl = new LinkedList();
        fl.insert(fe);
        fl.insert(se);
        return fl.search(3) == fe;
    }

    private static boolean testDelete1() {
        LinkedList fl = new LinkedList();
        Element fe = new Element(3);
        Element se = new Element(4);
        fl.insert(fe);
        fl.insert(se);
        fl.delete(fe);
        return fl.search(3) == null;
    }

    private static boolean testDelete2() {
        LinkedList fl = new LinkedList();
        Element fe = new Element(3);
        Element se = new Element(4);
        fl.insert(fe);
        fl.insert(se);
        fl.delete(se);
        return fl.search(3) == fe;
    }

}
