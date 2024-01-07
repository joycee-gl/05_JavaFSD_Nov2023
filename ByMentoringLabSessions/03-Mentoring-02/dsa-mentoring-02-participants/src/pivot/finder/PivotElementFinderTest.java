package pivot.finder;

public class PivotElementFinderTest {
	
	public static void main(String[] args) {
		
//		test1();
		
//		test2();
		
		test3();
	}
	
	static void test1() {
		
		Integer[] array = {9, 12, 15, 21, 33, 42, 57};
		printArray(array);
		
		PivotElementFinder searcher = new PivotElementFinder(array);
		int pivotIndex = searcher.locateIndex();
		
		System.out.println("Pivot index : " + pivotIndex);
		
	}

	static void test2() {
		
		Integer[] array = {33, 42, 57, 9, 12, 15, 21 };
		printArray(array);
		
		PivotElementFinder searcher = new PivotElementFinder(array);
		int pivotIndex = searcher.locateIndex();
		
		System.out.println("Pivot index : " + pivotIndex);
		
	}
	
	static void test3() {
		
		Integer[] array = {33, 42, 57, 66, 72, 9, 12 };
		printArray(array);
		
		PivotElementFinder searcher = new PivotElementFinder(array);
		int pivotIndex = searcher.locateIndex();
		
		System.out.println("Pivot index : " + pivotIndex);
		
	}

	static void printArray(Integer[] array) {
		
		for(int index = 0; index < array.length ; index++) {
			
			System.out.print(array[index] + " ");
		}
		System.out.println();
	}
}
