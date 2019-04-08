public class BTClient {

// 10 true 20 true 40 false false true 50 false false true 30 true 60 false false false
// 10 true 20 true 30 false false false false
// 10 true 20 true 30 true 40 false false false false true 50 false true 60 false false
// 30 true 10 true 5 false false true 20 false false true 50 true 40 false false true 60 false false
	public static void main(String[] args) {
		 BinaryTree bt = new BinaryTree();
		 bt.display();
		 System.out.println("----------------------------");
//		 System.out.println("Size : " + bt.size2());
//		 System.out.println("Max : " + bt.max());
//		 System.out.println("Find : " + bt.find(50));
//		 System.out.println("Height : " + bt.height());
		// System.out.println("Max Diameter: " + bt.diameter());
		// System.out.println("Max Diameter: " + bt.diameterPair());
		// System.out.println("Balanced: " + bt.isBalanced());
		// bt.preorderI();
		// bt.postorderI();
		// bt.inorderI();
		// System.out.println();
		// bt.preorderR(); 
		// bt.postorderR();
		// bt.inorderR();

//		 int[] pre = { 10, 20, 40, 50, 70, 80, 30, 60 };
//		 int[] in = { 40, 20, 70, 50, 80, 10, 60, 30 };
//		 BinaryTree bt=new BinaryTree(pre,in);
//		 bt.display();
//		 System.out.println("----------------------------");
		 
		 bt.largestBST();
	}

}
