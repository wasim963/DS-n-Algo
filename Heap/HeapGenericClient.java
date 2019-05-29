import java.util.ArrayList;

public class HeapGenericClient {

	public static void main(String[] args) {

		Car[] cars = new Car[5];
		cars[0] = new Car("D", 500, 5200);
		cars[1] = new Car("P", 900, 6100);
		cars[2] = new Car("C", 300, 4600);
		cars[3] = new Car("M", 100, 7200);
		cars[4] = new Car("W", 400, 3600);

		HeapGeneric<Car> heap = new HeapGeneric<>();

		heap.add(cars[0]);
		heap.add(cars[1]);
		heap.add(cars[2]);
		heap.add(cars[3]);
		heap.add(cars[4]);

		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());
		System.out.println(heap.remove());

		System.out.println("----------------------------------------");

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);
		list.get(0).add(40);
		list.get(1).add(2);
		list.get(1).add(3);
		list.get(1).add(5);
		list.get(2).add(6);
		list.get(2).add(15);
		list.get(2).add(23);
		list.get(3).add(1);
		list.get(3).add(2);
		list.get(3).add(3);

		System.out.println("List");
		System.out.println(list);

		System.out.println("-----------------------------------------");

		System.out.println("mergeKSortedList");
		System.out.println(mergeKSortedList(list));

		System.out.println("---------------------------------------");

		System.out.println("kLargest");
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(80);
		list1.add(200);
		list1.add(30);
		list1.add(10);
		list1.add(60);
		list1.add(110);
		list1.add(70);
		System.out.println(kLargest(list1, 3));

	}

	private static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int idxNo;

		public Pair(int data, int listNo, int idxNo) {
			this.data = data;
			this.listNo = listNo;
			this.idxNo = idxNo;
		}

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> list) {

		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Pair> heap = new HeapGeneric<>();
		for (int i = 0; i < list.size(); i++) {
			Pair np = new Pair(list.get(i).get(0), i, 0); 
			heap.add(np);
		}
		// System.out.println("Hello");
		// heap.display();
		// System.out.println("Bye");
		while (!heap.isEmpty()) {
			Pair rp = heap.remove();
			ans.add(rp.data);
			rp.idxNo++;
			if (rp.idxNo < list.get(rp.listNo).size()) {
				rp.data = list.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}
		}

		return ans;
	}

	public static ArrayList<Integer> kLargest(ArrayList<Integer> list, int k) {

		HeapGeneric<Integer> heap = new HeapGeneric<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i = 0; i < k; i++) {
			heap.add(list.get(i));
		}
		
		for (int i = k; i < list.size(); i++) {

			int existingElement = heap.get();
			if (list.get(i) > existingElement) {
				heap.remove();
				heap.add(list.get(i));
			}

		}

		while (!heap.isEmpty())
			ans.add(heap.remove());

		return ans;

	}

}
