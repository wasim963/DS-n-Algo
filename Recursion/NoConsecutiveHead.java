public class NoConsecutiveHead {

	public static void main(String[] args) {
		noConsecutiveHead(4, "");
	}

	private static void noConsecutiveHead(int noOfThrows, String ans) {
		if (noOfThrows == 0) {
			System.out.println(ans);
			return;
		}
		if (ans.length() == 0)
			noConsecutiveHead(noOfThrows - 1, ans + "H");
		if (ans.length() > 0 && ans.charAt(ans.length() - 1) != 'H')
			noConsecutiveHead(noOfThrows - 1, ans + "H");
		noConsecutiveHead(noOfThrows - 1, ans + "T");

	}

}
