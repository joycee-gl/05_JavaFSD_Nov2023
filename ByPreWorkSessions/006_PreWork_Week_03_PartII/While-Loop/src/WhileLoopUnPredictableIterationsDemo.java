import java.util.Scanner;

public class WhileLoopUnPredictableIterationsDemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
						
		boolean condition = false;
		
		System.out.println("Do you want purchase a product ? (Y/N)");
		String userInput = scanner.nextLine();		
				
		if (userInput.equals("Y")) {
		
			System.out.println("Product is purchased...");
			condition = true;
		}
		
		
		while (condition) {
				
			System.out.println("Do you want purchase a product ? (Y/N)");			
			userInput = scanner.nextLine();
			
			if (userInput.equals("Y")) {
				
				condition = true;
			}else {
				
				condition = false;
			}
		}
		

	}
}
