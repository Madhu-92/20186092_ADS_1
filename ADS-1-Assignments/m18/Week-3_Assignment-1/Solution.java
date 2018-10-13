import java.util.Scanner;
class Stock implements Comparable<Stock> {
	private String stockName;
	private float change;

	Stock(String name, float change) {
		this.stockName = name;
		this.change = change;
	}

	public String getStockName() {
		return stockName;
	}
	public float getChange() {
		return change;
	}
	public int compareTo(Stock x) {
		return getStockName().compareTo(x.getStockName());
	}
	public String toString() {
		return getStockName()+""+getChange();
	}
}

class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int iterate = 6 * n;
		int hours = 1;
		while (hours < 7) {
				MinPQ<String, Float> minpq = new MinPQ<Stock>(n);
				MaxPQ<String, Float> maxpq = new MaxPQ<Stock>(n);
				Stock[] shares = new Stock[n];
				for (int i = 1; i < n; i++) {
					String tokens = sc.nextLine().split(",");
					shares[i] = new Stock(tokens[0], Float.parseInt(tokens[1]));
					System.out.println(shares[i]);
			}
			Float median = shares.getChange();
		}
	}
}