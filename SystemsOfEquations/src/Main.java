public class Main {
    static int tests = 0;
    static int passes = 0;
    static char[] varNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'};
    public static void main(String[] args) {
        passOnTrue(testBackSub());
        passOnTrue(testMakeZero());
        passOnTrue(testSolve());
        passOnTrue(testSolveRandom());
        System.out.println("Passed " + passes + "/" + tests);


    }

    public static boolean testBackSub () {
        double[][] _A = {
                {3, 1, 4},
                {0, 1, 5},
                {0, 0, 9}
        };
        Matrix A = new Matrix(_A);

        double[][] _b = {
                {17},
                {17},
                {27}
        };
        Matrix b = new Matrix(_b);

        double[][] _correctA = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        Matrix correctA = new Matrix(_correctA);

        double[][] _correctb = {
                {1},
                {2},
                {3}
        };
        Matrix correctb = new Matrix(_correctb);

        SystemOfEquations correct = new SystemOfEquations(correctA, correctb);
        SystemOfEquations attempt = new SystemOfEquations(A, b);
        attempt.backSub();

//        System.out.println(attempt);
        return attempt.equals(correct);
    }

    public static boolean testMakeZero () {
        double[][] _A = {
                {1, 2},
                {0, 1}
        };
        Matrix A = new Matrix(_A);

        double[][] _b = {
                {1},
                {2}
        };
        Matrix b = new Matrix(_b);

        double[][] _correctA = {
                {0.5, 0},
                {0, 1}
        };
        Matrix correctA = new Matrix(_correctA);

        double[][] _correctb = {
                {-1.5},
                {2}
        };
        Matrix correctb = new Matrix(_correctb);

        SystemOfEquations correct = new SystemOfEquations(correctA, correctb);
        SystemOfEquations attempt = new SystemOfEquations(A, b);
        attempt.makeZero(0, 1);

//        System.out.println(attempt);

        return attempt.equals(correct);
    }

    public static boolean testSolve () {
        double[][] _A = {
                {3, -1, 4, 0},
                {-1, 0, 9, 5},
                {2, 6, 0, -7},
                {0, 1, 9, 6}
        };
        Matrix A = new Matrix(_A);

        double[][] _b = {
                {1},
                {2},
                {9},
                {5}
        };
        Matrix b = new Matrix(_b);

        double[][] _correctA = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        Matrix correctA = new Matrix(_correctA);

        double[][] _correctb = {
                {0.8209219858156042},
                {1.7393617021276593},
                {0.06914893617021267},
                {0.4397163120567378}
        };
        Matrix correctb = new Matrix(_correctb);

        SystemOfEquations correct = new SystemOfEquations(correctA, correctb);
        SystemOfEquations attempt = new SystemOfEquations(A, b);
        attempt.solve();

        System.out.println(attempt);

        return attempt.equals(correct);
    }

    public static boolean testSolveRandom () {
        for (int i = 0; i < 100; i++) {
            int size = (int) (Math.random() * 20) + 2;
            double[][] _A = new double[size][size];
            double[][] _b = new double[size][1];
            double[][] _answers = new double[size][1];
            for (int a = 0; a < size; a++) {
                _answers[a][0] = Math.random() * 2000 - 1000;
            }
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    _A[r][c] = Math.random() * 2000 - 1000;
                    if (Math.random() > 0.9) _A[r][c] = 0;
                    _b[r][0] += _A[r][c] * _answers[c][0];
                }
            }
            Matrix A = new Matrix(_A);
            Matrix b = new Matrix(_b);
            Matrix answers = new Matrix(_answers);
            SystemOfEquations sys = new SystemOfEquations(A, b);
            System.out.println("Starting:");
            System.out.println(sys);
            System.out.println("");
            sys.solve();
            System.out.println("Solution:");
            System.out.println(sys);
            System.out.println("");
            System.out.println("Correct:");
            System.out.println(answers);
            System.out.println("");
            System.out.println("");
            if (!sys.getb().equals(answers)) return false;
        }
        return true;
    }

    public static void passOnTrue (boolean b) {
        tests++;
        if (b) passes++;
    }
}
