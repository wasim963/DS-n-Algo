public class MCM {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr = {1, 2, 3, 4, 5 };
		System.out.println(MCMTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		System.out.println(MCMBU(arr));
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
	
	public static int MCMBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 2; slide <= n - 1; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k < ei; k++) {
					int fh = strg[si][k];
					int sh = strg[k][ei];
					int sw = arr[si] * arr[k] * arr[ei];

					int ta = fh + sh + sw;
					if (ta < min) {
						min = ta;
					}
				}
				strg[si][ei] = min;

			}
		}
		return strg[0][n - 1];
	}

}
