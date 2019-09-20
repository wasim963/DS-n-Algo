import java.util.*;

public class BellmanFordAlgo {

	static class Edge {
		int src, dest, weight;
	}

	static class Graph {
		private int v, e;
		private Edge[] edge;

		Graph(int v, int e) {
			this.v = v;
			this.e = e;
			edge = new Edge[e];
			for (int i = 0; i < e; i++) {
				edge[i] = new Edge();
			}
		}

		void addEdge(int src, int dest, int weight, int count) {
			this.edge[count].src = src;
			this.edge[count].dest = dest;
			this.edge[count].weight = weight;
		}

		void BellmanFord(int src) {
			int distance[] = new int[this.v];
			for (int i = 0; i < this.v; i++) {
				distance[i] = Integer.MAX_VALUE;
			}
			distance[src] = 0;

			// Relaxation Code
			for (int i = 1; i <= this.v - 1; i++) {
				for (int j = 0; j < this.e; j++) {
					int srcNode = this.edge[j].src;
					int destNode = this.edge[j].dest;
					int weight = this.edge[j].weight;
					// Relaxation Check
					if (distance[srcNode] != Integer.MAX_VALUE && distance[srcNode] + weight < distance[destNode]) {
						distance[destNode] = distance[srcNode] + weight;
					}
				}
			}
			// Check For negative Weight Cycle
			for (int j = 0; j < this.e; j++) {
				int srcNode = this.edge[j].src;
				int destNode = this.edge[j].dest;
				int weight = this.edge[j].weight;
				// Relaxation Check
				if (distance[srcNode] != Integer.MAX_VALUE && distance[srcNode] + weight < distance[destNode]) {
					System.out.println("Graph has negtive weight Cycle !");
					return;
				}
			}
			//
			for (int i = 0; i < this.v; i++) {
				System.out.println(i + "   ->   " + distance[i]);
			}
		}
	}

	/*
	 * 5 8 0 1 -1 0 2 4 1 2 3 3 2 5 4 3 -3 1 4 2 1 3 2 3 1 1
	 */

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();
		Graph g = new Graph(v, e);
		for (int i = 0; i < e; i++) {
			int src = scn.nextInt();
			int dest = scn.nextInt();
			int w = scn.nextInt();
			g.addEdge(src, dest, w, i);
		}
		g.BellmanFord(0);
		scn.close();
	}

}
