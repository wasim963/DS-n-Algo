package Graph;

import java.util.*;

class Graph {
	int V;
	// Array of Arraylist
	ArrayList list[];

	Graph(int v) {
		V = v;
		list = new ArrayList[v];
		
		// Array of linked list;
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int u, int v, boolean bidir) {
		list[u].add(v);
		if (bidir) {
			list[v].add(u);
		}
	}

	public void printAdjList() {

		for (int i = 0; i < V; i++) {
			System.out.print(i + " -> ");

			for (int j = 0; j < list[i].size(); j++) {
				System.out.print(list[i].get(j) + ", ");
			}

			System.out.println();
		}
	}

}

public class AdjList_IntTypeNode {

	public static void main(String[] args) {
		Graph g = new Graph(5);
//		g.addEdge(0, 1, true);
//		g.addEdge(0, 4, true);
//		g.addEdge(4, 3, true);
//		g.addEdge(1, 4, true);
//		g.addEdge(1, 2, true);
//		g.addEdge(2, 3, true);
		
		g.addEdge(0, 1, true);
		g.addEdge(2, 3, true);
		g.addEdge(0, 4, true);

		g.printAdjList();
	}

}
