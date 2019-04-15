public class MCM {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr = {1, 2, 3, 4, 5 };
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k < ei; k++) {
			int fh = MCMTD(arr, si, k, strg);
			int sh = MCMTD(arr, k, ei, strg);
			int sw = arr[si] * arr[k] * arr[ei];

			int ta = fh + sh + sw;
			if (ta < min) {
				min = ta;
			}
		}
		strg[si][ei] = min;
		return min;
	}

}
