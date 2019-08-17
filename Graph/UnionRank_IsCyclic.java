package Graph;

import java.util.Arrays;

public class UnionRank_IsCyclic {

	private static class Edge {
		int src, dst;
	}

	private static class Graph {
		int V, E;
		Edge edge[];
	}

	private static class Subset {
		int parent, rank;
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

	private static int find_parents(Subset[] subset, int i) {
		// find root and make root as parent of i (path compression)
		if (subset[i].parent != i)
			subset[i].parent = find_parents(subset, subset[i].parent);
		return subset[i].parent;
	}

	private static void Make_Union(Subset[] subset, int x, int y) {
		int x_set = find_parents(subset, x);
		int y_set = find_parents(subset, y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subset[x_set].rank < subset[y_set].rank) {
			subset[x_set].parent = y_set;
		} else if (subset[x_set].rank > subset[y_set].rank) {
			subset[y_set].parent = x_set;
		}
		// If ranks are same, then make one as root and increment
		// its rank by one
		else {
			subset[x_set].parent = y_set;
			subset[y_set].rank++;
		}

	}

	public static int isCyclic(Graph g) {
		Subset subset[] = new Subset[g.V];
		for (int i = 0; i < g.V; i++) {
			subset[i] = new Subset();
		}

		// initialize subset
		for (int v = 0; v < g.V; v++) {
			subset[v].parent = v;
		}

		for (int i = 0; i < g.E; i++) {

			int x = find_parents(subset, g.edge[i].src);
			int y = find_parents(subset, g.edge[i].dst);

			if (x == y)
				return 1;

			Make_Union(subset, x, y);
		}

		return 0;
	}

	public static void main(String[] args) {

		int V = 3, E = 3;
		Graph g = createGraph(V, E);

		// Edge (0 - 1)
		g.edge[0].src = 0;
		g.edge[0].dst = 1;

		// Edge (1 - 2)
		g.edge[1].src = 1;
		g.edge[1].dst = 2;

		// Edge (0 - 2)
		g.edge[2].src = 0;
		g.edge[2].dst = 2;

		// Edge (2 - 3)
		// g.edge[2].src = 2;
		// g.edge[2].dst = 3;

		if (isCyclic(g) == 1)
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");

	}

}
