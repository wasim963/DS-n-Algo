package L22;

public class WineSale {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 3, 6 };
		long start = System.currentTimeMillis();
		System.out.println(wine(arr, 1, 0, arr.length - 1));
		System.out.println(wineTD(arr, 0, arr.length - 1, new int[arr.length][arr.length]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static int wine(int[] arr, int yr, int si, int ei) {
		if (si > ei) {
			return 0;
		}

		int start = yr * arr[si] + wine(arr, yr + 1, si + 1, ei);
		int end = yr * arr[ei] + wine(arr, yr + 1, si, ei - 1);
		return Math.max(start, end);
	}

	private static int wineTD(int[] arr, int si, int ei, int[][] strg) {
		if (si == ei) {
			return (arr.length - (ei - ei)) * arr[si];
		}
		if (strg[si][ei] != 0)
			return strg[si][ei];

		int yr = arr.length - (ei - si);
		int start = yr * arr[si] + wineTD(arr, si + 1, ei, strg);
		int end = yr * arr[ei] + wineTD(arr, si, ei - 1, strg);
		int ans = Math.max(start, end);
		strg[si][ei] = ans;
		return ans;
	}

}
