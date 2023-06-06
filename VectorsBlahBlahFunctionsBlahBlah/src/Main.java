import java.util.Arrays;
import java.util.function.Function;

public class Main {
    static int tests;
    static int passes;

    public static void main(String[] args) {
        passOnTrue(testDeriv());
        passOnTrue(testDeriv2());
        passOnTrue(testDeriv3());
        passOnTrue(testDerivRandom());
        System.out.println("Passed " + passes + "/" + tests);
    }

    public static void passOnTrue (boolean test) {
        tests++;
        if (test) passes++;
    }

    public static boolean testDeriv() {
        Function<Double[], Double[]> f = a -> new Double[]{(double)0, (double)0};
        Double[][] correct = {{(double)0, (double)0},{(double)0, (double)0}};
        return Arrays.deepEquals(Solver.deriv(f, new int[]{0, 0}), correct);
    }

    public static boolean testDeriv2() {
        Function<Double[], Double[]> f = a -> a;
        Double[][] correct = {{(double)1, (double)0},{(double)0, (double)1}};
        return Arrays.deepEquals(Solver.deriv(f, new int[]{0, 0}), correct);
    }

    public static boolean testDeriv3() {
        Function<Double[], Double[]> f = a -> new Double[]{Math.ceil((a[0]+a[1])/2), Math.ceil((a[0]+a[1])/2)};
        Double[][] correct = {{(double)1, (double)1},{(double)1, (double)1}};
        return Arrays.deepEquals(Solver.deriv(f, new int[]{0, 0}), correct);
    }

    public static boolean testDerivRandom() {
        for (int i = 0; i < 1000; i++) {
            double deltaX = Math.random() * 1001 - 500;
            double deltaY = Math.random() * 1001 - 500;
            Function<Double[], Double[]> f = a -> new Double[]{a[0] * deltaX, a[1] * deltaY};
            Double[][] correct = {{deltaX, (double) 0}, {(double) 0, deltaY}};
            int[] pos = new int[] {(int) (Math.random() * 1001 - 500), (int) (Math.random() * 1001 - 500)};
            if (!twoDEqualsDelta(Solver.deriv(f, pos), correct)) {
                System.out.println("Pos:");
                System.out.println(Arrays.toString(pos));
                System.out.println("Correct:");
                System.out.println(Arrays.deepToString(correct));
                System.out.println("Gave:");
                System.out.println(Arrays.deepToString(Solver.deriv(f, pos)));
                return false;
            }
        }
        return true;
    }

    private static boolean twoDEqualsDelta (Double[][] a, Double[][] b, double... delta) {
        double d = delta.length > 0 ? delta[0] : 0.000001;
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                if (Math.abs(a[r][c] - b[r][c]) > d) return false;
            }
        }
        return true;
    }
}
