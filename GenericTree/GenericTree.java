import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		this.root = construct(new Scanner(System.in), null, -1);
	}

	private Node construct(Scanner scn, Node parent, int p) {
		if (parent == null) {
			System.out.println("Enter data for root Node");
		} else {
			System.out.println("Enter data for " + p + "th Node" + " of " + parent.data);
		}

		int val = scn.nextInt();
		Node nn = new Node();
		nn.data = val;
		this.size++;
		System.out.println("No of Children for " + nn.data + " ?");
		int noOfChildren = scn.nextInt();
		for (int i = 0; i < noOfChildren; i++) {
			nn.children.add(construct(scn, nn, i));
		}

		return nn;
	}

	public void display() {

		displayH(this.root);
	}

	private void displayH(Node node) {

		String str = node.data + " ->.";

		for (int i = 0; i < node.children.size(); i++) {
			str += node.children.get(i).data + " ";
		}
		System.out.println(str);

		for (int i = 0; i < node.children.size(); i++) {
			displayH(node.children.get(i));
		}

	}

	public int size() {
		return this.size;
	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {

		int tcs = 0;
		for (Node child : node.children) {
			tcs += size2(child);
		}

		return tcs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		int max = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			int max2 = max(node.children.get(i));
			if (max2 > max)
				max = max2;
		}
		return max;
	}

	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {

		if (item == node.data) {
			return true;
		}
		for (Node child : node.children) {
			boolean flag = find(item, child);
			if (flag) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		int th = -1;
		for (Node child : node.children) {
			int ch = height(child);
			if (ch > th)
				th = ch;
		}

		return th + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {
			Node ln = node.children.get(left);
			Node rn = node.children.get(right);
			node.children.set(left, rn);
			node.children.set(right, ln);
			left++;
			right--;
		}
	}

	public boolean structurallySimilar(GenericTree gt2) {  
		return structurallySimilar(this.root, gt2.root);
	}

	private boolean structurallySimilar(Node node1, Node node2) {

		if (node1.children.size() != node2.children.size()) {
			return false;
		}
		for (int i = 0; i < node1.children.size(); i++) {
			boolean flag = structurallySimilar(node1.children.get(i), node2.children.get(i));
			if (!flag)
				return false;
		}
		return true;

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		// self work
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		// self work
		System.out.print(node.data + " ");

	}

	public void levelorder() {

		LinkedList<Node> list = new LinkedList<>();
		list.addLast(this.root);
		while (!list.isEmpty()) {
			Node dq = list.removeFirst();
			System.out.print(dq.data + " ");
			for (Node child : dq.children) {
				list.addLast(child);
			}

		}
	}

	public void levelorderLW() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node dq = queue.removeFirst();
			System.out.print(dq.data + " ");
			for (Node child : dq.children) {
				helper.addLast(child);
			}
			if (queue.isEmpty()) {
				queue = helper;
				helper = new LinkedList<>();
				System.out.println();
			}

		}

	}

	public void levelorderZZ() {

		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.addLast(this.root);
		int count = 0;
		while (!queue.isEmpty()) {
			Node dq = queue.removeFirst();
			System.out.print(dq.data + " ");
			if (count % 2 == 0) {
				for (Node child : dq.children) {
					stack.addFirst(child);
				}
			} else {
				for (int i = dq.children.size() - 1; i >= 0; i--) {
					stack.addFirst(dq.children.get(i));
				}
			}
			if (queue.isEmpty()) {
				queue = stack;
				stack = new LinkedList<>();
				System.out.println();
				count++;
			}

		}

	}

	private class Heapmover {
		int size;
		int max = Integer.MIN_VALUE;
		boolean find;
		int ht;

		Node pred;
		Node succ;
		Node jl;
	}

	public void MultiSolver(int item) {

		Heapmover mover = new Heapmover();
		MultiSolver(this.root, item, 0, mover);
		System.out.println("Max: " + mover.max);
		System.out.println("find: " + mover.find);
		System.out.println("Size: " + mover.size);
		System.out.println("Ht: " + mover.ht);
		System.out.println("Pred: " + (mover.pred == null ? "Null" : mover.pred.data));
		System.out.println("Succ: " + (mover.succ == null ? "Null" : mover.succ.data));
		System.out.println("JL: " + (mover.jl == null ? "Null" : mover.jl.data));
	}

	private void MultiSolver(Node node, int item, int depth, Heapmover mover) {

		mover.size++;
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (depth > mover.ht) {
			mover.ht = depth;
		}
		if (mover.find == true && mover.succ == null) {
			mover.succ = node;
		}
		if (node.data == item) {
			mover.find = true;
		}  

		if (mover.find == false) {
			mover.pred = node;
		}

		if (node.data > item) {
			if (mover.jl == null) {
				mover.jl = node;
			} else if (mover.jl.data > node.data) {
				mover.jl.data = node.data;
			}
		}
		for (Node child : node.children) {
			MultiSolver(child, item, depth + 1, mover);
		}
	}

	private class OrderPairCT {
		Node node;
		boolean selfDone;
		boolean childDone;
	}

	public void preorderICT() {
		LinkedList<OrderPairCT> stack = new LinkedList<>();
		OrderPairCT sp = new OrderPairCT();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPairCT tp = stack.getFirst();
			if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else if (tp.childDone == false) {
				for (int i = tp.node.children.size() - 1; i >= 0; i--) {
					OrderPairCT np = new OrderPairCT();
					np.node = tp.node.children.get(i);
					stack.addFirst(np);
				}
				tp.childDone = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postorderICT() {
		LinkedList<OrderPairCT> stack = new LinkedList<>();
		OrderPairCT sp = new OrderPairCT();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPairCT tp = stack.getFirst();
			if (tp.childDone == false) {
				for (int i = tp.node.children.size() - 1; i >= 0; i--) {
					OrderPairCT np = new OrderPairCT();
					np.node = tp.node.children.get(i);
					stack.addFirst(np);
				}
				tp.childDone = true;
			} else if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else {
				stack.removeFirst();
			}
		}
	}

	private class OrderPairO {
		Node node;
		boolean selfDone;
		int childDone;
	}

	public void preorderIO() {
		LinkedList<OrderPairO> stack = new LinkedList<>();
		OrderPairO sp = new OrderPairO();
		sp.node = this.root;
		stack.addFirst(sp); 
		while (!stack.isEmpty()) {
			OrderPairO tp = stack.getFirst();
			if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else if (tp.childDone < tp.node.children.size()) {
				OrderPairO np = new OrderPairO();
				np.node = tp.node.children.get(tp.childDone);
				stack.addFirst(np);
				tp.childDone++;
			} else {
				stack.removeFirst();
			}
		}
	}

	public void postorderIO() {
		LinkedList<OrderPairO> stack = new LinkedList<>();
		OrderPairO sp = new OrderPairO();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPairO tp = stack.getFirst();
			if (tp.childDone < tp.node.children.size()) {
				OrderPairO np = new OrderPairO();
				np.node = tp.node.children.get(tp.childDone);
				stack.addFirst(np);
				tp.childDone++;
			} else if (tp.selfDone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfDone = true;
			} else {
				stack.removeFirst();
			}
		}
	}

}
