package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TopoLogicalSort_DFS {

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

		private class Heap {
			HashMap<T, Boolean> visited = new HashMap<>();
			LinkedList<T> ordering = new LinkedList<>();
		}

		private void dfsHelper(T src, Heap heap) {
			heap.visited.put(src, true);
			// System.out.print(src + ", ");

			for (T nbr : adjList.get(src)) {
				if (nbr == null) {
					break;
				} else {
					if (!heap.visited.containsKey(nbr)) {
						dfsHelper(nbr, heap);
					}
				}

			}
			heap.ordering.addFirst(src);
		}

		public void dfsTopologicalSort() {

			Heap heap = new Heap();

			for(T key : adjList.keySet()) {
				if(!heap.visited.containsKey(key)) {
					dfsHelper(key, heap);
				}
			}
			// print all the elements
			for (T element : heap.ordering) {
				System.out.print(element + "-->");
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
		
		 g2.dfsTopologicalSort();
		
//		Graph<Integer> g = new Graph<>();
//		g.addEdge(1, 2, false);
//		g.addEdge(1, 3, false);
//		g.addEdge(2, 4, false);
//		g.addEdge(3, 4, false);
//
//		g.dfsTopologicalSort(1);

	}

}
