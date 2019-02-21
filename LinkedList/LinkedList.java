public class LinkedList {

	private class Node {
		int data;
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
	public void addFirst(int item) {
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
	public void addLast(int item) {
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
	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		return this.tail.data;
	}
	
	

	// O(n)
	public int getAt(int idx) throws Exception {
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
	Node getNodeAt(int idx) throws Exception {
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
	public void addAt(int item, int idx) throws Exception {
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
	public int removeFirst() throws Exception {
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
	public int removeLast() throws Exception {
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
	public int removeAt(int idx) throws Exception {
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
		System.out.println("--------------------------");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
		System.out.println("--------------------------");
	}

	public void ReverseDI() throws Exception {

		for (int i = 0; i < this.size / 2; i++) {
			Node f = getNodeAt(i);
			Node l = getNodeAt(this.size - i - 1);
			int temp = f.data;
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
			int temp = mover.left.data;
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
			int temp = nl.data;
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

	public int KthNodeFromLast(int k) {
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

	public LinkedList mergetwoSortedLL(LinkedList other) {
		LinkedList rv = new LinkedList();
		Node ttemp = this.head;
		Node otemp = other.head;

		while (ttemp != null && otemp != null) {
			if (ttemp.data < otemp.data) {
				rv.addLast(ttemp.data);
				ttemp = ttemp.next;
			} else {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			}

		}

		if (ttemp == null) {
			while (otemp != null) {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			}
		}

		if (otemp == null) {
			while (ttemp != null) {
				rv.addLast(ttemp.data);
				ttemp = ttemp.next;
			}
		}

		return rv;
	}

	public void mergeSort() {

		if (this.size == 1) {
			return;
		}
		LinkedList fh = new LinkedList();
		LinkedList sh = new LinkedList();

		Node mid = this.midNode();
		Node midn = mid.next;

		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		sh.head = midn;
		sh.tail = this.tail;
		sh.size = (this.size) / 2;

		fh.mergeSort();
		sh.mergeSort();

		LinkedList merged = fh.mergetwoSortedLL(sh);

		this.head = merged.head;
		this.tail = merged.tail;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;
		LinkedList curr = null;

		while (this.size != 0) {

			curr = new LinkedList();
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
