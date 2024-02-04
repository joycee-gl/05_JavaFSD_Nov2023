package dsa.binarysearchtree;

import java.util.LinkedHashSet;
import java.util.Set;

import dsa.bst.pairfinder.NodeVisitationHandler;

public class PreOrderTraversalOperation {
	
	private BinarySearchTree binaryTree;
	
	//set - linked hash set - visited nodes
	private Set<Integer> visitedNodes;
	
	private NodeVisitationHandler nodeVisitationHandler;
	
	public PreOrderTraversalOperation(BinarySearchTree binaryTree) {
		
		this.binaryTree = binaryTree;
		//initialize visited nodes set
		this.visitedNodes = new LinkedHashSet<Integer>();
	}

	//perform()
		// pre order internal(root)
	
	//pre order
		// node
			// add the node's data to visited nodes
		// left sub tree
		// right sub tree
	
	public void perform() {
		
		preOrderInternal(binaryTree.getRoot());
	}

	private void preOrderInternal(Node node) {
		
		if(node == null) {
			return;
		}
		
		if (this.nodeVisitationHandler != null) {
	        this.nodeVisitationHandler.handle(node, visitedNodes);			
	    }
		
		this.visitedNodes.add(node.getData());
		
		preOrderInternal(node.getLeftNode());
		
		preOrderInternal(node.getRightNode());
		
	}
	
	public Set<Integer> getVisitedNodes() {
		
		return this.visitedNodes;
	}

	public void setNodeVisitationHandler(NodeVisitationHandler nodeVisitationHandler) {
		this.nodeVisitationHandler = nodeVisitationHandler;
	}
	
}
