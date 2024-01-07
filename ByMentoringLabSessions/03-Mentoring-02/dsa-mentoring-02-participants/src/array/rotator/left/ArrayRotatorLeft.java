package array.rotator.left;

public class ArrayRotatorLeft {
	
	private Integer[] inputArray;
	
	public ArrayRotatorLeft (Integer[] inputArray) {
		
		this.inputArray = inputArray;
	}
	
	public void rotateLeft() {
		
		int firstItem = inputArray[0];
		
		for (int index = 1; index < inputArray.length; index++) {
			
			int currentElementIndex = index;
			int currentElement = inputArray[currentElementIndex];
			
			int previousElementIndex = (currentElementIndex - 1);
			inputArray[previousElementIndex] = currentElement;
			
		}
		
		int lastElementIndex = (inputArray.length - 1);
		inputArray[lastElementIndex] = firstItem;
		
	}

}
