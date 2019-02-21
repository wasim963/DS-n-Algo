import java.util.ArrayList;

public class GetSubSequenecesWithAsciiCode {

	public static void main(String[] args) {
		System.out.println(getSubSeqWithAscii("ab"));
	}

	private static ArrayList<String> getSubSeqWithAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rr = getSubSeqWithAscii(str.substring(1));

		for (String rrr : rr) {
			mr.add(rrr);
			mr.add((int) ch + rrr);
			mr.add(ch + rrr);
		}

		return mr;
	}

}
