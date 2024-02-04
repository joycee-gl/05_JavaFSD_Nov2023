package dsa.binarysearchtree;

import java.util.Set;

public class PreOrderTraversalOperationTest {

	public static void main(String[] args) {
		
		
		test01();		
	}

	static void test01() {
		
		BinarySearchTree binarySearchTree = 
				SampleBinarySearchTrees.sampleBST_01();
			
		PreOrderTraversalOperation operation = 
			new PreOrderTraversalOperation(binarySearchTree);
				
		operation.perform();
					
		Set<Integer> visitedNodes = operation.getVisitedNodes();
		System.out.println(visitedNodes);
	}    

}
