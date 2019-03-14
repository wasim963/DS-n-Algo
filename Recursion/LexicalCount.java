public class LexicalCount {

	public static void main(String[] args) {
		lexFun(0, 50);
	}

	private static void lexFun(int curr, int end) {
		if (curr > end)
			return;

		System.out.println(curr);
		if (curr == 0) {
			for (int i = 1; i <= 9; i++) {
				lexFun(curr * 10 + i, end);
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				lexFun(curr * 10 + i, end);
			}
		}
	}

}
