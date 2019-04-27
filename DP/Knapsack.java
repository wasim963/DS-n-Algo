public class Knapsack {

	public static void main(String[] args) {
		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
		System.out.println(knapsackTD(wt, price, 0, 7, new int[wt.length][8]));
	}

	public static int knapsackTD(int[] wt, int[] price, int vidx, int cap, int[][] strg) {
		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}
		int include = 0;
		int exclude = 0;

		if (wt[vidx] <= cap)
			include = price[vidx] + knapsackTD(wt, price, vidx + 1, cap - wt[vidx], strg);
		exclude = knapsackTD(wt, price, vidx + 1, cap, strg);
		int max = Math.max(include, exclude);
		strg[vidx][cap] = max;
		return max;
	}

	public static int knapsackBU(int[] wt, int[] price, int cap) {
		int[][] strg = new int[wt.length + 1][cap + 1];
		int nr = wt.length;
		int nc = cap;

		return 0;
	}

}
