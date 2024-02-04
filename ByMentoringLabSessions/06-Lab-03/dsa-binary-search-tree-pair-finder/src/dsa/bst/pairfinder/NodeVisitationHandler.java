package dsa.bst.pairfinder;

import java.util.Set;

import dsa.binarysearchtree.Node;

public interface NodeVisitationHandler {
    
    void handle(Node currentNode, Set<Integer> previousVisitedNodes);
}
