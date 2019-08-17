package Graph;

import java.util.*;

public class Bipartite_Graph {

	private static class Graph {
		private int V;
		private ArrayList<Integer>[] list;

		Graph(int v) {
			this.V = v;
			this.list = new ArrayList[v];

			for (int i = 0; i < v; i++) {
				list[i] = new ArrayList<Integer>();
			}
		}

		public void addEgde(int u, int v) {
			list[u].add(v);
			list[v].add(u);
		}

		public boolean isBaipartite(int s) {
			int colors[] = new int[this.V];
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < this.V; i++) {
				colors[i] = -1; // Not Visited
			}

			q.add(s);
			colors[s] = 0;
			boolean ans = true;

			while (!q.isEmpty() && ans) {
				int u = q.poll();
				for (int i = 0; i < list[u].size(); i++) {
					int v = list[u].get(i);
					if (colors[v] == -1) {
						colors[v] = 1 - colors[u];
						q.add(v);
					}
					// visited and nbr has same colour as of parent;
					else if(colors[v] == colors[u]) {
						ans = false;
						break;
					}
				}
			}

			return ans;
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEgde(0, 1);
		g.addEgde(1, 3);
		g.addEgde(0, 2);
		g.addEgde(2, 3);
		g.addEgde(0, 3);

		System.out.println(g.isBaipartite(0));
	}

}
