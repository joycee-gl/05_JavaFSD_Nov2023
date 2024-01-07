package array.rotator.left;

public class ArrayRotatorLeftMultipleTimesTest {
	
	public static void main(String[] args) {
		
		test1();
		
	}
	
	static void test1() {
		
		Integer[] input = {0, 13, 45};
		printArray(input);
		
		ArrayRotatorLeftMultipleTimes rotator = new ArrayRotatorLeftMultipleTimes(input);
//		rotator.rotateLeft(11);
//		rotator.rotateLeft(12);
		rotator.rotateLeft(2);
		
		System.out.println();
		
		printArray(input);
		
	}
	
	static void printArray(Integer[] array) {
		
		for(int index = 0; index < array.length ; index++) {
			
			System.out.print(array[index] + " ");
		}
	}

}
