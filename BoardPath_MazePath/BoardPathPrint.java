public class BoardPathPrint {

	public static void main(String[] args) {
		boardPathPrint(5, 10, 6, "");

	}

	private static void boardPathPrint(int curr, int dest, int path, String ans) {
		if (curr > dest) {
			return;
		}
		if (curr == dest) {
			System.out.print(ans+" ");
		}

		for (int dice = 1; dice <= path; dice++) {
			boardPathPrint(curr + dice, dest, path, ans + dice);
		}
	}

}
