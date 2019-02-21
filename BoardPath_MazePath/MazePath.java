import java.util.ArrayList;

public class MazePath {

	public static void main(String[] args) {

		System.out.println(mazePath(0, 0, 2, 2));

	}

	private static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {
		if (cr > er || cc > ec) {
			ArrayList<String> br1 = new ArrayList<>();
			return br1;
		}
		if (cr == er && cc == ec) {
			ArrayList<String> br2 = new ArrayList<>();
			br2.add("");
			return br2;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrr = mazePath(cr + 1, cc, er, ec);
		ArrayList<String> rrc = mazePath(cr, cc + 1, er, ec);
		for (String val : rrr) {
			mr.add("H" + val);
		}

		for (String val : rrc) {
			mr.add("V" + val);
		}

		return mr;
	}

}
