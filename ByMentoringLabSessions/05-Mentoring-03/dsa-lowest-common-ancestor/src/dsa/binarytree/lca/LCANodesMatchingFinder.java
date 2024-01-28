package dsa.binarytree.lca;

import java.util.Iterator;
import java.util.Set;

public class LCANodesMatchingFinder {
	
	private Set<String> node1AncestorNodesSet;
	private Set<String> node2AncestorNodesSet;
	
	public LCANodesMatchingFinder(Set<String> node1AncestorNodesSet,
			Set<String> node2AncestorNodesSet) {
		this.node1AncestorNodesSet = node1AncestorNodesSet;
		this.node2AncestorNodesSet = node2AncestorNodesSet;
	}
	
	public String find() {
		
		String result = "";
		
		Set<String> biggerNodesSet = null;
		Set<String> smallerNodesSet = null;
		
		if(node1AncestorNodesSet.size() >= node2AncestorNodesSet.size()) {
			biggerNodesSet = node1AncestorNodesSet;
			smallerNodesSet = node2AncestorNodesSet;
		} else {
			biggerNodesSet = node2AncestorNodesSet;
			smallerNodesSet = node1AncestorNodesSet;
		}
		
		Iterator<String> iterator = biggerNodesSet.iterator();
		while(iterator.hasNext()) {
			
			String biggerNodeSetElement = iterator.next();
			
			if(smallerNodesSet.contains(biggerNodeSetElement)) {
				//found the LCA
				result = biggerNodeSetElement;
				break;
			}
		}
		
		return result;
	}

}
