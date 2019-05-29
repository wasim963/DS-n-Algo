public class HeapClient {

	public static void main(String[] args) {
		

		Heap heap = new Heap();
		heap.add(60);
		heap.display();
		heap.add(50);
		heap.display();
		heap.add(40);
		heap.display();
		heap.add(30);
		heap.display();
		heap.add(20);
		heap.display();
		heap.add(10);
		heap.display();

		System.out.println(heap.remove());
		heap.display();
		System.out.println(heap.remove());
		heap.display();
		System.out.println(heap.remove());
		heap.display();

	}

}
