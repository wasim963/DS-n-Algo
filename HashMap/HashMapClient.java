public class HashMapClient {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>(2);
		map.put("India", 100);
		map.put("USA", 120);
		map.put("SL", 756);
		map.put("Bihar", 921);
		map.put("China", 921); // Unique key but value may be redundant
		map.display();
		map.put("UAE", 111);
		System.out.println(map.remove("SL"));
		map.display();
		System.out.println(map.keySet());
		System.out.println(map.containsKey("UAE"));
		System.out.println(map.get("Bihar"));

	}

}
