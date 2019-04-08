public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}
		int mid = (ilo + ihi) / 2;
		Node nn = new Node();
		this.size++;
		nn.data = in[mid];
		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);
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
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(node.right, item);
		} else if (node.data > item) {
			return find(node.left, item);
		} else {
			return true;
		}
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

	public void printInRange(int ll, int ul) {
		printInRange(this.root, ll, ul);
	}

	private void printInRange(Node node, int ll, int ul) {

		if (node == null) {
			return;
		}

		if (node.data < ll) {
			printInRange(node.right, ll, ul);
		} else if (node.data > ul) {
			printInRange(node.left, ll, ul);
		} else {
			printInRange(node.left, ll, ul);
			System.out.print(node.data + " ");
			printInRange(node.right, ll, ul);
		}

	}

	public void printDec() {
		printDec(this.root);
	}

	private void printDec(Node node) {
		if (node == null) {
			return;
		}
		printDec(node.right);
		System.out.print(node.data + " ");
		printDec(node.left);

	}

	private class HeapMover {
		int sum = 0;
	}

	public void replaceWithSumLarger() {
		HeapMover mover = new HeapMover();
		replaceWithSumLarger(this.root, mover);
	}

	private void replaceWithSumLarger(Node node, HeapMover mover) {
		if (node == null) {
			return;
		}
		replaceWithSumLarger(node.right, mover);
		int val = node.data;
		node.data = mover.sum;
		mover.sum += val;
		replaceWithSumLarger(node.left, mover);

	}

	public void addNode(int item) {
		addNode(this.root, item);
	}

	private void addNode(Node node, int item) {

		if (item > node.data && node.right != null) {
			addNode(node.right, item);
		} else if (item < node.data && node.left != null) {
			addNode(node.left, item);
		} else if (item > node.data && node.right == null) {
			Node nn = new Node();
			nn.data = item;
			node.right = nn;
		} else if (item < node.data && node.left == null) {
			Node nn = new Node();
			nn.data = item;
			node.left = nn;
		}

	}

	public void add(int item) {
		if (this.root == null) {
			Node nn = new Node();
			nn.data = item;
			this.root = nn;
		} else {
			add(null, this.root, false, item);
		}
	}

	private void add(Node parent, Node child, boolean ilc, int item) {

		if (child == null) {
			if (ilc) {
				Node nn = new Node();
				nn.data = item;
				parent.left = nn;
			} else {
				Node nn = new Node();
				nn.data = item;
				parent.right = nn;
			}
			return;
		}
		if (item < child.data) {
			add(child, child.left, true, item);
		} else {
			add(child, child.right, false, item);
		}

	}

	public void delete(int item) {
		if (item == this.root.data) {
			if (this.root.left == null & this.root.right == null) {
				this.root = null;
			} else if (this.root.left != null & this.root.right == null) {
				this.root = this.root.left;
			} else if (this.root.left == null & this.root.right != null) {
				this.root = this.root.right;
			} else {
				delete(null, this.root, false, item);
			}
		} else {
			delete(null, this.root, false, item);
		}
	}

	private void delete(Node parent, Node child, boolean ilc, int item) {

		if (item < child.data) {
			delete(child, child.left, true, item);
		} else if (item > child.data) {
			delete(child, child.right, false, item);
		} else {
			if (child.left == null & child.right == null) {
				if (ilc) {
					parent.left = null;

				} else {
					parent.right = null;
				}
			} else if (child.left != null && child.right == null) {

				if (ilc) {
					parent.left = child.left;

				} else {
					parent.right = child.left;
				}
			} else if (child.left == null && child.right != null) {
				if (ilc) {
					parent.left = child.right;

				} else {
					parent.right = child.right;
				}
			} else {
				int max = max(child.left);
				child.data = max;
				delete(child, child.left, true, max);

			}
		}

	}
}
