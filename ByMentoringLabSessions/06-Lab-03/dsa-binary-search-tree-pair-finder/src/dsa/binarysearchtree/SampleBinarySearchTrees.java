package dsa.binarysearchtree;

public class SampleBinarySearchTrees {
	
	//BST
	//insert 70, 50, 90, 30, 60, 80, 100, 20, 40

    public static BinarySearchTree sampleBST_01() {
        
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.insert(70);
        tree.insert(50);
        tree.insert(90);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);
        tree.insert(100);
        tree.insert(20);
        tree.insert(40);
    
        return tree;				
    }

}
