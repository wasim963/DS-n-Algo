public class RodCutting {

	public static void main(String[] args) {
		int[] price = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		System.out.println(rodCuttingTD(price, 8, new int[price.length]));

	}

	private static int rodCuttingTD(int[] price, int n, int[] strg) {
		if (n == 0)
			return price[0];

		int max = price[n];
		int left = 1;
		int right = n - 1;

		if (strg[n] != 0)
			return strg[n];

		while (left <= right) {
			int lc = rodCuttingTD(price, left, strg);
			int rc = rodCuttingTD(price, right, strg);
			int ans = lc + rc;
			if (ans > max) {
				max = ans;
			}
			left++;
			right--;
		}
		strg[n] = max;
		return max;
	}

}
