package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsCyclic_DFS_UDG {

	private static class Graph<T> {

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
			if (!bidir) {
				if (!adjList.containsKey(v)) {
					ArrayList<T> list = new ArrayList<>();
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

		private boolean isCyclicHelper(T node, HashMap<T, Boolean> visited, T parent) {

			visited.put(node, true);

			for (T nbr : adjList.get(node)) {
				if (!visited.containsKey(nbr)) {
					boolean cycleDetected = isCyclicHelper(nbr, visited, node);
					if (cycleDetected) {
						return true;
					}
				}
				// if this nbr is already visited
				else if (nbr != parent) {
					return true;
				}
			}

			return false;
		}

		public boolean isCyclic() {
			HashMap<T, Boolean> visited = new HashMap<>();

			for (T key : adjList.keySet()) {
				if (!visited.containsKey(key)) {
					boolean ans = isCyclicHelper(key, visited, key);
					if (ans)
						return true;
				}
			}
			return false;
		}

	}

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();

		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
//		g.addEdge(2, 4, true);
		g.addEdge(3, 4, true);

		System.out.println(g.isCyclic());
	}

}
