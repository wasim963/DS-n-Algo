public class Queue {
	protected int front;
	private int size;
	protected int[] data;

	public Queue() {
		this(5);
	}

	public Queue(int cap) {
		this.front = 0;
		this.size = 0;
		this.data = new int[cap];
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
	             int[] oq = this.data;
    		     int[] nq = new int[2*oq.length];
    		     for(int i=0;i<oq.length;i++){
    			  int index= (i+this.front)%this.data.length;
    			  nq[i] = oq[index];
    		      }
    		      this.front=0;
    		      this.data = nq;
		}
		int ni = (this.front + this.size) % this.data.length;
		this.data[ni] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty.");
		}
		int rv = this.data[this.front];
		this.data[this.front] = 0;
		this.size--;
		this.front = (this.front + 1) % this.data.length;
		return rv;
	}

	public int getFirst() throws Exception {
		if (this.size() == 0) {
			throw new Exception("Queue is Empty.");
		}
		int rv = this.data[this.front];
		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			int idx = (i + this.front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
	}

}
