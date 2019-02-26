import java.io.*;

public class NQueen {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boardSize = Integer.parseInt(br.readLine());
		nQueen(new boolean[boardSize][boardSize], 0, "");
	}

	private static void nQueen(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans + " ");
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				nQueen(board, row + 1, ans + "{" + (row + 1) + ", " + (col + 1) + "}");
				board[row][col] = false;
			}

		}
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {

		// Vertical Check;
		int r = row;
		int c = col;
		while (r >= 0) {
			if (board[r][c])
				return false;
			r--;
		}

		// Left Diagonal
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c])
				return false;
			r--;
			c--;
		}

		// Right Diagonal
		r = row;
		c = col;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c])
				return false;
			r--;
			c++;
		}

		return true;
	}

}
