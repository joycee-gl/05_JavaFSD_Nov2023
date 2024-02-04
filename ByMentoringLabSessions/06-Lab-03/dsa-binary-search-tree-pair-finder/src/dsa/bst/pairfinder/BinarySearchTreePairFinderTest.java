package dsa.bst.pairfinder;

import dsa.binarysearchtree.BinarySearchTree;
import dsa.binarysearchtree.SampleBinarySearchTrees;

public class BinarySearchTreePairFinderTest {
	
	public static void main(String[] args) {

		test01();
	}

	static void test01() {
		
//		Result result = testFindPair(120);
		Result result = testFindPair(190);
		System.out.println(result);
	}

	static Result testFindPair(int sum) {				
		
		BinarySearchTree tree = 
			SampleBinarySearchTrees.sampleBST_01();

		BinarySearchTreePairFinder finder 
			= new BinarySearchTreePairFinder(tree, sum);
		
		Result result = finder.findPair();
		System.out.println();
		return result;		
	}


}
