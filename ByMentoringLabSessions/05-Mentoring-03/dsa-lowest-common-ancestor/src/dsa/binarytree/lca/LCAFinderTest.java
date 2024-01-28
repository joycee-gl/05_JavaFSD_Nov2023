package dsa.binarytree.lca;

public class LCAFinderTest {
	
	public static void main(String[] args) {
//		test01();
		test02();
	}
	
	static void test01() {
		
		BinaryTree tree = SampleBinaryTrees._7NodeSampleTree();
		testLCAFinder(tree, "20", "30");
	}
	
	static void test02() {
		
		BinaryTree tree = SampleBinaryTrees._7NodeSampleTree();
		testLCAFinder(tree, "40", "30");
	}
	
	static void testLCAFinder(BinaryTree tree, String key1, String key2) {
		LCAFinder finder = new LCAFinder(tree);
		finder.find(key1, key2);
	}

}
