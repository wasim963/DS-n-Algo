package Adapters;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> ps = new Stack<>();

	public void enqueue(int item) {
		ps.push(item);
	}

	public int dequeue() {
		int val = 0;
		Stack<Integer> ns = new Stack<>();
		try {
			while (ps.size() > 1) {
				ns.push(ps.pop());
			}
			val = ps.pop();
			while (!ns.isEmpty()) {
				ps.push(ns.pop());
			}
		} catch (Exception e) {
			System.out.println("Queue is Emtpy!!!");
		}
		return val;
	}

	public int getFirst() {
		int val = 0;
		Stack<Integer> ns = new Stack<>();
		try {
			while (ps.size() > 1) {
				ns.push(ps.pop());
			}
			val = ps.pop();
			ns.push(val);
			while (!ns.isEmpty()) {
				ps.push(ns.pop());
			}
		} catch (Exception e) {
			System.out.println("Queue is Emtpy!!!");
		}
		return val;
	}

	public void display() {
		if (ps.isEmpty()) {
			return;
		}
		int temp = ps.pop();
		display();
		System.out.print(temp + " ");
		ps.push(temp);
	}

}
