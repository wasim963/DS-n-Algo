import java.util.*;

public class Dijkstra {

	static class Graph<T> {
		class Pair {
			T vertex;
			int weight;

			Pair(T v, int w) {
				this.vertex = v;
				this.weight = w;
			}
		}

		private int V;
		private HashMap<T, ArrayList<Pair>> map;

		Graph(int v) {
			this.V = v;
			map = new HashMap<>(v);
		}

		void addEdge(T u, T v, int w) {
			if (!map.containsKey(u)) {
				ArrayList<Pair> a = new ArrayList<>();
				a.add(new Pair(v, w));
				map.put(u, a);
			} else {
				map.get(u).add(new Pair(v, w));
			}

			if (!map.containsKey(v)) {
				ArrayList<Pair> a = new ArrayList<>();
				a.add(new Pair(u, w));
				map.put(v, a);
			} else {
				map.get(v).add(new Pair(u, w));
			}
		}

		void printAdj() {
			for (T key : map.keySet()) {
				System.out.print(key + " --> ");
				for (int i = 0; i < map.get(key).size(); i++) {
					Pair p = map.get(key).get(i);
					System.out.print("(" + p.vertex + " " + " w:" + p.weight + ") -> ");

				}
				System.out.println();
			}
		}

		class DistPair {
			int dist;
			T vertex;

			DistPair(int d, T v) {
				this.dist = d;
				this.vertex = v;
			}
		}

		public class DistComp implements Comparator<DistPair> {
			@Override
			public int compare(DistPair a, DistPair b) {
				return a.dist - b.dist;
			}

		}

		void dijkstraSSSP(T src) throws Exception {
			HashMap<T, Integer> dist = new HashMap<>();
			// Set All distances to Infinity
			for (T key : map.keySet()) {
				dist.put(key, Integer.MAX_VALUE);
			}
			dist.put(src, 0);

			// Make a set to find out the node with minimum distance
			TreeSet<DistPair> set = new TreeSet<>(new DistComp());
			set.add(new DistPair(0, src));

			while (!set.isEmpty()) {
				DistPair p = set.first();
				T node = p.vertex;
				int nodeDist = p.dist;
				set.remove(set.first());
				for (Pair nbr : map.get(node)) {
					if (nodeDist + nbr.weight < dist.get(nbr.vertex)) {
						T dest = nbr.vertex;
						DistPair dp = new DistPair(nbr.weight, dest);
						if (set.contains(dp)) {
							set.remove(dp);
						}
						// insert the new Pair
						dist.put(dest, nodeDist + nbr.weight);
						set.add(new DistPair(nodeDist + nbr.weight, dest));
					}
				}
			}
			// print the minimum distances to all nodes
			for (T key : dist.keySet()) {
				System.out.println(key + " -> " + dist.get(key));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Graph<Integer> g = new Graph<Integer>(5);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 2);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 4);
		g.addEdge(1, 4, 7);
//		g.printAdj();
//		System.out.println();
		g.dijkstraSSSP(1);
	}
}
