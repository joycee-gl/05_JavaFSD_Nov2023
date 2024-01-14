package merge.sort;

import array.merger.ArraySlicerAndMerger;

public class MergeSort {

	private Integer[] inputArray;
	
	public MergeSort(Integer[] inputArray) {
		this.inputArray = inputArray;
	}
	
	public void mergeSort() {
		
		mergeSortInternal(0, inputArray.length - 1);
		
	}
	
	private void mergeSortInternal (int startIndex, int endIndex) {
		
		
		if(startIndex < endIndex) {
			
//			System.out.printf("Start Index : %d , End Index : %d" , 
//					startIndex, endIndex);
//			System.out.println();
			
			int midPointIndex = (startIndex + endIndex) / 2;
			
			mergeSortInternal(startIndex, midPointIndex); 
			
			mergeSortInternal( (midPointIndex + 1), endIndex);
			
			ArraySlicerAndMerger slicerAndMerger = 
					new ArraySlicerAndMerger(inputArray);
			slicerAndMerger.sliceAndMerge(startIndex, midPointIndex, endIndex);
			
		}
		
		
	}
}
