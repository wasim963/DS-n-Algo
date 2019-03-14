public class NonRedundantPermutation {

	public static void main(String[] args) {
		//permutationOfStr_2("abca", "");
		System.out.println("-----------");
		permutationOfStr_1("abca", "");
	}

	// time approach
	private static void permutationOfStr_2(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			boolean flag = false;
			for (int j = i - 1; j >= 0; j--) {
				if (ch == str.charAt(j)) {
					flag = true;
					break;
				}
			}
			if (flag)
				continue;
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutationOfStr_2(ros, ans + ch);
		}
	}

	// Boolean Array Approach
	private static void permutationOfStr_1(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] visited = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (visited[ch])
				continue;
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutationOfStr_1(ros, ans + ch);
			visited[ch] = true;
		}
	}

}
