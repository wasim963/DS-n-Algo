import java.util.*;
import java.io.*;

public class AreParanthesisBalanced {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(isBalanced(str));
	}

	private static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < str.length()) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty()) {
					return false;
				} else if (ch == ')') {
					char top = stack.pop();
					if (top != '(') {
						return false;
					}
				} else if (ch == '}') {
					char top = stack.pop();
					if (top != '{') {
						return false;
					}
				} else if (ch == ']') {
					char top = stack.pop();
					if (top != '[') {
						return false;
					}
				}
			}
			i++;
		}
		if (!stack.isEmpty())
			return false;
		else
			return true;

	}

}