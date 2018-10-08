import java.util.Scanner;
import java.util.Arrays;

class InsertionSort {
    InsertionSort() {

    }
    public Comparable[] insertionSort(final Comparable[] array,
                                      final int low, final int high) {
        return sort(array, low, high);
    }

    private Comparable[] sort(final Comparable[] array,
                              final  int low, final int high) {
        int j = 0;
        for (int i = low + 1; i <= high; i++) {
            j = i - 1;
            Comparable temp = array[i];
            while (j >= 0 && temp.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}

class QuickSort {
    private int cutoff;
    private InsertionSort insertion;
    QuickSort(final int cut) {
        cutoff = cut;
        insertion = new InsertionSort();
    }

    public void quickSort(final Comparable[] array) {
        int low = 0;
        int high = array.length - 1;
        quickSort(array, low, high);
    }

    private void quickSort(final Comparable[] array,
                           final int low, final int high) {
        if (high - low + 1 <= cutoff) {
            insertion.insertionSort(array, low, high);
            System.out.println("insertionSort called");
            return;
        }
        int j = partition(array, low, high);
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, high);
    }

    private int partition(final Comparable[] array,
                          final int low, final int high) {
        int i = low + 1;
        int k = low;
        int j = high;
        while (true) {
            while (less(array[i], array[k])) {
                i++;
                if (i == high) {
                    break;
                }
            }
            while (less(array[k], array[j])) {
                j--;
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(array, i, j);
            i++;
        }
        exchange(array, j, k);
        System.out.println(Arrays.toString(array));
        return j;
    }

    private boolean less(final Comparable objOne, final Comparable objTwo) {
        return objOne.compareTo(objTwo) < 0;
    }

    private void exchange(final Comparable[] array, final int i, final int k) {
        Comparable temp = array[k];
        array[k] = array[i];
        array[i] = temp;
    }
}

public final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number > 0) {
            int cutoff = sc.nextInt();
            sc.nextLine();
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].length() == 0) {
                System.out.println("[]");
            } else {
                QuickSort quick = new QuickSort(cutoff);
                quick.quickSort(tokens);
                System.out.println(Arrays.toString(tokens));
            }
            number--;
        }
    }
}