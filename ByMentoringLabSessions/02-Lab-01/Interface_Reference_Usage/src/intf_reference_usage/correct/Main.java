package intf_reference_usage.correct;

import intf_reference_usage.BinaryTree;
import intf_reference_usage.GeneralTree;
import intf_reference_usage.ITree;

public class Main {

	public static void main(String[] args) {
		
		
		variation1();
	}
	
	// Proper coding
	
	static void variation1() {
	
		// visit nodes in binary tree
		
		ITree binaryTree  = new BinaryTree();
		TreeUtils.printTreeStructure(binaryTree);
		
		ITree generalTree = new GeneralTree();
		TreeUtils.printTreeStructure(generalTree);
		
		
	}


	static void variation2() {
		
		// visit nodes in binary tree
		
		ITree tree1  =  createSampleTee();
		TreeUtils.printTreeStructure(tree1);
		
		ITree tree2 = createSampleTee();
		TreeUtils.printTreeStructure(tree2);
		
	}
	
	static ITree createSampleTee() {
		
		ITree treeReference = null;
		// Based on user input
		
		String userInput = "GENERAL_TREE";
		
		if (userInput.equals("GENERAL_TREE")) {
			treeReference =  new GeneralTree();
		}else if (userInput.equals("BINARY_TREE")) {
			
			treeReference =  new BinaryTree();
		}
		return treeReference;
	}
	
}
