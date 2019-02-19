public class Stack {

	protected int tos;
	protected int[] data;

	public Stack() {
		this(5);
	}

	public Stack(int cap) {
		this.tos = -1;
		this.data = new int[cap];
	}

	public void push(int item) {
		if (this.size() == this.data.length) {
			int[] os = this.data;
			int[] ns = new int[2 * os.length];
			for (int i = 0; i < os.length; i++)
				ns[i] = os[i];
			this.data = ns;
		}
		this.tos++;
		this.data[this.tos] = item;
	}

	public int pop() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is Empty.");
		}
		int rv = this.data[this.tos];
		this.data[this.tos] = 0;
		this.tos--;
		return rv;
	}

	public int top() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Stack is Empty.");
		}
		int rv = this.data[this.tos];
		return rv;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		for (int i = this.tos; i >= 0; i--) {
			System.out.print(this.data[i] + " ");
		}
	}

}
