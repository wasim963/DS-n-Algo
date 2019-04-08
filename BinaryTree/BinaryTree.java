import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BinaryTree() {
		this.root = construct(new Scanner(System.in), null, false);
	}

	private Node construct(Scanner scn, Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter data for root node: ?");
		} else {
			if (ilc) {
				System.out.println("Enter data for left node of " + parent.left);
			} else {
				System.out.println("Enter data for right child of " + parent.data);
			}
		}
		int val = scn.nextInt();
		Node nn = new Node();
		nn.data = val;
		this.size++;
		System.out.println("Is there left child ?");
		boolean lc = scn.nextBoolean();
		if (lc) {
			nn.left = construct(scn, nn, true);
		}
		System.out.println("Is there right child ?");
		boolean rc = scn.nextBoolean();
		if (rc) {
			nn.right = construct(scn, nn, false);
		}
		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi) {
			return null;
		}
		Node nn = new Node();
		
		nn.data = pre[plo];  
		
		int si = -1;
		for (int i = ilo; i <= ihi; i++) {
			if (pre[plo] == in[i]) { 
				si = i;
				break;
			}
		}
		int nel = si - ilo;
		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);
		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += " . ";
		}
		str += " -> " + node.data + " <- ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += " . ";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size2(node.left);
		int rs = size2(node.right);
		return 1 + ls + rs;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int max = node.data;
		int maxlc = max(node.left);
		if (max < maxlc) {
			max = maxlc;
		}
		int maxrc = max(node.right);
		if (max < maxrc) {
			max = maxrc;
		}
		return max;
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		boolean lcf = find(node.left, item);
		boolean rcf = find(node.right, item);
		return lcf || rcf;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public int diameter() {
		return diameter(this.root);
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int sp = height(node.left) + height(node.right) + 2;
		int ld = diameter(node.left);
		int rd = diameter(node.right);
		return Math.max(sp, Math.max(ld, rd));

	}

	private class Pair {

		int height = -1;
		int diameter = 0;
		boolean bool = true;
	}

	public int diameterPair() {
		Pair pair = diameterPair(this.root);
		return pair.diameter;
	}

	private Pair diameterPair(Node node) {

		if (node == null) {
			Pair br = new Pair();
			return br;
		}

		Pair lr = diameterPair(node.left);
		Pair rr = diameterPair(node.left);
		Pair mr = new Pair();
		mr.height = Math.max(lr.height, rr.height) + 1;
		int sp = lr.height + rr.height + 2;
		int ld = lr.diameter;
		int rd = rr.diameter;
		mr.diameter = Math.max(ld, Math.max(rd, sp));
		return mr;
	}

	public boolean isBalanced() {
		Pair pair = isBalanced(this.root);
		return pair.bool;

	}

	private Pair isBalanced(Node node) {
		if (node == null) {
			Pair br = new Pair();
			return br;
		}

		Pair lr = isBalanced(node.left);
		Pair rr = isBalanced(node.right);
		Pair mr = new Pair();
		mr.height = Math.max(lr.height, rr.height) + 1;
		int bf = lr.height - rr.height;
		if (lr.bool == false || rr.bool == false) {
			mr.bool = false;
		} else if (bf == 0 || bf == -1 || bf == 1) {
			mr.bool = true;
		} else {
			mr.bool = false;
		}
		return mr;

	}


	private class OrderPair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void preorderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();
		OrderPair sp = new OrderPair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPair tp = stack.getFirst();
			if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else if (tp.leftdone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);
				}
				tp.leftdone = true;

			} else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightdone = true;

			} else {
				stack.removeFirst();
			}

		}
	}

	public void postorderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();
		OrderPair sp = new OrderPair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPair tp = stack.getFirst();
			if (tp.leftdone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);
				}
				tp.leftdone = true;

			} else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightdone = true;

			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			} else {
				stack.removeFirst();
			}

		}
	}

	public void inorderI() {
		LinkedList<OrderPair> stack = new LinkedList<>();
		OrderPair sp = new OrderPair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			OrderPair tp = stack.getFirst();
			if (tp.leftdone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);
				}
				tp.leftdone = true;

			} else if (tp.selfdone == false) {
				System.out.print(tp.node.data + " ");
				tp.selfdone = true;
			}

			else if (tp.rightdone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightdone = true;

			} else {
				stack.removeFirst();
			}

		}
	}

	public void preorderR() {
		preorderR(this.root);
	}

	private void preorderR(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorderR(node.left);
		preorderR(node.right);
	}

	public void postorderR() {
		postorderR(this.root);
	}

	private void postorderR(Node node) {
		if (node == null) {
			return;
		}
		postorderR(node.left);
		postorderR(node.right);
		System.out.print(node.data + " ");
	}

	public void inorderR() {
		inorderR(this.root);
	}

	private void inorderR(Node node) {
		if (node == null) {
			return;
		}

		inorderR(node.left);
		System.out.print(node.data + " ");
		inorderR(node.right);
	}

	private class BSTPair {
		int size = 0;
		Node largestBSTNode = null;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isbst = true;
	}

	public void largestBST() {
		BSTPair bstpair = largestBST(this.root);
        System.out.println(bstpair.largestBSTNode.data);
		System.out.println(bstpair.size);
	}

	private BSTPair largestBST(Node node) {

		if (node == null) {
			return new BSTPair();
		}
		BSTPair left = largestBST(node.left);
		BSTPair right = largestBST(node.right);
		BSTPair mr = new BSTPair();

		mr.max = Math.max(node.data, Math.max(left.max, right.max));
		mr.min = Math.min(node.data, Math.min(left.min, right.min));

		if (left.isbst && right.isbst && node.data > left.max && node.data < right.min) {

			mr.largestBSTNode = node;
			mr.size = left.size + right.size + 1;
			mr.isbst = true;
		} else {
			mr.isbst = false;
			if (left.size > right.size) {
				mr.largestBSTNode = left.largestBSTNode;
				mr.size=left.size;
			} else {
				mr.largestBSTNode = right.largestBSTNode;
				mr.size=right.size;
			}

		}
		return mr;
	}

}
