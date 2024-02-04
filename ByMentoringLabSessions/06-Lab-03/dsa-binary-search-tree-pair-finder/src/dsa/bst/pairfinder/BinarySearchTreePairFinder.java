package dsa.bst.pairfinder;

import java.util.Set;

import dsa.binarysearchtree.BinarySearchTree;
import dsa.binarysearchtree.Node;
import dsa.binarysearchtree.PreOrderTraversalOperation;

public class BinarySearchTreePairFinder implements NodeVisitationHandler{
	
	//tree
	//sumValue
	
	private BinarySearchTree tree;
	private Integer sumValue;
	private Result result;
	
	//constrctr 
	public BinarySearchTreePairFinder(
			BinarySearchTree tree, Integer sumValue) {
		
		this.tree = tree;
		this.sumValue = sumValue;
		this.result = new Result();
	}
	
	
	//findPair() - core logic 
	public Result findPair() {
		
		//PreOrderTraversalOperation(tree)
			//setNodeVisitationHandler(this)
			//perform()
		
		 PreOrderTraversalOperation operation
         	= new PreOrderTraversalOperation(tree);
     
	     operation.setNodeVisitationHandler(this);
	     
	     operation.perform();
	         
	     return this.result;
			
	}


	@Override
	public void handle(Node currentNode, Set<Integer> previousVisitedNodes) {
		
		//get current node data
		//diff between sum value and curr node data 
		//if diff is present in previousVisitedNodes
			//pair - curr node data, diff
			//found - true
		
		
        System.out.println();		
        System.out.printf("Current Node : %s", currentNode);
        System.out.println();
        
        System.out.printf("Previous Visited Nodes : %s", previousVisitedNodes);
        System.out.println();
        
        Integer currentNodeData = currentNode.getData();
        
        Integer difference = (sumValue - currentNodeData);
        
        if  (previousVisitedNodes.contains(difference)) {
        
            System.out.printf("Match Identified : Sum %d, Difference : %d", 
                sumValue, difference);
            System.out.println();
            
            this.result.setFound(Boolean.TRUE);
            
            Pair newPair = new Pair(currentNodeData, difference);			
            this.result.getPairs().add(newPair);
            
        }			

        
	}
	
	

}
