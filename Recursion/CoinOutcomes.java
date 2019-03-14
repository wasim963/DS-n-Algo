public class c {

	public static void main(String[] args) {
		getOutcomes(3, "");
	}

	private static void getOutcomes(int noOfThrows, String ans) {
		if (noOfThrows == 0) {
			System.out.println(ans);
			return;
		}

		getOutcomes(noOfThrows - 1, ans + "H");
		getOutcomes(noOfThrows - 1, ans + "T");
	}

}
