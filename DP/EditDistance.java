public class EditDistance {

	public static void main(String[] args) {
		String s1 = "SundayMonday";
		String s2 = "SaturdayTuesday";
		long start = System.currentTimeMillis();
		System.out.println(editDistance(s1, s2));
	//	System.out.println(editDistanceBU(s1, s2));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int editDistance(String s1, String s2) {
		// insert
		if (s1.length() != 0 && s2.length() == 0) {
			return s1.length();
		}
		// delete
		if (s1.length() == 0 && s2.length() != 0) {
			return s2.length();
		}
		// replace
		if (s1.length() == 0 && s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = editDistance(ros1, ros2);
		} else {
			int ins = editDistance(s1, ros2);
			int del = editDistance(ros1, s2);
			int rep = editDistance(ros1, ros2);
			ans = Math.min(ins, Math.min(del, rep)) + 1;
		}
		return ans;
	}

	public static int editDistanceBU(String s1, String s2) {
		
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					int ins = strg[row + 1][col];
					int del = strg[row][col + 1];
					int rep = strg[row + 1][col + 1];
					strg[row][col] = Math.min(ins, Math.min(del, rep)) + 1;
				}

			}
		}
		return strg[0][0];
	}

}
