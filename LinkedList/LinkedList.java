public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	Node head;
	Node tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void addLast(int item) {
		Node nn = new Node();
		nn.data = item;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
			head.next = null;
			return;
		}
		this.tail.next = nn;
		this.tail = nn;
		this.size++;
		nn.next = null;
	}

	public void addFirst(int item) {
		Node nn = new Node();
		nn.data = item;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			head.next = null;
			this.size++;
			return;
		}
		nn.next = head;
		head = nn;
		this.size++;
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty!!!");
		}
		int rv = head.data;
		return rv;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty!!!");
		}
		int rv = tail.data;
		return rv;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList Is Empty!!!");
		}
		Node temp = this.head;
		if (this.size == 1) {
			this.tail = null;
			this.head = null;
			this.size--;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return temp.data;
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty!!!");
		}
		Node temp = tail;
		if (this.size == 1) {
			this.tail = null;
			this.head = null;
			this.size--;
		} else {
			Node nm2 = this.getNodeAt(this.size - 2);
			this.tail = nm2;
			this.tail.next = null;
			this.size--;
		}
		return temp.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.head == null) {
			throw new Exception("LinkedList is Empty!!!");
		} else if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Invalid Index!!!");
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public Node getNodeAt(int idx) throws Exception {
		if (this.head == null) {
			throw new Exception("LinkedList is Empty!!!");
		} else if (idx < 0 || idx > this.size - 1) {
			throw new Exception("Invalid Index!!!");
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addAt(int item, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index!!!");
		}
		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size) {
			this.addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = nm1.next;
			nm1.next = nn;
			nn.next = np1;
			this.size++;
		}
	}

	public int removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LinkedList is Empty!!!");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}
		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = nm1.next;
			Node np2 = np1.next;
			nm1.next = np2;
			this.size--;
			return np1.data;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		if (this.size == 0)
			return;
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("\n----------------------------");
	}

}
