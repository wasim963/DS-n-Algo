import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> table;

		private Node(char ch) {
			this.ch = ch;
			this.eow = false;
			this.table = new HashMap<>();
		}
	}

	private Node root;

	public Trie() {
		this.root = new Node('*');
	}

	public void addWord(String word) {
		addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			parent.eow = true;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = parent.table.get(ch);
		if (child == null) {
			child = new Node(ch);
			parent.table.put(ch, child);
			addWord(child, row);
		} else {
			addWord(child, row);
		}
	}

	public void displayWords() {
		displayWords(this.root, "");
	}

	private void displayWords(Node node, String str) {
		if (node.eow) {
			System.out.println(str);
		}
		ArrayList<Character> keys = new ArrayList<>(node.table.keySet());
		for (char key : keys) {
			displayWords(node.table.get(key), str + key);
		}
	}

	public void displayTrie() {
		displayTrie(this.root);
	}

	private void displayTrie(Node node) {
		String str = node.ch + " ->";
		ArrayList<Character> keys = new ArrayList<>(node.table.keySet());
		for (char key : keys) {
			str += " " + key + " ,";
		}
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		for (char key : keys) {
			displayTrie(node.table.get(key));
		}

	}

	public boolean searchWord(String word) {
		return searchWord(this.root, word);
	}

	private boolean searchWord(Node parent, String word) {
		if (word.length() == 0) {
			return parent.eow;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = parent.table.get(ch);
		if (child == null) {
			return false;
		} else {
			return searchWord(child, row);
		}
	}

	public void removeWord(String word) {
		removeWord(this.root, word);
	}

	private void removeWord(Node parent, String word) {
		if (word.length() == 0) {
			parent.eow = false;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		Node child = parent.table.get(ch);
		if (child == null) {
			return;
		} else {
			removeWord(child, row);
			if (child.eow == false && child.table.size() == 0) {
				parent.table.remove(ch);
			}
		}
	}

}
