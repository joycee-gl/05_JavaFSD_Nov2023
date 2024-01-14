package array.merger;

public class ArraySlicerAndMerger {

	private Integer[] originalArray;
			
	public ArraySlicerAndMerger(Integer originalArray[]) {
	
		this.originalArray = originalArray;
	}
	
	public void sliceAndMerge(int startIndex, int middleIndex, int endIndex) {
				
        
		compareAndMerge(startIndex, middleIndex, endIndex);		
		
		
	}
	
	
	private void compareAndMerge(int startIndex,
			int midPointIndex, int endIndex) {

		
		Integer mergedArray[] 
			= new Integer[endIndex - startIndex + 1];

		int leftSubArrayPointer = startIndex;
		int rightSubArrayPointer = midPointIndex + 1;		
		int mergedArrayPointer = 0;
		
				
		
		
		while (leftSubArrayPointer <= midPointIndex 
				&& rightSubArrayPointer <= endIndex) {
			
			Integer leftSubArrayElement = originalArray[leftSubArrayPointer];
			Integer rightSubArrayElement = originalArray[rightSubArrayPointer];
			
			
//			if (leftSubArrayElement <= rightSubArrayElement) {
				
			if (leftSubArrayElement > rightSubArrayElement) {
				
				mergedArray[mergedArrayPointer] = leftSubArrayElement;
				leftSubArrayPointer ++;
				mergedArrayPointer ++;
				
				
			}else {
				
				mergedArray[mergedArrayPointer] = rightSubArrayElement;
				rightSubArrayPointer ++;
				mergedArrayPointer ++;	
				
			}		
		}
		
			
		while (leftSubArrayPointer <= midPointIndex) {
			
			Integer leftSubArrayElement = originalArray[leftSubArrayPointer];
			mergedArray[mergedArrayPointer] = leftSubArrayElement;
			
			leftSubArrayPointer ++;
			mergedArrayPointer ++;
			
			
		}
		
		
			
		while (rightSubArrayPointer <= endIndex) {
			
			Integer rightSubArrayElement = originalArray[rightSubArrayPointer];
			mergedArray[mergedArrayPointer] = rightSubArrayElement;
			
			rightSubArrayPointer ++;
			mergedArrayPointer ++;
			
			
		}				
		
		for (leftSubArrayPointer = startIndex; leftSubArrayPointer <= endIndex;
				leftSubArrayPointer ++) {
				
				int tempArrayIndex2 = leftSubArrayPointer - startIndex;
				originalArray[leftSubArrayPointer] = mergedArray[tempArrayIndex2];
		}
		
		
	}

}
