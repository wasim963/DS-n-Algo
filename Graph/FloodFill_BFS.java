package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloodFill_BFS {

	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Wasim\\Desktop\\apple.txt");
		final Scanner scn = new Scanner(file);
		int row = scn.nextInt();
		int col = scn.nextInt();

		char mat[][] = new char[row][col];

		readMatrix(scn, mat);
		displayMatrix(mat);
		System.out.println("-------------------------------------------");
		char ch = mat[2][4];
		fillMat(mat, 2, 4, ch, '$');
		displayMatrix(mat);
	}

	public static void fillMat(char[][] mat, int i, int j, char ch, char color) {
		// Matrix bounds
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return;
		}

		// Restricted Bounds
		if (mat[i][j] != ch) {
			return;
		}

		// fill color
		mat[i][j] = color;

		// Apply BFS
		for (int k = 0; k < 4; k++) {
			fillMat(mat, i + dx[k], j + dy[k], ch, color);
		}

	}

	// Read Matrix
	public static void readMatrix(final Scanner scn, char mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			String colstr = "";
			if (scn.hasNext()) {
				colstr = scn.next();
			} else {
				break;
			}
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = colstr.charAt(j);

			}
		}
	}

	// Display matrix
	public static void displayMatrix(char[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}
