package Graph;

import java.util.*;

public class JourneyToMoonDFS {

	static class Graph {
		private int V;
		private ArrayList list[];

		public Graph(int v) {
			this.V = v;
			this.list = new ArrayList[v];

			for (int i = 0; i < v; i++) {
				list[i] = new ArrayList<>();
			}
		}

		public void addEdge(int u, int v) {
			list[u].add(v);
			list[v].add(u);
		}

		class Heap {
			int country_size;
		}

		private void dfsHelper(int node, boolean[] visited, Heap heap) {
			visited[node] = true;
			heap.country_size++;

			for (int i = 0; i < list[node].size(); i++) {
				int nbr = (int) list[node].get(i);
				if (!visited[nbr]) {
					dfsHelper(nbr, visited, heap);
				}
			}
		}

		public int dfsMoon() {
			boolean[] visited = new boolean[this.V];

			for (int i = 0; i < this.V; i++) {
				visited[i] = false;
			}

			// Total ways
			int n = this.V;
			int total_ways = (n) * (n - 1) / 2;
			for (int i = 0; i < this.V; i++) {
				if (visited[i] == false) {
					Heap heap = new Heap();
					heap.country_size = 0;
					dfsHelper(i, visited, heap);
					// System.out.println("Country size : " +
					// heap.country_size);
					int cs = heap.country_size;
					total_ways -= (cs) * (cs - 1) / 2;
				}
			}

			return total_ways;

		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(0, 4);
		System.out.println(g.dfsMoon());

	}

}
