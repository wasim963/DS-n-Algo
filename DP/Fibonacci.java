public class Fibonacci {

	public static void main(String[] args) {
		int n = 150;
		long start = System.currentTimeMillis();
		// System.out.println(fibonacci(n));
		// System.out.println(fibonacciRBtr(n, new int[n + 1]));
		// System.out.println(fibonacciI(n, new int[n + 1]));
		System.out.println(fibonacciIBtr(n, new int[2]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacciRBtr(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}
		int ans = fibonacciRBtr(n - 1, strg) + fibonacciRBtr(n - 2, strg);
		strg[n] = ans;
		return ans;
	}

	public static int fibonacciI(int n, int[] strg) {

		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibonacciIBtr(int n, int[] strg) {

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			int temp = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = temp;
		}

		return strg[1];
	}

}
