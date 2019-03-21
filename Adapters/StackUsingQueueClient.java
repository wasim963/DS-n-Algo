package Adapters;

public class StackUsingQueueClient {

	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.display();
		System.out.println("\n-----------------");
		System.out.println(stack.top());
		stack.display();
		System.out.println();
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
	}

}
