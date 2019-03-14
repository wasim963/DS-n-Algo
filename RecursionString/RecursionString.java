public class RecursionString {

	public static void main(String[] args) {
		//subSequences("abc", "");
		permutations("abc", "");
	}

	private static void subSequences(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		subSequences(ros, ans);
		subSequences(ros, ans + ch);
	}

	private static void permutations(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			permutations(ros, ans.substring(0, i) + ch + ans.substring(i));
		}
	}

}
