package Graph;

import java.util.*;

public class AdjList_Generic {

	static class Graph<T> {

		private HashMap<T, ArrayList<T>> adjList;

		Graph() {
			adjList = new HashMap<>();
		}

		public void addEdge(T u, T v, boolean bidir) {
			if (adjList.containsKey(u)) {
				adjList.get(u).add(v);
			} else {
				ArrayList<T> list = new ArrayList<>();
				list.add(v);
				adjList.put(u, list);
			}
			if (bidir) {
				if (adjList.containsKey(v)) {
					adjList.get(v).add(u);
				} else {
					ArrayList<T> list = new ArrayList<>();
					list.add(u);
					adjList.put(v, list);
				}
			}
		}

		public void printAdjList() {

			for (T key : adjList.keySet()) {
				System.out.print(key + " -> ");
				ArrayList<T> nbrs = adjList.get(key);
				for (T nbr : nbrs) {
					System.out.print(nbr + ", ");
				}
				System.out.println();
			}

		}

	}

	public static void main(String[] args) {
		Graph<String> g = new Graph<String>();
		g.addEdge("Wasim", "Shayan", true);
		g.addEdge("Nayab", "Izhar", true);
		g.addEdge("Khalid", "Wasim", true);
		g.addEdge("Khalid", "Shayan", false);
		g.addEdge("Izhar", "Khalid", false);
		g.printAdjList();
		System.out.println("--------------------------------");
		
		Graph<Integer> g2 = new Graph<Integer>();
		g2.addEdge(1, 2, true);
		g2.addEdge(100, 2, true);
		g2.addEdge(100, 3, true);
		g2.printAdjList();
	}

}
