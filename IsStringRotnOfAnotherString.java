import java.util.Scanner;

public class IsStringRotnOfAnotherString {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		System.out.println(rotation(str1, str2));

	}

	public static boolean rotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		String temp = str1.concat(str1);
		return temp.indexOf(str2) != -1;

	}
}
