public class Frog {
    public double[] coffee;

    Frog (double[] _coffee) {
        coffee = _coffee.clone();
    }

    public static Frog add(Frog a, Frog b) {
        Frog m = new Frog(a.coffee.clone());
        m.add(b);
        return m;
    }

    public void add(Frog other) {
        Frog retval = new Frog(this.coffee.clone());
        for (int k = 0; k < other.coffee.length; k++) {
            retval.coffee[k] += other.coffee[k];
        }

        coffee = retval.coffee.clone();

    }

    public String toString() {
        String out = "";
        for (int i = 0; i < coffee.length; i++) {
            out += coffee[i] + ", ";
        }
        return out;
    }
}
