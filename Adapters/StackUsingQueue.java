package Adapters;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> pq = new LinkedList<>();

	public void push(int item) {
		pq.add(item);
	}

	public int pop() {
		int val = 0;
		Queue<Integer> nq = new LinkedList<>();
		try {
			while (pq.size() > 1) {
				nq.add(pq.remove());
			}
			val = pq.remove();
			pq = nq;
		} catch (Exception e) {
			System.out.println("Stack is empty!!!");
		}
		return val;
	}

	public int top() {
		int val = 0;
		Queue<Integer> nq = new LinkedList<>();
		try {
			while (pq.size() > 1) {
				nq.add(pq.remove());
			}
			val = pq.remove();
			nq.add(val);
			pq = nq;
		} catch (Exception e) {
			System.out.println("Stack is empty!!!");
		}
		return val;
	}

	public void display() {
		displayH(0);
	}

	private void displayH(int count) {
		if (count == pq.size()) {
			return;
		}
		int temp = pq.remove();
		pq.add(temp);
		displayH(count + 1);
		System.out.print(temp + " ");
	}

}
