import java.util.*;

public class StackReverseActual {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> helper = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		reverseStack(stack, helper);
		

	}

	private static void reverseStack(Stack<Integer> stack, Stack<Integer> helper) {
		if (stack.isEmpty()) {
			if (helper.isEmpty()) {
				return;
			}
			int valh = helper.pop();
			reverseStack(stack, helper);
			stack.push(valh);
			return;

		}

		int val = stack.pop();
		helper.push(val);
		reverseStack(stack, helper);
	}

}
