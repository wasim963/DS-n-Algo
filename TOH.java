import java.io.*;

public class TOH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfDisks = Integer.parseInt(br.readLine());
		tohSteps(noOfDisks, "T1", "T2", "T3");
	}

	private static void tohSteps(int noOfDisks, String T1, String T2, String T3) {
		if (noOfDisks == 0)
			return;

		tohSteps(noOfDisks - 1, T1, T3, T2);
		System.out.println("Move " + noOfDisks + "th disk from " + T1 + " to " + T2);
		tohSteps(noOfDisks - 1, T3, T2, T1);
	}

}
