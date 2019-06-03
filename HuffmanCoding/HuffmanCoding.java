import java.util.*;

import L25.HeapGeneric;

public class HuffmanCoding {

	private class Node implements Comparable<Node> {
		char ch;
		int cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return o.cost - this.cost;
		}
	}

	private HashMap<Character, String> Encoder = new HashMap<>();
	private HashMap<String, Character> Decoder = new HashMap<>();

	public HuffmanCoding2(String TrainingDataSet) {
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < TrainingDataSet.length(); i++) {
			char ch = TrainingDataSet.charAt(i);
			if (fmap.containsKey(ch)) {
				fmap.put(ch, fmap.get(ch) + 1);
			} else {
				fmap.put(ch, 1);
			}
		}

		ArrayList<Character> keys = new ArrayList<>(fmap.keySet());
		HeapGeneric2<Node> heap = new HeapGeneric2<>();
		for (char key : keys) {
			Node nn = new Node();
			nn.ch = key;
			nn.cost = fmap.get(key);

			heap.add(nn);
		}

		while (heap.size() != 1) {
			Node fn = heap.remove();
			Node sn = heap.remove();
			Node merged = new Node();
			merged.cost = fn.cost + sn.cost;
			merged.left = fn;
			merged.right = sn;
			heap.add(merged);
		}

		Node lastNode = heap.remove();
		fillEncoderDecoder(lastNode, "");
	}

	private void fillEncoderDecoder(Node node, String str) {
		if (node.left == null && node.right == null) {
			Encoder.put(node.ch, str);
			Decoder.put(str, node.ch);
			return;
		}
		fillEncoderDecoder(node.left, str + "0");
		fillEncoderDecoder(node.right, str + "1");
	}

	public String Encoding(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			ans += Encoder.get(str.charAt(i)) + ", ";
		}
		return ans;
	}

	public String Decoding(String str) {
		String ans = "";
		String key = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			key += ch;
			if (Decoder.containsKey(key)) {
				ans += Decoder.get(key);
				key = "";
			}
		}
		return ans;
	}
}
