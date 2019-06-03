public class TrieClient {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("an");
		trie.addWord("ant");
		trie.addWord("and");
		trie.addWord("bee");
		trie.addWord("been");
		trie.addWord("bea");
		trie.displayWords();
		System.out.println();
		trie.displayTrie();
	//	System.out.println(trie.searchWord("bee"));
	//	trie.removeWord("bee");
	//	System.out.println(trie.searchWord("been"));
	//	trie.displayWords();

	}

}
