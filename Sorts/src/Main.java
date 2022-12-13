import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public int[] quickSort (int[] arr) {
        if (isSorted(arr)) {
            return arr.clone();
        }
        int pivot = arr[0];
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (i <= pivot) a1.add(i);
            else a2.add(i);
        }
        a1.add(pivot);
        quickSort(a1.toArray(new Integer[0]))


    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] < arr[i]) return false;
        }
        return true;
    }
}
