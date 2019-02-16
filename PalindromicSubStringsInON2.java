import java.io.*;

public class PalindromicSubStringsInON2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		isPalindrome(str);
	}

	private static void isPalindrome(String str) {
		int n = str.length();
		int count = 0;

		// Odd Length String
		for (int axis = 0; axis < n; axis++) {
			for (int orbit = 0; (axis + orbit) < str.length() && (axis - orbit) >= 0; orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit))
					count++;
				else
					break;
			}
		}

		// Even Length String
		for (double axis = 0.5; axis < n; axis++) {
			for (double orbit = 0.5; (axis - orbit) >= 0 && (axis + orbit) < str.length(); orbit++) {
				if (str.charAt((int) (axis + orbit)) == str.charAt((int) (axis - orbit)))
					count++;
				else
					break;
			}
		}
		System.out.println(count);
	}

}
