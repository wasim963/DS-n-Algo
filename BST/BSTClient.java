public class BSTClient {

	public static void main(String[] args) {
		int[] in = { 5, 10, 11, 12, 15, 30, 40 };
//		int[] in = {};
		BST bst = new BST(in);
		bst.display();
		System.out.println("------------------------------");
//		System.out.println("Size: " + bst.size2());
//		System.out.println("Max: " + bst.max());
//		System.out.println("Height: " + bst.height());
//		System.out.println("Find: " + bst.find(50));
//		System.out.println("-------------------------------");
//		bst.printInRange(10, 25);
//		bst.printDec();
//		bst.replaceWithSumLarger();
//	    bst.display();
//		bst.addNode(20);
//		bst.display();
		bst.delete(10);
//		System.out.println("------------------------------");
//		 bst.add(20);
		 bst.display();

	}
}
