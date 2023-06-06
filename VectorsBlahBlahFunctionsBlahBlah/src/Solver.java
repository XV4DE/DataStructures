import java.util.function.Function;

public class Solver {
    public static Double[] evaluate (Function<Double[], Double[]> f, int[] position) {
        Double[]doubPos = new Double[2];
        doubPos[0] = (double) position[0];
        doubPos[1] = (double) position[1];
        return f.apply(doubPos);
    }

    public static Double[] xDeriv (Function<Double[], Double[]> f, int[] position) {
        Double[] fAtPos = f.apply(makeDouble(position));
        int[] positionOneMore = position.clone();
        positionOneMore[0] += 1;
        Double[] fAtOneMore = f.apply(makeDouble(positionOneMore));
        return minus(fAtOneMore, fAtPos);
    }

    public static Double[] yDeriv (Function<Double[], Double[]> f, int[] position) {
        Double[] fAtPos = f.apply(makeDouble(position));
        int[] positionOneMore = position.clone();
        positionOneMore[1] += 1;
        Double[] fAtOneMore = f.apply(makeDouble(positionOneMore));
        return minus(fAtOneMore, fAtPos);
    }

    public static Double[][] deriv (Function<Double[], Double[]> f, int[] position) {
        return new Double[][] {xDeriv(f, position), yDeriv(f, position)};
    }

    private static Double[] makeDouble (int[] x) {
        Double[] out = new Double[x.length];
        for (int i = 0; i < x.length; i++) out[i] = (double) x[i];
        return out;
    }

    private static Double[] minus (Double[] a, Double[] b) {
        Double[] aClone = a.clone();
        for (int i = 0; i < a.length; i++) {
            aClone[i] -= b[i];
        }
        return aClone;
    }
}
