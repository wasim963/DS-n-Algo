import java.io.*;

public class Pascal_triangle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pascTriangle(n, 0, 0);

	}

	private static void pascTriangle(int n, int row, int col) {
		if (row == n) {
			return;
		}

		else if (col > row) {
			System.out.println();
			pascTriangle(n, row + 1, 0);
		}
		else{
			System.out.print(nCr(row, col) + " ");
			pascTriangle(n, row, col + 1);
		}
	}

	private static int nCr(int row, int col) {
		return fact(row) / (fact(col) * fact(row - col));
	}

	private static int fact(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			return (n * fact(n - 1));
	}

}
