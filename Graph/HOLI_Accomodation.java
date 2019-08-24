package Graph;

import java.util.*;

public class HOLI_Accomodation {

	static class Graph {
		private int V;
		private ArrayList list[];

		private class Pair {
			int node;
			int edgCost;

			Pair(int v, int cost) {
				this.node = v;
				this.edgCost = cost;
			}
		}

		public Graph(int v) {
			this.V = v;
			list = new ArrayList[v];

			for (int i = 0; i < v; i++) {
				list[i] = new ArrayList<Pair>();
			}
		}

		public void addEdge(int u, int v, int cost) {
			list[u].add(new Pair(v, cost));
			// Bidirectional
			list[v].add(new Pair(u, cost));
		}

		private class Heap {
			int ans;
		}

		private int dfsHelper(int node, boolean visited[], int[] count, Heap heap) {
			visited[node] = true;
			count[node] = 1;

			for (int i = 0; i < list[node].size(); i++) {
				Pair nbr = (Pair) list[node].get(i);
				if (!visited[nbr.node]) {
					count[node] += dfsHelper(nbr.node, visited, count, heap);
					int edgeCost = nbr.edgCost;
					int N = this.V;
					int s = count[nbr.node];
					heap.ans += 2 * Math.min(s, N - s) * edgeCost;
				}
			}

			return count[node];
		}

		public int dfs() {
			boolean visited[] = new boolean[this.V];
			int count[] = new int[this.V];

			Heap heap = new Heap();
			heap.ans = 0;
			dfsHelper(0, visited, count, heap);

//			for (int i = 0; i < this.V; i++) {
//				System.out.print(count[i] + " ");
//			}

			return heap.ans;
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1, 3);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 2);

		System.out.println(g.dfs());

	}

}
