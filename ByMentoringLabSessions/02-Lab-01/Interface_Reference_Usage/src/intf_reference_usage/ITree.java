package intf_reference_usage;

public interface ITree {

	String getRoot();
	
	String getLeft();
	
	String getRight();
	
	void addParent();
	
	void addChild();
	
	void visitAllNodes();
}
