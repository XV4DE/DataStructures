import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] function = {2, 3, 2, 2, 2, 2};
        int[] kernel = {1, 1};

        int[] result = new int[function.length];

        for (int offset = 0; offset< function.length; offset++) {

            for (int i = 0; i < kernel.length; i++) {
                if (i+offset > function.length-1) {
                    // edge behavior
                    // a more complete version might include the following line:
                    // result[offset] += 0 * kernel[i];
                } else {
                    result[offset] += function[i + offset] * kernel[i];
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
