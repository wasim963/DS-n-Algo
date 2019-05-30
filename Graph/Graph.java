import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {
		return this.vertices.size();
	}

	public int numEdge() {
		int ans = 0;
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		for (String key : keys) {
			ans += this.vertices.get(key).nbrs.size();
		}

		return ans / 2;
	}

	public boolean containsVertex(String vname) {
		return this.vertices.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		this.vertices.put(vname, vtx);

	}

	public void removeVertex(String vname) {

		Vertex vtx = this.vertices.get(vname);
		if (vtx == null) {
			return;
		}
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for (String key : nbrs) {
			Vertex v = this.vertices.get(key);
			v.nbrs.remove(vname);
		}
		this.vertices.remove(vname);
	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;
	}

	public void removeEdge(String vname1, String vname2) {
		if (!this.containsEdge(vname1, vname2))
			return;

		Vertex vtx1 = this.vertices.get(vname1);
		Vertex vtx2 = this.vertices.get(vname2);

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {

		System.out.println("--------------------------------------");

		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		for (String key : keys) {
			String str = "";
			str += key + " -> ";
			Vertex vtx = this.vertices.get(key);
			str += vtx.nbrs;
			System.out.println(str);
		}
		System.out.println("---------------------------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {
		
		processed.put(src, true);
		
		if (this.containsEdge(src, dst))
			return true;

		Vertex vtx = this.vertices.get(src);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed))
				return true;
		}

		return false;
	}

}
