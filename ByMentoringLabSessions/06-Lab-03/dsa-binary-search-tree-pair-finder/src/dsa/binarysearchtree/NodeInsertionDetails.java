package dsa.binarysearchtree;

public class NodeInsertionDetails {

    private Node parentNode;
    private NodeDirection nodeDirection;
    
    public NodeInsertionDetails() {}
    
    public NodeInsertionDetails(Node parentNode, NodeDirection nodeDirection) {
        
        this.parentNode = parentNode;
        this.nodeDirection = nodeDirection;
    }
    
    public Node getParentNode() {
        return parentNode;
    }
    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
    public NodeDirection getNodeDirection() {
        return nodeDirection;
    }
    public void setNodeDirection(NodeDirection nodeDirection) {
        this.nodeDirection = nodeDirection;
    }
    
    public void set(Node parentNode, NodeDirection nodeDirection) {
        
        this.parentNode = parentNode;
        this.nodeDirection = nodeDirection;		
    }
}
