import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  public static int[] intArray(final String s) {
    String[] tokens = s.split(" ");
    int[] array = new int[tokens.length];
    for (int i=0; i < array.length; i++) {
      array[i] = Integer.parseInt(tokens[i]);
    }
    return array;
  }
public static void main(final String[] args) {
    Scanner sc = new Scanner(System.in);
    int[]a1 = new int[sc.nextInt()];
    int[]a2 = new int[sc.nextInt()];
    if (a1.length != 0) {
      a1 = intArray(sc.next());
    }
    if (a2.length != 0) {
      a2 = intArray(sc.next());
    }
    int[] resultArray = new int[a1.length + a2.length];
    int i = 0, j = 0, k = 0;
    while (i < a1.length && j < a2.length) {
      if (a1[i] < a2[j]) {
        resultArray[k++] = a1[i];
        i = i + 1;
      } else if (a1[i] > a2[j]) {
        resultArray[k++] = a2[j];
        j = j + 1;
      }
    }
    if (a1.length > a2.length) {
      while (k < a1.length + a2.length) {
        resultArray[k++] = a1[i++];
      }

    }
    if (a2.length > a1.length) {
      while (k < a1.length + a2.length) {
        resultArray[k++] = a2[j++];
      }
    }
    System.out.println(Arrays.toString(resultArray).replace("[", "")
                       .replace("]", "").replace(" ", ""));
  }
}