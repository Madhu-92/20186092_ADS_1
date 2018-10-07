import java.util.Scanner;
class Merge {
    private final int cutOff = 7;
    Merge() {
        
    }
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, low, high);
    }
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int low, final int high) {
        if (high <= low + cutOff) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So,"
                + " skipped the call to merge...");
            return;
        }
        merge(array, aux, low, mid, high);
    }
    public void sort(final Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length - 1);
        assert isSorted(array);
    }

    public void insertionSort(final Comparable[] array,
                              final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(
                        array[i], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
    public void exch(final Comparable[] array,
                     final int i, final int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    public boolean less(final Comparable array, final Comparable b) {
        return array.compareTo(b) < 0;
    }
    public boolean isSorted(final Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    public boolean isSorted(final Comparable[] array,
                            final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {

            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    
    public String show(final Comparable[] array) {
        String str = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[i] + "]";
        return str;
    }
}

public final class Solution {
    private Solution() {
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge mergeObj = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            mergeObj.sort(tokens);
            System.out.println(mergeObj.show(tokens));
            System.out.println();
        }
    }
}