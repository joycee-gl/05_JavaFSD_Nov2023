package dsa.binarytree.lca;

public class NodeFinder {
	
	private BinaryTree tree;
	
	public NodeFinder(BinaryTree tree) {
		this.tree = tree;
	}
	
	public Node find(String key) {
		
		Node resultNode = findInternal(tree.getRoot(), key);
		if(resultNode != null) {
			System.out.println("Located the node");
		} else {
			System.out.println("Unable to locate the node");
		}
		return resultNode;
	}
	
	public Node findInternal(Node aNode, String key) {
		
		if(aNode == null) {
			return null;
		} 
		
		if(aNode.getData().equals(key)) {
			return aNode;
		}
		
		Node resultNode = findInternal(aNode.getLeft(), key);
		if(resultNode != null) {
			return resultNode;
		}
		
		resultNode = findInternal(aNode.getRight(), key);
		return resultNode;
		
	}

}
