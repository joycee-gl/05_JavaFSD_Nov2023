
public class FibonacciSeries {

	public static void main(String[] args) {
		
		int firstNo = 0;
		int secondNo = 1;
		
		System.out.print(firstNo + ", ");
		System.out.print(secondNo + ", ");
		
		int SERIES_COUNT = 10;
		
		for (int index = 3; index <= SERIES_COUNT; index++) {
			
			int summedNo = firstNo + secondNo;
			
			if(index == SERIES_COUNT) {
				
				System.out.print(summedNo);
			} else {
				
				System.out.print(summedNo + ", ");
			}
			
			firstNo = secondNo;
			secondNo = summedNo;
		}
	}
}
