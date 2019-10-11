package Graph;

public class FloydWarshall {

	public static void main(String[] args) {
		int INF = 888888;
		int mat[][] = { { 0, 1, 43 },
                                { 1, 0, 6 },
                                { INF, INF, 0 } };
		solve(mat, 3);
	}

	static void solve(int[][] mat, int v) {
		int[][] ans = new int[v][v];

		for (int k = 0; k < v; k++) {
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					if (i == j) {
						ans[i][j] = 0;
					} else if (i == k || j == k) {
						ans[i][j] = mat[i][j];
					} else {
						ans[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
					}
				}
			}

			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					mat[i][j] = ans[i][j];
				}
			}

		}

		int INF = 888888;
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				if (INF == ans[i][j]) {
					System.out.print("INF ");
				} else {
					System.out.print(ans[i][j] + "   ");
				}
			}
			System.out.println();
		}
	}

}
