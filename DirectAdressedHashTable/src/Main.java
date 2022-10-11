import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
    public static int pass, fail = 0;
    public static void main(String[] args) {
        passOnTrue(testDefaultConstructorDAHT());
        passOnTrue(testConstructorDAHT());
        passOnTrue(testDefaultConstructorDatum());
        passOnTrue(testConstructorDatum());
        passOnTrue(testInsertDAHT());
        passOnTrue(testDeleteDAHT());
        passOnTrue(testIdentityLinearProbingHash());
        passOnTrue(testHashedInsert());
        passOnTrue(testHashSearch());


        System.out.println("pass " + pass + " fail " + fail);
    }

    /**
     * Used to increment the appropriate variable on the execution of a testing method.
     * @param b the output of the method tested.
     */
    public static void passOnTrue (boolean b) {
        if (b) pass++;
        else fail++;
    }

    /**
     * Tests the default constructor for the datum class, assumes the getters of the Datum class work as specified.
     * @return true if the test passed, false if it failed.
     */
    public static boolean testDefaultConstructorDatum () {
        // case 1
        return new Datum().getKey() == 0 && new Datum().getValue() == 0;
    }

    /**
     * Tests a constructor of the Datum class for multiple inputs, both valid and invalid, assumes the getters of the
     * Datum class work as specified.
     * @return true if the test passed, false if it failed.
     */
    public static boolean testConstructorDatum () {
        // case 1
        Datum fd = new Datum(2, 4);
        if (fd.getKey() != 2 || fd.getValue() != 4) return false;
        // case 2
        Datum sd = new Datum(3, 6);
        if (sd.getKey() != 3 || sd.getValue() != 6) return false;
        // case 3
        try {
            Datum td = new Datum(-1, 1);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("key field of a Datum object cannot be negative, was -1")) return false;
        }
        return true;
    }

    /**
     * Tests the default constructor for the DAHT class, assumes that the getVals method of the DAHT class works as
     * specified.
     * @return true if the test passed, false if it failed.
     */
    public static boolean testDefaultConstructorDAHT () {
        // case 1
        // the default constructor should initialize the vals field to a lengthless int array.
        return Arrays.equals(new DAHT().getVals(), new Datum[0]);
    }

    /**
     * Tests a constructor of the DAHT class.
     * @return true if the test passed, false if it failed.
     */
     public static boolean testConstructorDAHT () {
        // cases 1 and 2
        // this constructor should initialize the vals field to the input
        return Arrays.equals(new DAHT(5).getVals(), new Datum[5])
                && Arrays.equals(new DAHT(6).getVals(), new Datum[6]);
     }

    /**
     * Tests the insert method of the DAHT class, assumes that the search method of the DAHT class works as specified.
     * @return true if the test passed, false if it failed.
     */
     public static boolean testInsertDAHT () {
         // case 1
         DAHT fD = new DAHT();
         try {
             fD.insert(new Datum());
         } catch (IndexOutOfBoundsException e) {
             if (!e.getMessage().equals("Cannot insert a datum into a table of length shorter than its key" +
                     " (because my hash function is actual garbage).")) return false;
         }
         // case 2
         DAHT sD = new DAHT(5);
         sD.insert(new Datum());
         sD.insert(new Datum(1, 1));
         sD.insert(new Datum(2, 1));
         Datum d = new Datum(3, 15);
         sD.insert(d);
         if (sD.search(3) != d) return false;

         // case 3
         try {
             sD.insert(new Datum(2, 0));
         } catch (RuntimeException e) {
             if (!e.getMessage().equals("Keys must be unique.")) return false;
         }

         return true;
     }

    /**
     * Tests the delete method of the DAHT class.
     * @return true if the test passes, false if it fails.
     */
     public static boolean testDeleteDAHT () {
         // case 1
         DAHT fD = new DAHT(5);
         Datum d = new Datum(0, 0);
         fD.insert(d);
         fD.insert(new Datum(1, 1));
         try {
             fD.delete(new Datum(0, 0));
         } catch (NoSuchElementException e) {
             if (!e.getMessage().equals("Cannot delete a Datum not in the table.")) return false;
         }
        // case 2
         try {
             fD.delete(new Datum(10, 0));
         } catch (NoSuchElementException e) {
             if (!e.getMessage().equals("Cannot delete a Datum not in the table (its key is too big).")) return false;
         }
         // case 3
         fD.delete(d);
         if (fD.search(0) != null) return false;
         // case 4
         fD.delete(fD.search(1));
         if (fD.search(1) != null) return false;

         return true;
     }

    /**
     * Tests the identityLinearProbingHash method of the DAHT class.
     * @return true if the test passes, false if it fails.
     */
     public static boolean testIdentityLinearProbingHash () {
         DAHT fD = new DAHT(5);
         if (fD.identityLinearProbingHash(1, 2) != 3) return false;
         if (fD.identityLinearProbingHash(-4, 2) != -2) return false;

         return true;
     }

    /**
     * tests the hashedInsert method of the DAHT class
     * @return true if the test passes, false if it fails.
     */
     public static boolean testHashedInsert () {
         DAHT fD = new DAHT(5);
         fD.hashedInsert(0);
         fD.hashedInsert(1);
         fD.hashedInsert(2);
         if (fD.hashedInsert(1) != 3) return false;
         if (fD.hashedInsert(4) != 4) return false;
         try {
             fD.hashedInsert(1);
         } catch (RuntimeException e) {
             if (!e.getMessage().equals("Hashtable overflow")) return false;
         }

         return true;
     }

    /**
     * Tests the method hashSearch of the DAHT class
     * @return true if the test passed, false if it failed.
     */
    public static boolean testHashSearch () {
         DAHT fD = new DAHT(5);
         if (fD.hashSearch(2) != -1) return false;
//        System.out.println(fD.hashedInsert(3));
//         fD.hashedInsert(3);
//         if (fD.hashSearch(3) != 3) return false;
//         fD.hashedInsert(8);
//         if (fD.hashSearch(8) != 4) return false;
         return true;
     }
}
