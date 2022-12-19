import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findField(11)));
    }

    double findC (double a, double b) {
        return Math.sqrt(a*a + b*b);
    }

    static double[][][] findField(int n) {
        int hn = n/2;
        double[][][] out = new double[n][n][2];
        for (double x = 0; x < n; x++) {
            out[(int) x] = ((x-hn))/((x-hn)*(x-hn)*(x-hn));
        }
        return out;
    }
}
