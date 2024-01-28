package dsa.binarytree.lca;

import java.util.LinkedHashSet;
import java.util.Set;

public class AncestorNodesCollector {
	
	private Node aNode;
	
	public AncestorNodesCollector(Node aNode) {
		this.aNode = aNode;
	}
	
	public Set<String> collect(){
		
		Set<String> ancestorNodes = new LinkedHashSet<String>();
		
		Node tempNode = aNode;
		
		while(tempNode != null) {
			
			ancestorNodes.add(tempNode.getData());
			
			Node tempParentNode = tempNode.getParent();
			tempNode = tempParentNode;
		}
		
		return ancestorNodes;
	}

}
