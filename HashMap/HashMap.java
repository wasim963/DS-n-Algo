import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {

	private class HMNode {
		K key;
		V value;

		public HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<HMNode>[] bucketArray;
	private int size;

	public HashMap() {
		this(5);
	}

	public HashMap(int cap) {
		this.bucketArray = new LinkedList[cap];
		this.size = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<>();
		}
	}

	public int hashFunction(K key) {
		int hc = key.hashCode();
		int bi = Math.abs(hc) % this.bucketArray.length;
		return bi;
	}

	public void put(K key, V value) {
		int bi = hashFunction(key);
		LinkedList<HMNode> list = bucketArray[bi];
		int si = findInBucket(list, key);
		if (si == -1) {
			HMNode nn = new HMNode(key, value);
			list.add(nn);
			this.size++;
		} else {
			HMNode nn = list.get(si);
			nn.value = value;

		}
		double avg = (1.0) * this.size / this.bucketArray.length;
		if (avg > 2.0) {
			rehash();
		}

	}

	private void rehash() {
		LinkedList<HMNode>[] ob = this.bucketArray;
		this.bucketArray = new LinkedList[2 * ob.length];
		this.size = 0;
		for (int i = 0; i < this.bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<>();
		}
		for (int i = 0; i < ob.length; i++) {
			LinkedList<HMNode> bucket = ob[i];
			for (int j = 0; j < bucket.size(); j++) {
				HMNode node = bucket.get(j);
				this.put(node.key, node.value);
			}
		}

	}

	public void display() {

		for (int i = 0; i < bucketArray.length; i++) {
			LinkedList<HMNode> bucket = bucketArray[i];
			System.out.print("Bucket " + i + ": ");
			for (int j = 0; j < bucket.size(); j++) {
				System.out.print(bucket.get(j).key + " " + bucket.get(j).value + ", ");
			}
			System.out.println();
		}

	}

	public int findInBucket(LinkedList<HMNode> bucket, K ktbf) {
		for (int i = 0; i < bucket.size(); i++) {
			HMNode node = bucket.get(i);
			if (node.key.equals(ktbf)) {
				return i;
			}
		}
		return -1;
	}

	public V get(K key) {
		int bi = hashFunction(key);
		LinkedList<HMNode> list = bucketArray[bi];
		int si = findInBucket(list, key);
		if (si == -1) {
			return null;
		} else {
			HMNode nn = list.get(si);
			return nn.value;
		}
	}

	public boolean containsKey(K key) {
		int bi = hashFunction(key);
		LinkedList<HMNode> list = bucketArray[bi];
		int si = findInBucket(list, key);
		if (si == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V remove(K key) {
		int bi = hashFunction(key);
		LinkedList<HMNode> list = bucketArray[bi];
		int si = findInBucket(list, key);
		if (si == -1) {
			return null;
		} else {
			HMNode nn = list.remove(si);
			this.size--;
			return nn.value;
		}
	}

	public ArrayList<K> keySet() {
		ArrayList<K> arr = new ArrayList<>();
		for (int i = 0; i < bucketArray.length; i++) {
			LinkedList<HMNode> bucket = bucketArray[i];
			for (int j = 0; j < bucket.size(); j++) {

				arr.add(bucket.get(j).key);
			}
		}
		return arr;
	}

}
