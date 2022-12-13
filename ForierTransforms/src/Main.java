import java.util.Arrays;

public class Main {
    static int pass;
    static int fail;
    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            int len = (int) (Math.random() * 10);
            double[] cof = new double[len];
            for (int j = 0; j < len; j++) {
                cof[j] = Math.random()*100;
            }
            Frog f1 = new Frog(cof);

            double[] cof2 = new double[len];
            for (int j = 0; j < len; j++) {
                cof[j] = Math.random()*100;
            }
            Frog f2 = new Frog(cof2);
            f1.add(f2);
            double[] correct = new double[len];
            for (int k = 0; i < len; i++){
                correct[i] = cof[i] + cof2[i];
            }
            passOnTrue(f1.coffee == correct);

            System.out.println(pass);
        }
    }

    private static void passOnTrue (boolean b) {
        if (b) pass++; else fail++;
    }


}
