package array.merger;

public class ArraySlicerAndMergerTest {

	public static void main(String[] args) {
	
//		test1();
		test2();
	}
	
	static void test1() {
		
		Integer[] array = {21, 28, 13, 19, 34, 47};
		System.out.println("==== Original array =====");
		printArray(array);
		
		ArraySlicerAndMerger slicerAndMerger = new ArraySlicerAndMerger(array);
		slicerAndMerger.sliceAndMerge(0, 1, 5);
		
		System.out.println("==== Sliced and Merged array =====");
		printArray(array);
		
	}
	
	static void test2() {
		
		Integer[] array = {13, 18, 42, 47, 15, 19};
		System.out.println("==== Original array =====");
		printArray(array);
		
		ArraySlicerAndMerger slicerAndMerger = new ArraySlicerAndMerger(array);
		slicerAndMerger.sliceAndMerge(0, 3, 5);
		
		System.out.println("==== Sliced and Merged array =====");
		printArray(array);
		
	}
	
	static void printArray(Integer[] array) {
		
		for(int index = 0; index < array.length ; index++) {
			
			System.out.print(array[index] + " ");
		}
		System.out.println();
	}

}
