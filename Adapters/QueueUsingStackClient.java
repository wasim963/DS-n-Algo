package Adapters;

public class QueueUsingStackClient {

	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.display();
		System.out.println("\n-------------------");
		System.out.println(queue.getFirst());
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.getFirst());
	}

}
