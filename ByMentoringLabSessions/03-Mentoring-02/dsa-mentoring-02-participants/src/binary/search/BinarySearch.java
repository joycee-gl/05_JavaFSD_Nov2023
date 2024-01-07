package binary.search;

public class BinarySearch {
	
	private Integer[] inputArray;
	private Integer searchElement;
	
	public BinarySearch(Integer[] inputArray) {
		this.inputArray = inputArray;
	}
	
	public int search(int searchElement) {
		this.searchElement = searchElement;
		
		int result = startSearchInternal(0, inputArray.length - 1);
		
		return result;
	}
	
	private int startSearchInternal(int startIndex, int endIndex) {
		
		while (startIndex <= endIndex) {
			
			System.out.printf("Start index : %d, End index : %d", startIndex, endIndex);
			System.out.println();
			
			int middleElementIndex = (startIndex + endIndex) / 2;
			int middleElementValue = inputArray[middleElementIndex];
			
			
			
		}
		
		return -1;
	}

}
