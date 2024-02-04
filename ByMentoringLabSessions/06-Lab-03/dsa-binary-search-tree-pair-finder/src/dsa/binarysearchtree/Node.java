package dsa.binarysearchtree;

public class Node {

    private Integer data;	
    private Node leftNode;
    private Node rightNode;

    public Node(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {

        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {

        this.rightNode = rightNode;
    }

    public String toString() {
        return "[" + data + "]";
    }
}
