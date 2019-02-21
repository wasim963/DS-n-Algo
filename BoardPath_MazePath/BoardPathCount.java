public class BoardPathCount {

	public static void main(String[] args) {
		System.out.println(boardPath(7, 10, 6));
	}

	private static int boardPath(int curr, int dest, int path) {
		if (curr > dest)
			return 0;
		if (curr == dest)
			return 1;

		int res = 0;
		for (int dice = 1; dice <= path; dice++) {
			res += boardPath(curr + dice, dest, path);
		}
		return res;
	}

}
