package array.rotator.left;

public class ArrayRotatorLeftTest {

	public static void main(String[] args) {
		test1();
	}
	
	static void test1() {
		
		//Integer[] input = {3, 9, 11, 18, 24};
		Integer[] input = {92, 18, 7, 26, 55};
		printArray(input);
		
		ArrayRotatorLeft rotator = new ArrayRotatorLeft(input);
		rotator.rotateLeft();
		
		System.out.println();
		
		printArray(input);
		
	}
	
	static void printArray(Integer[] array) {
		
		for(int index = 0; index < array.length ; index++) {
			
			System.out.print(array[index] + " ");
		}
	}
}
