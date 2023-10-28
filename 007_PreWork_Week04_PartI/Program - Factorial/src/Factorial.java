import java.util.Scanner;

public class Factorial {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter number for which factorial is to be generated: ");
		
		int number = scanner.nextInt();
		
		int factorialResult = 1;
		
		int previousIterationResult = 1;
		
		for (int index = number; index >= 1; index--) {
			
			int currentValue = index;
			
			factorialResult = currentValue * previousIterationResult;
			
			previousIterationResult = factorialResult;
			
		}
		
		System.out.println("Factorial of given number " + number + " is : " + factorialResult);
	}
}
