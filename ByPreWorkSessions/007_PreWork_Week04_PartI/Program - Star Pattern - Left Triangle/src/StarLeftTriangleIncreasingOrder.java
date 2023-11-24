
public class StarLeftTriangleIncreasingOrder {
	
	public static void main(String[] args) {
		
		int COUNT = 5;
		
		for (int outerIndex = 1; outerIndex <= COUNT; outerIndex++) {
			
			int uptoIndex = outerIndex;
			
			for (int index = 1; index <= uptoIndex; index++) {
				
				System.out.print("*");
				System.out.print(" ");
			}
			
			System.out.println();
			
		}
		
	}
	
}
