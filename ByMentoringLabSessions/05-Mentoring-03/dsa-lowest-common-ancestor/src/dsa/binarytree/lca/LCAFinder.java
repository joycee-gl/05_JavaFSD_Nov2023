package dsa.binarytree.lca;

import java.util.Set;

public class LCAFinder {
	
	private BinaryTree tree;
	
	public LCAFinder(BinaryTree tree) {
		this.tree = tree;
	}
	
	public void find(String key1, String key2) {
		
		NodeFinder finder = new NodeFinder(tree);
		
		Node node1 = finder.find(key1);
		System.out.printf("For key %s, the node identified is %s ", key1, node1);
		System.out.println();
		
		Node node2 = finder.find(key2);
		System.out.printf("For key %s, the node identified is %s ", key2, node2);
		System.out.println();
		
		AncestorNodesCollector ancestorNodesCollector1 
			= new AncestorNodesCollector(node1);
		Set<String> ancestorNodes1 = ancestorNodesCollector1.collect();
		System.out.printf("For key %s, ancestor nodes are %s", key1, ancestorNodes1);
		System.out.println();
		
		AncestorNodesCollector ancestorNodesCollector2	= new AncestorNodesCollector(node2);
		Set<String> ancestorNodes2 = ancestorNodesCollector2.collect();
		System.out.printf("For key %s, ancestor nodes are %s", key2, ancestorNodes2);
		System.out.println();
		
		LCANodesMatchingFinder lowestCommonElementFinder = 
				new LCANodesMatchingFinder(ancestorNodes1, ancestorNodes2);
		String lowestCommonAncestor = lowestCommonElementFinder.find();
		System.out.printf("Lowest common ancestor is %s", lowestCommonAncestor);
			
		System.out.println();
	}

}
