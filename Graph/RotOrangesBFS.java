package Graph;

import java.util.*;

/*
 Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {1, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges can become rotten in 2 time frames.


Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges cannot be rotten.

 */

public class RotOrangesBFS {

	public static void main(String[] args) {
		// int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1} };
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 0, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		System.out.println(solve(arr, 3, 5));
	}

	static class O {
		int x;
		int y;
		int layer;

		public O(int x, int y, int layer) {
			this.x = x;
			this.y = y;
			this.layer = layer;
		}

	}

	static boolean isSafe(int[][] arr, int i, int j) {
		if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length)
			return true;
		return false;
	}

	static boolean notRot(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1)
					return true;
			}
		}
		return false;
	}

	static int solve(int[][] arr, int n, int m) {
		int res = 0;
		boolean[][] vis = new boolean[n][m];
		Queue<O> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 2) {
					q.add(new O(i, j, 0));
					vis[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			O ro = q.poll();
			res = Math.max(res, ro.layer);

			int X = ro.x;
			int Y = ro.y;
			// Up
			if (isSafe(arr, X - 1, Y) && !vis[X - 1][Y] && arr[X - 1][Y] == 1) {
				q.add(new O(X - 1, Y, ro.layer + 1));
				vis[X - 1][Y] = true;
				arr[X - 1][Y] = 2;
			}

			// Down
			if (isSafe(arr, X + 1, Y) && !vis[X + 1][Y] && arr[X + 1][Y] == 1) {
				q.add(new O(X + 1, Y, ro.layer + 1));
				vis[X + 1][Y] = true;
				arr[X + 1][Y] = 2;
			}

			// left
			if (isSafe(arr, X, Y - 1) && !vis[X][Y - 1] && arr[X][Y - 1] == 1) {
				q.add(new O(X, Y - 1, ro.layer + 1));
				vis[X][Y - 1] = true;
				arr[X][Y - 1] = 2;
			}

			// Right
			if (isSafe(arr, X, Y + 1) && !vis[X][Y + 1] && arr[X][Y + 1] == 1) {
				q.add(new O(X, Y + 1, ro.layer + 1));
				vis[X][Y + 1] = true;
				arr[X][Y + 1] = 2;
			}

		}

		if (!notRot(arr, n, m))
			return res;
		int p = -1;
		return p;
	}

}
