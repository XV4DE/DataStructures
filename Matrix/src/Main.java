import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Main {
    static int tries = 0;
    static int passes = 0;

    public static void main(String[] args) {
        passOnTrue(testVectorDefaultConstructor());
        passOnTrue(testVectorConstructorEmpty());
        passOnTrue(testVectorConstructor());
        passOnTrue(testMatrixConstructorEmpty());
        passOnTrue(testMatrixConstructor());
        passOnTrue(testVectorEquals());
        passOnTrue(testDotProduct());
        passOnTrue(testVectorAdd());
        System.out.println("Passed " + passes + "/" + tries + " tests.");
    }

    public static boolean testVectorDefaultConstructor () {
        Vector v = new Vector();
        return Arrays.equals(v.getMembers(), new double[0]);
    }

    public static boolean testVectorConstructorEmpty () {
        for (int i = 0; i < 100; i++) {
            Vector v = emptyVector(i);
            if (!Arrays.equals(v.getMembers(), new double[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean testVectorConstructor () {
        for (int i = 0; i < 100; i++) {
            double[] a = new double[i];
            for (int j = 0; j < i; j++) {
                a[j] = (int) (Math.random() * 100);
            }
            Vector v = new Vector(a);
            if (!Arrays.equals(v.getMembers(), a)) {
                return false;
            }
        }
        return true;
    }

    public static boolean testMatrixConstructorEmpty () {
        for (int i = 0; i < 100; i++) {
            Vector[] v = new Vector[i];
            for (int j = 0; j < i; j++) {
                v = emptyVectorArray(j, i);
            }
            Matrix m = new Matrix(v);
            for (Vector tv:m.getMembers()) {
                if (!Arrays.equals(tv.getMembers(), new double[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean testMatrixConstructor () {
        for (int i = 0; i < 100; i++) {
            Vector[] va = new Vector[i];
            for (int j = 0; j < i; j++) {
                va[j] = randomVector(i, 100);
            }
            if (!Arrays.equals(va, new Matrix(va).getMembers())) {
                return false;
            }
        }
        return true;
    }

    public static boolean testVectorEquals () {
        for (int i = 0; i < 100; i++) {
            double[] l0 = new double[i];
            double[] l1 = new double[i];
            for (int j = 0; j < i; j++) {
                int n = (int) (Math.random() * 100);
                l0[j] = n;
                l1[j] = n;
            }
            if ((!new Vector(l0).equals(new Vector(l1))) || (!Vector.equals(new Vector(l0), new Vector(l1)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean testDotProduct () {
        for (int i = 0; i < 100; i++) {
            Vector test = randomVector(i, 100).product(emptyVector(i));
            System.out.println(Arrays.toString(test.getMembers()));
            if (!test.equals(emptyVector(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean testVectorAdd () {
        for (int i = 0; i < 100; i++) {
            Vector a = randomVector(i, 100);
            Vector b = emptyVector(i);
            Vector c = new Vector(a.getMembers().clone());
            a.add(b);
            if (!a.equals(c)) return false;
        }
        for (int i = 0; i < 100; i++) {
            Vector a = randomVector(i, 100);
            Vector b = randomVector(i, 100);
            double[] cA = new double[a.getMembers().length];
            for (int j = 0; j < cA.length; j++) {
                cA[j] = a.getMembers()[j] - b.getMembers()[j];
            }
            Vector c = new Vector(cA);
            c.add(b);

            if (!c.equals(a)) return false;
        }
        return true;
    }



    private static Vector emptyVector (int size) {
        return new Vector(new double[size]);
    }

    private static Vector randomVector (int size, int range) {
        double[] a = new double[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * range) - range/2;
        }
        return new Vector(a);
    }

    private static Vector[] emptyVectorArray (int sizeA, int sizeV) {
        Vector[] v = new Vector[sizeA];
        for (int i = 0; i < sizeA; i++) {
            v[i] = emptyVector(sizeV);
        }
        return v;
    }

    public static void passOnTrue (boolean b){
        tries++;
        if (b) passes++;
    }
}
