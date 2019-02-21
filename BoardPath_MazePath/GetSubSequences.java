import java.util.ArrayList;

public class GetSubSequences {

	public static void main(String[] args) {
		System.out.println(getSubSeq("abc"));
	}

	private static ArrayList<String> getSubSeq(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = getSubSeq(str.substring(1));

		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
		}
		return mr;
	}

}
