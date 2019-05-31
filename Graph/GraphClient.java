import java.util.HashMap;

public class GraphClient {

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 10);
		graph.addEdge("B", "C", 2);
		graph.addEdge("C", "D", 3);
		graph.addEdge("D", "E", 4);
		graph.addEdge("E", "F", 5);
		graph.addEdge("E", "G", 12);
		graph.addEdge("F", "G", 4);
		graph.display();

		System.out.println(graph.containsVertex("G"));
		System.out.println("numVertex: " + graph.numVertex());
		System.out.println("numEdge: " + graph.numEdge());

		// graph.removeVertex("D");
		System.out.println("containsEdge: " + graph.containsEdge("A", "B"));
		graph.removeEdge("A", "B");
		System.out.println("containsEdge: " + graph.containsEdge("A", "B"));

		// graph.removeEdge("D", "E");
		// graph.removeEdge("F", "G");
		System.out.println("hasPath: " + graph.hasPath("A", "G", new HashMap<>()));

		graph.display();

		System.out.println(graph.bfs("C", "F"));
		System.out.println(graph.dfs("C", "F"));
	}

}
