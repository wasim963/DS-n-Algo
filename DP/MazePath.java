public class MazePath {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// System.out.println(mazePath(0, 0, 10, 10));
		// System.out.println(mazePathTD(0, 0, 10, 10, new int[11][11]));
		System.out.println(mazePathBU(10, 10));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int mazePath(int cr, int cc, int er, int ec) {
		if (cr > er || cc > ec) {
			return 0;
		}
		if (cr == er && cc == ec) {
			return 1;
		}

		int row = mazePath(cr + 1, cc, er, ec);
		int col = mazePath(cr, cc + 1, er, ec);
		return row + col;

	}

	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr > er || cc > ec) {
			return 0;
		}
		if (cr == er && cc == ec) {
			return 1;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int row = mazePathTD(cr + 1, cc, er, ec, strg);
		int col = mazePathTD(cr, cc + 1, er, ec, strg);
		strg[cr][cc] = row + col;
		return row + col;
	}

	public static int mazePathBU(int er, int ec) {
		int[][] strg = new int[er + 1][ec + 1];

		for (int cr = er; cr >= 0; cr--) {
			for (int cc = ec; cc >= 0; cc--) {
				if (cr == er || cc == ec) {
					strg[cr][cc] = 1;
					continue;
				}
				strg[cr][cc] += strg[cr + 1][cc] + strg[cr][cc + 1];
			}
		}

		return strg[0][0];
	}

}
