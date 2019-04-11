public class BoardPath {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		// System.out.println(boardPathCount(0, 25));
		// System.out.println(boardPathCountTD(0, 25, new int[26]));
		// System.out.println(boardPathBU(0, 25));
		System.out.println(boardPathBUSlider(0, 25));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static int boardPathCount(int curr, int end) {
		if (curr > end) {
			return 0;
		}
		if (curr == end) {
			return 1;
		}

		int res = 0;
		for (int dice = 1; dice <= 6; dice++) {
			res += boardPathCount(curr + dice, end);
		}

		return res;
	}

	public static int boardPathCountTD(int curr, int end, int[] strg) {
		if (curr > end) {
			return 0;
		}
		if (curr == end) {
			return 1;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int res = 0;
		for (int dice = 1; dice <= 6; dice++) {
			res += boardPathCountTD(curr + dice, end, strg);
		}
		strg[curr] = res;
		return res;
	}

	public static int boardPathBU(int curr, int end) {
		int[] strg = new int[end + 6];
		strg[end] = 1;

		for (int i = end - 1; i >= curr; i--) {
			for (int dice = 1; dice <= 6; dice++) {
				strg[i] += strg[i + dice];
			}
		}

		return strg[0];
	}

	public static int boardPathBUSlider(int curr, int end) {
		int[] strg = new int[6];
		strg[0] = 1;

		for (int i = end - 1; i >= curr; i--) {
			int sum = 0;
			for (int dice = 0; dice <= 5; dice++) {
				sum += strg[dice];
			}

			for (int j = 5; j > 0; j--) {
				strg[j] = strg[j - 1];
			}
			strg[0] = sum;
		}

		return strg[0];

	}

}
