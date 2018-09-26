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
		// System.out.println(Arrays.toString(a));
		int pair;
		int count = 0;
		int totalcount = 0;
		for (int i = 0; i < a.length - 1; i++) {
			// pair = a[i];
			// for (int j = i + 1; j < a.length; j++) {
			// 	if (pair == a[j]) {
			// 		count++;
			// 	}
			// }
			pair = i + 1;
			if (a[i] == a[pair]) {
				count++;
			} if(i == a.length-2 || a[i] != a[pair]) {
				totalcount += (count+1) * (count)/2;
				count = 0;
			}
		}
		System.out.println(totalcount);
	}
}