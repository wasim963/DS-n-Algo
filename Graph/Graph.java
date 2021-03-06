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

	private class Pair {
		String vname;
		String psf;
		Vertex vtx;
		String color;

		public Pair(String vname, String psf, Vertex vtx) {
			this.vname = vname;
			this.psf = psf;
			this.vtx = vtx;

		}

		public Pair(String vname, String psf, Vertex vtx, String color) {
			this.vname = vname;
			this.psf = psf;
			this.vtx = vtx;
			this.color = color;

		}
	}

	public boolean bfs(String src, String dst) {
		if (containsEdge(src, dst)) {
			return true;
		}
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair np = new Pair(src, src, vertices.get(src));
		queue.addLast(np);
		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);
			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbr : nbrs) {
				Vertex vtx = vertices.get(nbr);
				Pair nbPair = new Pair(nbr, rp.psf + nbr, vtx);
				if (!processed.containsKey(nbr)) {
					queue.addLast(nbPair);
				}
			}

		}
		return false;
	}

	public boolean dfs(String src, String dst) {
		if (containsEdge(src, dst)) {
			return true;
		}
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair np = new Pair(src, src, vertices.get(src));
		stack.addFirst(np);
		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
			for (String nbr : nbrs) {
				Vertex vtx = vertices.get(nbr);
				Pair nbPair = new Pair(nbr, rp.psf + nbr, vtx);
				if (!processed.containsKey(nbr)) {
					stack.addFirst(nbPair);
				}
			}

		}
		return false;
	}

	public void bft() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

		for (String key : keys) {

			Pair np = new Pair(key, key, this.vertices.get(key));
			if (processed.containsKey(key))
				continue;

			queue.addLast(np);
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				System.out.println(rp.vname + " via " + rp.psf);
				processed.put(rp.vname, true);

				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					Vertex vtx = vertices.get(nbr);
					Pair nbpair = new Pair(nbr, rp.psf + nbr, vtx);
					if (!processed.containsKey(nbr)) {
						queue.addLast(nbpair);
					}
				}

			}
		}

	}

	public void dft() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

		for (String key : keys) {

			Pair np = new Pair(key, key, this.vertices.get(key));
			if (processed.containsKey(key))
				continue;

			stack.addFirst(np);
			while (!stack.isEmpty()) {

				Pair rp = stack.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				System.out.println(rp.vname + " via " + rp.psf);
				processed.put(rp.vname, true);

				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					Vertex vtx = vertices.get(nbr);
					Pair nbpair = new Pair(nbr, rp.psf + nbr, vtx);
					if (!processed.containsKey(nbr)) {
						stack.addFirst(nbpair);
					}
				}

			}
		}

	}

	public ArrayList<ArrayList<String>> getConnectedComp() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();

		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		for (String key : keys) {
			Pair np = new Pair(key, key, this.vertices.get(key));
			if (processed.containsKey(key))
				continue;

			queue.addLast(np);
			ArrayList<String> subans = new ArrayList<>();
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				subans.add(rp.vname);
				processed.put(rp.vname, true);
				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					Vertex vtx = vertices.get(nbr);
					Pair nbpair = new Pair(nbr, rp.psf + nbr, vtx);
					if (!processed.containsKey(nbr)) {
						queue.addLast(nbpair);
					}
				}
			}
			ans.add(subans);
		}
		return ans;
	}

	public boolean isConnected() {

		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		int flag = 0;
		for (String key : keys) {
			Pair np = new Pair(key, key, this.vertices.get(key));
			if (processed.containsKey(key))
				continue;
			if (flag == 1) {
				return false;
			}
			queue.addLast(np);
			flag = 1;
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);
				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					Vertex vtx = vertices.get(nbr);
					Pair nbpair = new Pair(nbr, rp.psf + nbr, vtx);
					if (!processed.containsKey(nbr)) {
						queue.addLast(nbpair);
					}
				}
			}
		}
		return true;
	}

	public boolean isCyclic() {
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		HashMap<String, Boolean> processed = new HashMap<>();
		for (String key : keys) {
			Pair np = new Pair(key, key, vertices.get(key));
			if (processed.containsKey(key)) {
				continue;
			}
			queue.addLast(np);
			while (!queue.isEmpty()) {

				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				processed.put(rp.vname, true);

				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					Vertex vtx = vertices.get(nbr);
					Pair nbPair = new Pair(nbr, rp.psf + nbr, vtx);
					if (!processed.containsKey(nbr)) {
						queue.addLast(nbPair);
					}
				}
			}
		}

		return false;
	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public boolean isBipartite() {
		HashMap<String, String> processed = new HashMap<>();
		ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());
		LinkedList<Pair> queue = new LinkedList<>();
		for (String key : keys) {
			Pair np = new Pair(key, key, vertices.get(key), "r");
			if (processed.containsKey(key)) {
				continue;
			}
			queue.addLast(np);
			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				if (processed.containsKey(rp.vname)) {
					String oc = processed.get(rp.vname);
					String nc = rp.color;
					if (!oc.equals(nc)) {
						return false;
					}
					continue;
				}
				processed.put(rp.vname, rp.color);
				ArrayList<String> nbrs = new ArrayList<>(rp.vtx.nbrs.keySet());
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Vertex vtx = this.vertices.get(nbr);
						String color = rp.color.equals("r") ? "g" : "r";
						Pair nbPair = new Pair(nbr, rp.psf + nbr, vtx, color);
						queue.addLast(nbPair);
					}
				}
			}
		}
		return true;
	}

}
