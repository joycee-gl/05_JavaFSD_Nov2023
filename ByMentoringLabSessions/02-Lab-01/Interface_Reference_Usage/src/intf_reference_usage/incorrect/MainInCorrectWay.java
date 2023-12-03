package intf_reference_usage.incorrect;

import intf_reference_usage.BinaryTree;
import intf_reference_usage.GeneralTree;
import intf_reference_usage.ITree;
import intf_reference_usage.correct.TreeUtils;

public class MainInCorrectWay {

	public static void main(String[] args) {
		
		
		variation1();
	}
	
	// Proper coding
	
	static void variation1() {
	
		// visit nodes in binary tree
		
		GeneralTree tree1  = new GeneralTree();
		TreeUtilsIncorrectWay.printTreeStructure(tree1);
		
		BinaryTree tree2 = new BinaryTree();
		TreeUtilsIncorrectWay.printTreeStructure(tree2);
		
		
	}


	static void variation2() {
		
		// visit nodes in binary tree
		
		GeneralTree tree1  =  createSampleGeneralTee();
		TreeUtilsIncorrectWay.printTreeStructure(tree1);
		
		BinaryTree tree2 = createSampleBinaryTee();
		TreeUtilsIncorrectWay.printTreeStructure(tree2);
		
	}
	
	static GeneralTree createSampleGeneralTee() {
		
		GeneralTree generalTree = null;
		// Based on user input
		
		String userInput = "GENERAL_TREE";
		
		if (userInput.equals("GENERAL_TREE")) {
			generalTree =  new GeneralTree();
		}
		return generalTree;
	}
	
	static BinaryTree createSampleBinaryTee() {
		
		BinaryTree binaryTree = null;
		// Based on user input
		
		String userInput = "BINARY_TREE";
		
		if (userInput.equals("BINARY_TREE")) {
			binaryTree =  new BinaryTree();
		}
		return binaryTree;
	}	
}
