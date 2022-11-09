public class Polynomial {
    private final Complex[] coeffs;

    public Polynomial (Complex[] _coeffs) {
        coeffs = _coeffs.clone();
    }

    public Complex evaluate(Complex x) {
        Complex out = new Complex(0, 0);
        for (int k = 0; k < coeffs.length; k++) {
            out = out.add(coeffs[k].multiply(x.toThe(k)));
        }
        return out;
    }

    public Complex[] evaluateAll (Complex[] x) {
        Complex[] out = new Complex[x.length];
        for (int k = 0; k < x.length; k++) {
            out[k] = evaluate(x[k]);
        }
        return out;
    }

    public Complex[] fourierTransform (Complex[] x) {
        return evaluateAll(Complex.rootsOfUnity(coeffs.length));
    }

    

}
