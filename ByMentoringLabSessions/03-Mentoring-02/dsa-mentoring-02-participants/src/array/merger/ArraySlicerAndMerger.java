package array.merger;

public class ArraySlicerAndMerger {
	
	private Integer[] originalArray;
	
	public ArraySlicerAndMerger(Integer[] originalArray) {
		
		this.originalArray = originalArray;
	}
	
	public void sliceAndMerge(int leftIndex, int middleIndex, int rightIndex) {
		
		Integer[] leftArray = constructLeftArray(leftIndex, middleIndex);
		
		Integer[] rightArray = constructRightArray(middleIndex, rightIndex);
		
		Integer[] mergedArray = compareAndMerge(leftArray, rightArray);
		
		copyElements(mergedArray, originalArray);
	}
	
	// Left Index (source) - 2
	// Middle index (source) - 4
	private Integer[] constructLeftArray (int sourceLeftIndex, int sourceMiddleIndex) {
		
		int targetLeftArrayLength = (sourceMiddleIndex - sourceLeftIndex) + 1;
		Integer[] targetLeftArray = new Integer[targetLeftArrayLength];
		
		for (int targetLeftArrayIndex = 0; 
				targetLeftArrayIndex < targetLeftArrayLength;
				targetLeftArrayIndex++ ) {
			
			//2 + 0 = 2
			//2 + 1 = 3
			//2 + 2 = 4
			int sourceArrayIndex = sourceLeftIndex + targetLeftArrayIndex;
			targetLeftArray[targetLeftArrayIndex] = originalArray[sourceArrayIndex];
			
		}
		
		return targetLeftArray;
		
	}
	
	// Middle Index (source) - 4
	// Right Index (source) - 6
	
	private Integer[] constructRightArray(int sourceMiddleIndex, int sourceRightIndex) {
		
		int targetRightArrayLength = (sourceRightIndex - sourceMiddleIndex);
		Integer[] targetRightArray = new Integer[targetRightArrayLength];
		
		//Copy elements to right array
		for (int targetRightArrayIndex = 0; 
				 targetRightArrayIndex < targetRightArrayLength;
				targetRightArrayIndex ++) {
			
			// 4 + 1 + 0 = 5
			// 4 + 1 + 1 = 6
			// 4 + 1 + 2 = 7
			int sourceArrayIndex = (sourceMiddleIndex + 1 + targetRightArrayIndex);
			targetRightArray[targetRightArrayIndex] = originalArray[sourceArrayIndex];
			
		}
		
		return targetRightArray;
		
	}
	
	private Integer[] compareAndMerge (Integer[] leftSubArray, Integer[] rightSubArray) {
		
		Integer[] mergedArray = new Integer[leftSubArray.length + rightSubArray.length];
		
		int leftSubArrayPointer = 0;
		int rightSubArrayPointer = 0;
		int mergedArrayPointer = 0;
		
		while (leftSubArrayPointer < leftSubArray.length && 
				rightSubArrayPointer < rightSubArray.length) {
			
			Integer leftSubArrayElement = leftSubArray[leftSubArrayPointer];
			Integer rightSubArrayElement = rightSubArray[rightSubArrayPointer];
			
			if(leftSubArrayElement < rightSubArrayElement) {
				
				mergedArray[mergedArrayPointer] = leftSubArrayElement;
				leftSubArrayPointer++;
				mergedArrayPointer++;
				
			} else {
				
				mergedArray[mergedArrayPointer] = rightSubArrayElement;
				rightSubArrayPointer++;
				mergedArrayPointer++;
				
			}
		}
		
		//copy remaining elements in left sub array to merged array
		for(; leftSubArrayPointer < leftSubArray.length; leftSubArrayPointer++) {
			
			Integer leftSubArrayElement = leftSubArray[leftSubArrayPointer];
			mergedArray[mergedArrayPointer] = leftSubArrayElement;
			mergedArrayPointer++;
		}
		
		//copy remaining elements in right sub array to merged array
		for (; rightSubArrayPointer < rightSubArray.length; rightSubArrayPointer++) {
			
			Integer rightSubArrayElement = rightSubArray[rightSubArrayPointer];
			mergedArray[mergedArrayPointer] = rightSubArrayElement;
			mergedArrayPointer ++;
		}
		
		return mergedArray;
		
	}
	
	private void copyElements(Integer[] source, Integer[] destination) {
		
		for(int index = 0; index < source.length; index++) {
		
			destination[index] = source[index];
		}
		
	}

}
