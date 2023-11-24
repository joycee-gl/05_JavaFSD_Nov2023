
public class BreakStatementWithinForLoopDemoV2 {

	public static void main(String[] args) {
				
		for (int i = 1; i <=10; i++) {

			if (i == 6) {
				break;				
			}

			System.out.println("Processing I for value ->" + i);			
		}
			
	}
}
