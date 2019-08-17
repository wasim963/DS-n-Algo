package Graph;

import java.util.Arrays;

public class UnionFind_IsCyclic {

	private static class Edge {
		int src, dst;
	}

	private static class Graph {
		int V, E;
		Edge edge[];
	}

	public static Graph createGraph(int V, int E) {
		Graph g = new Graph();
		g.V = V;
		g.E = E;
		g.edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			g.edge[i] = new Edge();
		}
		return g;
	}

	private static int find_parents(int[] parent, int i) {
		if (parent[i] == -1)
			return i;
		return find_parents(parent, parent[i]);
	}

	private static void Make_Union(int[] parent, int x, int y) {

		int x_set = find_parents(parent, x);
		int y_set = find_parents(parent, y);

		parent[x_set] = y_set;
	}

	public static int isCyclic(Graph g) {
		int parent[] = new int[g.V];

		// initialize parents to -1
		Arrays.fill(parent, -1);

		// Iterate through all edges of graph, find subset of both
		// vertices of every edge, if both subsets are same, then
		// there is cycle in graph.
		for (int i = 0; i < g.E; i++) {

			int x = find_parents(parent, g.edge[i].src);
			int y = find_parents(parent, g.edge[i].dst);

			if (x == y)
				return 1;

			Make_Union(parent, x, y);
		}

		return 0;
	}

	public static void main(String[] args) {

		int V = 4, E = 3;
		Graph g = createGraph(V, E);

		// Edge (0 - 1)
		g.edge[0].src = 0;
		g.edge[0].dst = 1;

		// Edge (1 - 2)
		g.edge[1].src = 1;
		g.edge[1].dst = 2;

		// Edge (0 - 2)
		// g.edge[2].src = 0;
		// g.edge[2].dst = 2;

		// Edge (2 - 3)
		g.edge[2].src = 2;
		g.edge[2].dst = 3;

		if (isCyclic(g) == 1)
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");

	}

}
