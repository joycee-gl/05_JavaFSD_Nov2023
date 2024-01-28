package dsa.binarytree.lca;

public class SampleBinaryTrees {
	
	public static Node _7NodesSample() {
		
		Node _40 = new Node("40");
		Node _50 = new Node("50");
		
		Node _20 = new Node("20");
		_20.setLeft(_40);
		_20.setRight(_50);
		
		Node _60 = new Node("60");
		Node _70 = new Node("70");
		
		Node _30 = new Node("30");
		_30.setLeft(_60);
		_30.setRight(_70);
		
		Node _10 = new Node("10");
		_10.setLeft(_20);
		_10.setRight(_30);
		
		Node rootNode = _10;
		
		return rootNode;
		
	}
	
	public static BinaryTree _7NodeSampleTree() {
		
		Node root = _7NodesSample();
		
		BinaryTree tree = new BinaryTree(root);
		return tree;
		
	}

}
