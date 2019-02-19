import java.util.*;

public class QueueReverseActual {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 10; i < 50; i = i + 10){
			queue.add(i);
		}
		System.out.println(queue);
		reverseQueue(queue);
		System.out.println(queue);

	}

	private static void reverseQueue(Queue<Integer> queue) {
		if(queue.isEmpty())
			return;
		
		int temp = queue.remove();
		reverseQueue(queue);
		queue.add(temp);
	}

}
