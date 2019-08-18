package Graph;

import java.util.*;

public class KruskalsAlgo {

	static class Edge {
		int src;
		int dest;
		int weight;
	}

	static class Set {
		int parent;
		int rank;
	}

	private static int find_parent(Set set[], int i) {
		if (set[i].parent != i)
			set[i].parent = find_parent(set, set[i].parent);
		return set[i].parent;
	}

	private static void Make_Union(Set[] set, int x, int y) {
		int x_set = find_parent(set, x);
		int y_set = find_parent(set, y);

		if (set[x_set].rank < set[y_set].rank) {
			set[x_set].parent = y_set;
		} else if (set[x_set].rank > set[y_set].rank) {
			set[y_set].parent = x_set;
		} else {
			set[x_set].parent = y_set;
			set[y_set].rank++;
		}
	}

	static class SortByWeight implements Comparator<Edge> {
		@Override
		public int compare(Edge a, Edge b) {
			return a.weight - b.weight;
		}
	}

	public static void kruskals(Edge[] input, int V, int E) {
		Arrays.sort(input, new SortByWeight());
		Edge[] output = new Edge[V - 1];
		Set[] set = new Set[V];
		// Initialize output array
		for (int i = 0; i < output.length; i++) {
			output[i] = new Edge();
		}
		// Initialize set array
		for (int i = 0; i < set.length; i++) {
			set[i] = new Set();
		}
		//
		for (int i = 0; i < V; i++) {
			set[i].parent = i; // assign parent of each vertex to itself
			set[i].rank = 0;// Assign the rank initially as 0;
		}

		int counter = 0, i = 0;
		while (counter < V - 1) {
			Edge currEdge = input[i];// Edge with Minimum Weight
			int srcParent = find_parent(set, currEdge.src);// find parent of src
															// vertex
			int destParent = find_parent(set, currEdge.dest);// find parent of
																// dest vertex

			if (srcParent != destParent) {
				output[counter] = currEdge; // we will insert the edge in mst
				Make_Union(set, srcParent, destParent); // union of the two
														// parent in one set
				counter++;
			}
			i++;
		}

		// for (int v = 0; v < output.length; v++) {
		// System.out.println(output[v].src + " " + output[v].dest + " with
		// weight " + output[v].weight);
		// }
		int totalWeight = 0;
		for (int e = 0; e < output.length; e++) {
			totalWeight += output[e].weight;
		}
		System.out.println(totalWeight);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int V = scn.nextInt();
		int E = scn.nextInt();
		Edge input[] = new Edge[E];
		for (int i = 0; i < E; i++) {
			input[i] = new Edge();
		}

		for (int i = 0; i < E; i++) {
			input[i].src = scn.nextInt();
			input[i].dest = scn.nextInt();
			input[i].weight = scn.nextInt();
		}

		kruskals(input, V, E);
		scn.close();

		/*
		 * 7 8 0 3 4 0 1 6 1 2 5 3 2 7 3 4 2 4 5 4 5 6 1 4 6 3
		 */
	}

}
