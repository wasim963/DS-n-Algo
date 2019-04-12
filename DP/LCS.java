public class LCS {

	public static void main(String[] args) {
		String s1 = "SundayMonday";
		String s2 = "SaturdayTuesday";
		long start = System.currentTimeMillis();
		//System.out.println(lcs(s1, s2));
		System.out.println(lcsTD(s1, s2, new int[s1.length() + 1][s2.length() + 1]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (ch1 == ch2) {
			return 1 + lcs(ros1, ros2);
		}

		int ans = 0;
		int c1 = lcs(s1, ros2);
		int c2 = lcs(ros1, s2);
		ans = Math.max(c1, c2);
		return ans;
	}

	public static int lcsTD(String s1, String s2, int[][] strg) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (ch1 == ch2) {
			return 1 + lcsTD(ros1, ros2, strg);
		}

		int ans = 0;
		int c1 = lcsTD(s1, ros2, strg);
		int c2 = lcsTD(ros1, s2, strg);
		ans = Math.max(c1, c2);
		strg[s1.length()][s2.length()] = ans;
		return ans;
	}

}