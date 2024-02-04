package dsa.bst.pairfinder;

public class Pair {

	//one - 50
	//two - 70
	
	private Integer one;
	private Integer two;
	
	//constrctr, get/set, toString
	public Pair(Integer one, Integer two) {
		this.setOne(one);
		this.setTwo(two);
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	public Integer getTwo() {
		return two;
	}

	public void setTwo(Integer two) {
		this.two = two;
	}
	
	public String toString() {
		
		return String.format("[Pair : %d, %d]", one, two);
	}
	
}
