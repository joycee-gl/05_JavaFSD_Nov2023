package dsa.bst.pairfinder;

import java.util.LinkedHashSet;
import java.util.Set;

public class Result {
	
	//whether pair is found or not
	//set of pairs
	private Set<Pair> pairs;
	
	private Boolean found;
	
	//constrctr, get/set, toString
	public Result() {
		this.setPairs(new LinkedHashSet<Pair>());
		this.setFound(Boolean.FALSE);
	}

	public Set<Pair> getPairs() {
		return pairs;
	}

	public void setPairs(Set<Pair> pairs) {
		this.pairs = pairs;
	}

	public Boolean getFound() {
		return found;
	}

	public void setFound(Boolean found) {
		this.found = found;
	}
	
	public String toString() {
		return this.pairs.toString();
	}
	
}
