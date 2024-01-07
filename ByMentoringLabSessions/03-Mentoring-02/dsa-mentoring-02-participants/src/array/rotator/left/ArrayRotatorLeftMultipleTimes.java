package array.rotator.left;

public class ArrayRotatorLeftMultipleTimes {
	
	private Integer[] inputArray;
	
	public ArrayRotatorLeftMultipleTimes(Integer[] inputArray) {
		
		this.inputArray = inputArray;
	}
	
	public void rotateLeft(int rotationsCount) {
		
		int optimizedRotationCount = (rotationsCount % inputArray.length); 
		
		for (int index = 1; index <= optimizedRotationCount; index++) {
			
			ArrayRotatorLeft rotator = new ArrayRotatorLeft(inputArray);
			rotator.rotateLeft();
		}
		
	}

}
