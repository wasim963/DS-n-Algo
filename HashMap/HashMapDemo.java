import java.util.ArrayList;

public class HashMapDemo {

	public static void main(String[] args) {

		java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

		// put
		map.put("India", 100);
		map.put("US", 50);

		System.out.println(map);
		map.put("US", 230);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("USA"));

		// contains key
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("USA"));

		// remove

		// System.out.println(map.remove("India"));
		System.out.println(map);
		System.out.println(map.remove("USA"));
		System.out.println(map);

		// key set
		System.out.println(map.keySet());

		ArrayList<String> list = new ArrayList<>(map.keySet());
		for (String val : list) {
			System.out.println(val);
		}
		System.out.println(map.size());

		System.out.println("-----------------------------");
		// Intersection of two Arrays
		int[] arr1 = { 1, 2, 3, 0, 1, 7, 8, 1, 2, 7, 7 };
		int[] arr2 = { 1, 1, 2, 2, 2, 3, 3 };
		System.out.println(intersection(arr1, arr2));

		System.out.println("-----------------------------");
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		System.out.println(longestSequence(arr));

	}

	public static ArrayList<Integer> intersection(int[] a1, int[] a2) {

		HashMap<Integer, Integer> map = new HashMap<>();

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < a1.length; i++) {

			if (map.containsKey(a1[i])) {
				int of = map.get(a1[i]);
				int nf = of + 1;
				map.put(a1[i], nf);
			} else {
				map.put(a1[i], 1);
			}
		}

		for (int j = 0; j < a2.length; j++) {

			if (map.containsKey(a2[j]) && map.get(a2[j]) > 0) {

				// answer add
				ans.add(a2[j]);

				// frequency decrease put
				int of = map.get(a2[j]);
				int nf = of - 1;
				map.put(a2[j], nf);
			}
		}

		return ans;
	}

	public static ArrayList<Integer> longestSequence(int[] arr) {

		java.util.HashMap<Integer, Boolean> map = new java.util.HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}
			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}
		}
		
	//	System.out.println(map.entrySet());
		
		int mcount = Integer.MIN_VALUE;
		int startseq = -1;
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		ArrayList<Integer> ans = new ArrayList<>();
		for (Integer key : list) {
			if (map.get(key)) {
				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}
				if (count > mcount) {
					mcount = count;
					startseq = key;
				}

			}
		}
		for (int i = 0; i < mcount; i++) {
			ans.add(startseq + i);
		}
		return ans;
	}

}
