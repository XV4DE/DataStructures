public class Complex {
    public double real, imaginary;

    public Complex (double _real, double _imaginary) {
        real = _real;
        imaginary = _imaginary;
    }

    public Complex multiply (Complex other) {
        return new Complex(real * other.getReal() - imaginary * other.getImaginary(), real * other.getImaginary() + other.getReal() * imaginary);
    }

    public Complex add (Complex other) {
        return new Complex(real + other.getReal(), imaginary + other.getImaginary());
    }

    public Complex toThe (int k) {
        double arg = Math.atan(imaginary/real);
        return new Complex(Math.pow(arg, k), k * arg);
    }

    public Complex exp () {
        double expReal = Math.exp(real);
        return new Complex(expReal *  Math.cos(imaginary),
                expReal * Math.sin(imaginary));
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public static Complex rootOfUnity(int a, int b) {
        return new Complex(0, 2 * Math.PI * a / b).exp();
    }

    public static Complex[] rootsOfUnity (int n) {
        Complex[] out = new Complex[n];
        for (int k = 0; k < n; k++) {
            out[k] = rootOfUnity(n, k);
        }
        return out;
    }

}
