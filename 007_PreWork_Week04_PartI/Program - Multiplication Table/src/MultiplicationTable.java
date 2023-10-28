import java.util.Scanner;

public class MultiplicationTable {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the multiplication table number: ");
		
		int multiplicationTableNumber = scanner.nextInt();
		
		System.out.println("Enter the number of times in multiplication table: ");
		
		int noOfTimes = scanner.nextInt();
		
		for (int index = 1 ; index <= noOfTimes; index++) {
			
			int multiplicationValue = multiplicationTableNumber * index;
			
			System.out.printf("%d (*) %d = %d", multiplicationTableNumber,
												index,
												multiplicationValue);
			
			System.out.println();
		}
		
	}

}
