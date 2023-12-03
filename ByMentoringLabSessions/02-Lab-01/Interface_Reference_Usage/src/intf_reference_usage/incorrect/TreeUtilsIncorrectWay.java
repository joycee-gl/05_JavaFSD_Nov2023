package intf_reference_usage.incorrect;

import intf_reference_usage.BinaryTree;
import intf_reference_usage.GeneralTree;

public class TreeUtilsIncorrectWay {

	static void printTreeStructure(GeneralTree tree) {
		
		System.out.println("Printing all the nodes in the general tree");
	}

	static void printTreeStructure(BinaryTree tree) {
		
		System.out.println("Printing all the nodes in the binary tree");
	}
	
}
