public class NoConsecutiveHead_Method2 {

	public static void main(String[] args) {
		System.out.println(noConsecutiveHead(3, "", false));
	}

	private static int noConsecutiveHead(int n, String ans, boolean wasLastHeadIncluded) {
		if (n == 0) {
			System.out.println(ans);
			return 1;
		}
		int res = 0;
		if (!wasLastHeadIncluded)
			res += noConsecutiveHead(n - 1, ans + "H", true);
		res += noConsecutiveHead(n - 1, ans + "T", false);
		return res;
	}

}
