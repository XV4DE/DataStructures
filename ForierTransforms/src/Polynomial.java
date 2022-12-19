import java.util.ArrayList;
import java.util.Arrays;

public class Polynomial {
    public final Complex[] coeffs;

    /**
     * Constructs a new Polynomial given the coefficients for that polynomial.
     * @param _coeffs the coefficients for the polynomial
     */
    public Polynomial (Complex[] _coeffs) {
        coeffs = _coeffs.clone();
    }

    /**
     * Evaluate the polynomial at a single complex value.
     * @param x the value to evaluate the polynomial at.
     * @return the value of the polynomial at x.
     */
    public Complex evaluate(Complex x) {
        Complex out = new Complex(0, 0);
        for (int k = 0; k < coeffs.length; k++) {
            out = out.add(coeffs[k].multiply(x.toThe(k)));
        }
        return out;
    }

    public Complex evaluateEven(Complex x) {
        Complex[] evCoeffs = new Complex[coeffs.length/2];
        for (int i = 0; i < coeffs.length/2; i++) {
            evCoeffs[i] = coeffs[i*2];
        }
        Polynomial ev = new Polynomial(evCoeffs);
        return ev.evaluate(x);
    }

    public Complex evaluateOdd(Complex x) {
        Complex[] odCoeffs = new Complex[coeffs.length/2];
        for (int i = 0; i < coeffs.length/2 + coeffs.length%2; i++) {
            odCoeffs[i] = coeffs[i*2 + 1];
        }
        Polynomial od = new Polynomial(odCoeffs);
        return od.evaluate(x);
    }

    /**
     * Evaluate the polynomial at a set of complex values.
     * @param x an array containing the values to evaluate the polynomial at.
     * @return an array containing the results of evaluating the polynomial at x's members.
     */
    public Complex[] evaluateAll (Complex[] x) {
        Complex[] out = new Complex[x.length];
        for (int k = 0; k < x.length; k++) {
            out[k] = evaluate(x[k]);
        }
        return out;
    }

    /**
     * Computes the Fourier transform of the polynomial
     * @return the polynomial evaluated at the roots of unity corresponding to the number of terms.
     */
    public Complex[] fourierTransform () {
        return evaluateAll(Complex.rootsOfUnity(coeffs.length));
    }


    public static double[][] synthDiv (double[] num, double[] den) {
        if (Arrays.equals(den, new double[]{0})) {
            throw new IllegalArgumentException("Synthetic division by 0");
        }
        double[] retVal = num.clone();
        double norm = den[0];
        for (int i = 0; i < num.length - den.length + 1; i++) {
            retVal[i] /= norm;
            double c = retVal[i];
            if (c != 0) {
                for (int j = 1; j < den.length; j++) {
                    retVal[i + j] += -den[j]*c;
                }
            }
        }

        // ########################################
        int separator = 1 - den.length;
        double[] p1 = new double[separator-1];
        double[] p2 = new double[retVal.length-separator];
        for (int i = 0; i < separator; i++) {
            p1[i] = retVal[i];
        }

        double[][] a = {p1, p2};
        return a;
    }

    // taken from https://introcs.cs.princeton.edu/java/97data/FFT.java.html
    public static Complex[] fft(Complex[] x) {
        int n = x.length;

        // base case
        if (n == 1) return new Complex[] { x[0] };

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n is not a power of 2");
        }

        // compute FFT of even terms
        Complex[] even = new Complex[n/2];
        for (int k = 0; k < n/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] evenFFT = fft(even);

        // compute FFT of odd terms
        Complex[] odd  = even;  // reuse the array (to avoid n log n space)
        for (int k = 0; k < n/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] oddFFT = fft(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n/2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k]       = evenFFT[k].add (wk.multiply(oddFFT[k]));
            y[k + n/2] = evenFFT[k].add(wk.multiply(oddFFT[k]).negate());
        }
        return y;
    }

    

}
