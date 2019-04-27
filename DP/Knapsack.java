public class Knapsack {

	public static void main(String[] args) {
		int[] wt = { 1, 3, 4, 5 };
		int[] price = { 1, 4, 5, 7 };
	//	System.out.println(knapsackTD(wt, price, 0, 7, new int[wt.length][8]));
		System.out.println(knapsackBU(wt, price, 7));
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
		int nr = wt.length + 1;
		int nc = cap + 1;
		int[][] strg = new int[nr][nc];

		for (int row = 1; row < nr; row++) {
			for (int col = 1; col < nc; col++) {
				if (col < wt[row -1]) {
					strg[row][col] = strg[row - 1][col];
				} else {
					int excluded = strg[row - 1][col];
					int included = price[row - 1] + strg[row - 1][col - wt[row - 1]];
					strg[row][col] = Math.max(excluded, included);
				}
			}
		}

		return strg[nr - 1][nc - 1];
	}

}
