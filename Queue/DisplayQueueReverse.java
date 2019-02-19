import java.util.*;

public class DisplayQueueReverse {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 10; i < 50; i = i + 10) {
			queue.add(i);
		}
		System.out.println(queue);
		displayReverse(queue, 0);
		System.out.println(queue);
	}
	
	private static void displayReverse(Queue<Integer> queue,int count){
		if(count==queue.size())
			return;
		
		int temp = queue.remove();
		queue.add(temp);
		displayReverse(queue, count+1);
		System.out.print(temp+"  ");
	}

}
