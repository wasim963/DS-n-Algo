public class RodCutting {

	public static void main(String[] args) {
		int[] price = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// int[] price2 = {1, 5, 8, 9,10, 17, 17, 20};
		long start = System.currentTimeMillis();
		System.out.println(rodCuttingTD(price, 8, new int[price.length]));
		System.out.println(rodCuttingBU(price));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	private static int rodCuttingTD(int[] price, int n, int[] strg) {
		if (n < 0)
			return 0;

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

	private static int rodCuttingBU(int[] price) {
		int[] strg = new int[price.length];
		strg[0] = price[0];
		strg[1] = price[1];
		for (int i = 2; i < price.length; i++) {
			int left = 1;
			int right = i - 1;
			strg[i] = price[i];
			while (left <= right) {
				int lc = strg[left];
				int rc = strg[right];
				int ans = lc + rc;
				if (ans > strg[i]) {
					strg[i] = ans;
				}
				left++;
				right--;
			}

		}
		return strg[price.length-1];
	}

}
