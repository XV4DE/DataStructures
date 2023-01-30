import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static int pass = 0;
    public static int tried = 0;
    public static void main(String[] args) {
        passOnTrue(testPartition());
        passOnTrue(testSort(Main::quickSort));
        passOnTrue(testSort(Main::heapSort));
        System.out.print(pass + "/" + tried + " tests passed");
        if (pass == tried) System.out.println("!");
        else System.out.println(" :(");
    }

    public static void passOnTrue(boolean b) {
        tried++;
        if (b) pass++;
    }

    public static boolean testPartition() {
        int pivot = (int) (Math.random() * 100);
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();

        ArrayList<Integer> together = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random()*100);
            if (n < pivot) small.add(n);
            else large.add(n);
        }

        together.addAll(small);
        together.addAll(large);

        ArrayList<Integer> toSolve = new ArrayList<>();
        toSolve.add(pivot);
        while (together.size() > 0) {
            toSolve.add(together.remove((int)(Math.random() * together.size())));
        }
        if (!sameMembers(partition(toSolve, 0).get(0),small)) return false;
        if (!sameMembers(partition(toSolve, 0).get(1),large)) return false;
        return true;
    }


    public static boolean testSort(Function<ArrayList<Integer>, ArrayList<Integer>> sort) {
        for (int r = 1; r < 100; r++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                a.add(i);
            }
            ArrayList<Integer> aClone = new ArrayList<>(a);
            ArrayList<Integer> b = new ArrayList<>();

            while (aClone.size() > 0) {
                b.add(aClone.remove((int) (Math.random() * aClone.size())));
            }
            b = sort.apply(b);
            if (!sameMembers(a, b)) return false;
        }
        return true;
    }

    public static ArrayList<Integer> quickSort (ArrayList<Integer> a) {
        if (a.size() <= 1) return a;

        int pivotPoint = 0;
        ArrayList<ArrayList<Integer>> b = partition(a, pivotPoint);
        ArrayList<Integer> c = new ArrayList<>();
        c.addAll(quickSort(b.get(0)));
        c.add(a.get(pivotPoint));
        c.addAll(quickSort(b.get(1)));

        return c;
    }

    public static ArrayList<ArrayList<Integer>> partition (ArrayList<Integer> a, int pivotPoint) {
        if (a.size() == 0) return new ArrayList<>() {
            {
                add(new ArrayList<>());
                add(new ArrayList<>());
            }
        };
        int p = a.get(pivotPoint);
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        for (Integer i : a) {
            if (i < p) small.add(i);
            else large.add(i);
        }
        // don't include the pivot
        large.remove(0);
        return new ArrayList<>() {{add(small); add(large);}};

    }


    public static ArrayList<Integer> heapSort(ArrayList<Integer> a) {
        ArrayList<Integer> out = new ArrayList<>();
        while (a.size() > 0) {
            a = heapify(a);
            out.add(a.get(0));
            a.set(0, a.get(a.size()-1));
            a.remove(a.size()-1);
        }
        return out;
    }

    public static ArrayList<Integer> heapify(ArrayList<Integer> a) {
        if (a.size() <= 1) return a;

        ArrayList<Integer> out = new ArrayList<>();

        for (int i: a) {
            out.add(i);
            int idx = out.size()-1;

            while (idx > 0 && i > a.get((idx-1)/2)) {
                int swap = a.get((idx-1)/2);
                a.set((idx-1)/2, i);
                a.set(idx, swap);
                idx = (idx-1)/2;
            }
        }
        return out;
    }

    // Ripped straight from geeksforgeeks.org/radixsort
    //======================================================================
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    //======================================================================

    public static boolean sameMembers (ArrayList<Integer> a, ArrayList<Integer> b) {
        assert a.size() == b.size();
        for (Integer i: a) {
            if (!b.contains(i)) return false;
            b.remove(i);
        }
        return true;
    }
}
