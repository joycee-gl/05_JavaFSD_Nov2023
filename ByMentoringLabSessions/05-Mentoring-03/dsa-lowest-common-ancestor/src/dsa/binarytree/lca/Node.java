package dsa.binarytree.lca;

public class Node {
	
	private String data;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
		left.setParent(this);
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
		right.setParent(this);
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public String toString() {
		return String.format("Node [%s]" , data);
	}
	

}
