package pivot.finder;

public class PivotElementFinder {
	
	private Integer[] array;
	
	public PivotElementFinder(Integer[] array) {
		this.array = array;
	}
	
	public int locateIndex() {
		
		return searchBinary();
	}
	
	private int searchBinary() {
		
		int firstElement = array[0];
		int lastElement = array[array.length - 1];
		
		if(firstElement < lastElement) {
			
			System.out.println("The array is not rotated, returning -1");
			return -1;
		}
		
		int startIndex = 0;
		int endIndex = (array.length - 1);
		
		while (startIndex <= endIndex) {
			
			int startIndexElement = array[startIndex];
			
			int middleIndex = (startIndex + endIndex) / 2;
			int middleIndexElement = array[middleIndex];
			
			int potentialPivotElementIndex = (middleIndex + 1);
			int potentialPivotElement = array[potentialPivotElementIndex];
			
			if(middleIndexElement > potentialPivotElement) {
				
				return potentialPivotElementIndex;
				
			} else if (startIndexElement <= middleIndexElement) {
				
				startIndex = (middleIndex + 1);
				
			} else {
				
				endIndex = (middleIndex - 1);
			}
			
		}
		
		return -1;
	}
	
	

}
