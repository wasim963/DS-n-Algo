package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class IsCyclic_BFS_UDG {

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

		public boolean isCyclic(T src) {
			HashMap<T, Boolean> visited = new HashMap<>();
			HashMap<T, T> parent = new HashMap<>();
			Queue<T> q = new LinkedList<>();

			visited.put(src, true);
			parent.put(src, src);
			q.add(src);

			while (!q.isEmpty()) {
				T node = q.poll();

				for (T nbr : adjList.get(node)) {
					if (visited.containsKey(nbr) && parent.get(node) != nbr) {
						return true;
					} else if (!visited.containsKey(nbr)) {
						visited.put(nbr, true);
						parent.put(nbr, node);
						q.add(nbr);
					}
				}
			}
			return false;
		}

	}

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();

		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(2, 4, true);
		g.addEdge(3, 4, true);

		System.out.println(g.isCyclic(1));
	}

}
