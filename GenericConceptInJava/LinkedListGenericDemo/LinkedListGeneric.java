package L23D2;


// Crux2nd
public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;
	}

	Node head;
	Node tail;
	int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	// O(1)
	public void addFirst(T item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = head;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}
	}

	// O(1)
	public void addLast(T item) {
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		if (this.size() > 0) {
			this.tail.next = nn;
			this.tail = nn;
			this.size++;
		}
		if (this.size() == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		}

	}

	// O(1)
	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.head.data;
	}

	// O(1)
	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.tail.data;
	}

	// O(n)
	public T getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	// O(n)
	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index");
		}
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// O(n)
	public void addAt(T item, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index");
		}
		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size) {
			this.addLast(item);
		} else {
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = this.getNodeAt(idx);

			nm1.next = nn;
			nn.next = np1;
			this.size++;
		}
	}

	// O(1)
	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		Node temp = this.head;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return temp.data;
	}

	// O(n)
	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}
		Node temp = this.tail;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node n = this.getNodeAt(this.size - 2);
			this.tail = n;
			this.tail.next = null;
			this.size--;
		}
		return temp.data;
	}

	// O(n);
	public T removeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		} else if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node nm2 = this.getNodeAt(idx - 1);
			Node n = nm2.next;
			Node np1 = n.next;
			nm2.next = np1;
			this.size--;
			return n.data;
		}

	}

	// O(n)
	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void ReverseDI() throws Exception {

		for (int i = 0; i < this.size / 2; i++) {
			Node f = getNodeAt(i);
			Node l = getNodeAt(this.size - i - 1);
			T temp = f.data;
			f.data = l.data;
			l.data = temp;
		}

	}

	public void ReversePI() {

		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	public void ReversePointerRec() {

		ReversePRH(this.head, this.head.next);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;

	}

	private void ReversePRH(Node prev, Node curr) {
		if (curr == null) {
			return;
		}
		ReversePRH(curr, curr.next);
		curr.next = prev;
	}

	// Void Type Return Data Recursively

	public void ReverseDR() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;
		ReverseDRH(mover, this.head, 0);

	}

	private void ReverseDRH(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		ReverseDRH(mover, right.next, count + 1);
		if (count >= this.size / 2) {
			T temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	private class HeapMover {
		Node left;

	}

	// Node Type Return Reverse Data Recursively

	public void ReverseDRV() {

		ReverseDRH(this.head, this.head, 0);

	}

	private Node ReverseDRH(Node left, Node right, int count) {
		if (right == null) {
			return left;
		}

		Node nl = ReverseDRH(left, right.next, count + 1);
		if (count >= this.size / 2) {
			T temp = nl.data;
			nl.data = right.data;
			right.data = temp;
		}

		return nl.next;
	}

	public void fold() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;
		fold(mover, this.head, 0);
	}

	private void fold(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);
		if (count > this.size / 2) {
			Node ahead = mover.left.next;
			mover.left.next = right;
			right.next = ahead;
			mover.left = ahead;
		}
		if (count == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public Node midNode() {
		Node temp1 = this.head;
		Node temp2 = temp1;
		while (temp2.next != null && temp2.next.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}

		return temp1;

	}

	public T KthNodeFromLast(int k) {
		Node temp1 = this.head;
		Node temp2 = this.head;
		for (int i = 0; i < k; i++) {
			temp1 = temp1.next;
		}
		while (temp1 != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp2.data;
	}

	public void kReverse(int k) throws Exception {

		LinkedListGeneric<T> prev = null;
		LinkedListGeneric<T> curr = null;

		while (this.size != 0) {

			curr = new LinkedListGeneric<T>();
			for (int i = 0; i < k; i++) {
				curr.addFirst(this.removeFirst());
			}
			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

		}

		this.head = prev.head;
		this.tail = prev.tail;
	}

}
