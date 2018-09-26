import java.util.Scanner;
import java.util.Arrays;
class No_of_pairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int intArray = scan.nextInt();
        int[] a = new int[intArray];
        for (int i = 0; i < a.length; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < intArray-2; i++) {
            int j = i+1;
            int k = intArray;
            while (j < k) {
                if (a[i]+a[j]+a[k]==0) {
                    count++;
                } else if (a[i]+a[j]+a[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
}
}