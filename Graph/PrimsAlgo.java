package Graph;

import java.util.*;

public class PrimsAlgo {

	static class Pair {
		int vertex;
		int weight;

		public Pair(int v, int w) {
			this.vertex = v;
			this.weight = w;
		}
	}

	static class Graph {
		private int v;
		private ArrayList[] adj;

		Graph(int v) {
			this.v = v;
			adj = new ArrayList[v];
			for (int i = 0; i < this.v; i++) {
				adj[i] = new ArrayList<Pair>();
			}
		}

		public void addEdge(int u, int v, int weight) {
			adj[u].add(new Pair(v, weight));
			adj[v].add(new Pair(u, weight));
		}

		public void printGraph() {
			for (int i = 0; i < this.v; i++) {
				ArrayList<Pair> parent = adj[i];
				for (int j = 0; j < parent.size(); j++) {
					Pair p = parent.get(j);
					System.out.println(i + " --> " + p.vertex + " with weight: " + p.weight);
				}

			}
		}

		static int findMinVertex(boolean[] visited, int[] weight, int v) {
			int minVertex = -1;
			for (int i = 0; i < v; i++) {
				if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
					minVertex = i;
				}
			}
			return minVertex;
		}

		public void prims() {
			boolean visited[] = new boolean[this.v];
			int parent[] = new int[this.v];
			int weight[] = new int[this.v];

			for (int i = 0; i < this.v; i++) {
				visited[i] = false;
				weight[i] = Integer.MAX_VALUE;
			}
			parent[0] = -1;
			weight[0] = 0;
			for (int i = 0; i < this.v; i++) {
				int minVertex = findMinVertex(visited, weight, this.v);
				visited[minVertex] = true;
				ArrayList<Pair> plist = adj[minVertex];
				for (int j = 0; j < plist.size(); j++) {
					Pair p = plist.get(j);
					if (!visited[p.vertex] && weight[p.vertex] > p.weight) {
						parent[p.vertex] = minVertex;
						weight[p.vertex] = p.weight;
					}
				}
			}

			for (int i = 1; i < this.v; i++) {
				System.out.println(i + " --> " + parent[i] + " with weight: " + weight[i]);
			}
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1, 6);
		g.addEdge(0, 3, 2);
		g.addEdge(1, 2, 4);
		g.addEdge(2, 3, 8);
		g.addEdge(3, 4, 3);
		g.addEdge(4, 5, 4);
		g.addEdge(4, 6, 1);
		g.addEdge(5, 6, 2);
		g.prims();
	}

}
