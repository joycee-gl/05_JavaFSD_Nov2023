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
		
		int searchElementIndex = -1;
	    
		int startIndexElement = inputArray[startIndex];
    	int endIndexElement = inputArray[endIndex];

    	if(searchElement < startIndexElement || searchElement > endIndexElement) {
    		System.out.printf("Search element %d not within range of values in the sorted array, "
    				+ "so returning the default index %d \r\n", 
    				searchElement, searchElementIndex);
    		return searchElementIndex;
    	}
    	
	    while (startIndex <= endIndex) {
			
			System.out.printf("Start index : %d, End index : %d", startIndex, endIndex);
			System.out.println();
			
			int middleElementIndex = (startIndex + endIndex) / 2;
			int middleElementValue = inputArray[middleElementIndex];
			
			if (middleElementValue == searchElement) {
    			
    		    System.out.printf("Element %d present at index %d \r\n", 
    		    		searchElement, middleElementIndex);	
    		    return middleElementIndex;
    				
    		} else {
    		    
    	        if (searchElement > middleElementValue) {
    	            
    	            startIndex = middleElementIndex + 1;
    	                                
    	        } else if (searchElement < middleElementValue) {
    	           
    	        	endIndex = middleElementIndex - 1;
    	        }

    		}
			
		}
		
	    System.out.printf("Unable to locate the search element %d, returning the index as %d \r\n", 
                searchElement, searchElementIndex);
	    
	    return searchElementIndex;
		
	}

}
