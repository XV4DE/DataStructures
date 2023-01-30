public class Main {
    static int attempts = 0;
    static int passes = 0;
    public static void main(String[] args) {
        passOnTrue(testTruthAssignment());

        System.out.println("Passed " + passes + "/" + attempts + " tests.");
    }

    public static boolean testTruthAssignment() {
        return true;
    }



    public static void passOnTrue (boolean b) {
        attempts++;
        if (b) passes++;
    }
}



