import java.util.Scanner;
import java.util.Arrays;
class Student {
	String name;
	String date;
	int sub1;
	int sub2;
	int sub3;
	int total;
	String category;

	Student(String name, String date, int sub1, int sub2, int sub3, int total, String category) {
		this.name = name;
		this.date = date;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.total = total;
		this.category = category;
	}

	public String getName() {
		return this.name;
	}
	public int getSub1() {
		return this.sub1;
	}
	public int getSub2() {
		return this.sub2;
	}
	public int getSub3() {
		return this.sub3;
	}
	public int getTotal() {
		return this.total;
	}
	public String getCategory() {
		return this.category;
	}

	public int compareTo(Student that) {
		if (this.total < that.total) {
			return 1;
		}
		if (this.total > that.total) {
			return -1;
		} else {
			if (this.sub3 < that.sub3) {
				return -1;
			}
			if (this.sub3 > that.sub3) {
				return 1;
			} else {
				if (this.sub2 < that.sub2) {
					return 1;
				}
				if (this.sub2 > that.sub2) {
					return -1;
				}
			}
			return 0;
		}

	}
}

	class Insertion {

		public Insertion() {

		}
		public void sort(Student[] a) {
			for (int i = 1; i < a.length; i++) {
				for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
					exchange(a, j, j - 1);
				}
			}
		}
		public boolean less(Student x, Student y) {
			return x.compareTo(y) < 0;

		}
		public void exchange(Student[] a, int i, int j) {
			Student swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}
	}

	class Merit {
		public void add(Student subs) {

		}
	}

	public final class Solution {
		public static void main(final String[] args) {
			Merit obj = new Merit();
			Scanner scan = new Scanner(System.in);
			int n = Integer.parseInt(scan.nextLine());
			int vacancies = Integer.parseInt(scan.nextLine());
			int unreserved = Integer.parseInt(scan.nextLine());
			int bc = Integer.parseInt(scan.nextLine());
			int sc = Integer.parseInt(scan.nextLine());
			int st = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < n; i++) {
				String[] tokens = scan.nextLine().split(",");
				Student stuObj = new Student(tokens[0], tokens[1], Integer.parseInt(tokens[2]),
				                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]),
				                    Integer.parseInt(tokens[5]), tokens[6]);
				obj.add(stuObj);
			}

		}

	}