import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS {

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

		public void bfsTopologicalSort() {
			Queue<T> q = new LinkedList<>();
			HashMap<T, Boolean> visited = new HashMap<>();
			HashMap<T, Integer> indegree = new HashMap<>();

			for (T key : adjList.keySet()) {
				visited.put(key, false);
				indegree.put(key, 0);
			}

			// init the indegree for the nodes;
			for (T key : adjList.keySet()) {
				for (T nbr : adjList.get(key)) {
					indegree.put(nbr, indegree.get(nbr) + 1);
				}
			}

			// find out all nodes with indegree 0
			for (T node : adjList.keySet()) {
				if (indegree.get(node) == 0) {
					q.add(node);
				}
			}

			// Start with Algo
			while (!q.isEmpty()) {
				T node = q.poll();
				System.out.print(node + "-->");
				for (T nbr : adjList.get(node)) {
					indegree.put(nbr, indegree.get(nbr) - 1);

					if (indegree.get(nbr) == 0) {
						q.add(nbr);
					}
				}
			}

		}

	}

	public static void main(String[] args) {
		Graph<String> g2 = new Graph<>();

		g2.addEdge("Eng", "PL", false);
		g2.addEdge("Math", "PL", false);
		g2.addEdge("PL", "HTML", false);
		g2.addEdge("PL", "Python", false);
		g2.addEdge("PL", "Java", false);
		g2.addEdge("PL", "JS", false);
		g2.addEdge("Python", "WebDev", false);
		g2.addEdge("HTML", "CSS", false);
		g2.addEdge("CSS", "JS", false);
		g2.addEdge("JS", "WebDev", false);
		g2.addEdge("Java", "WebDev", false);
		g2.addEdge("Python", "WebDev", false);

		g2.bfsTopologicalSort();

	}

}
