import java.util.ArrayList;

public class BoardPath {

	public static void main(String[] args) {
		System.out.println(board(5, 10));
	}

	private static ArrayList<String> board(int curr, int dest) {
		if (curr > dest) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		} else if (curr == dest) {
			ArrayList<String> cr = new ArrayList<>();
			cr.add("");
			return cr;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			rr = board((curr + dice), dest);
			for (String val : rr) {
				mr.add(dice + val);
			}
		}

		return mr;
	}

}
