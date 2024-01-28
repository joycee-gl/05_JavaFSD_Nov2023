package sorting.simple;

import java.util.Arrays;

public class SortingArrayElements {

	public static void main(String[] args) {
		
		sortIntegers();
		
		sortStrings();
	}
	
	static void sortIntegers() {

		System.out.println("For Integers");
		Integer[] ages = new Integer[] {
			10,
			5,
			15,
			28,
			23
		};
				
		
		System.out.println("Before Sorting ->" + Arrays.toString(ages));			
		Arrays.sort(ages);	
		System.out.println("After Sorting [ASC]->" + Arrays.toString(ages));		
		
		System.out.println();
	}


	static void sortStrings() {

		System.out.println("For Strings");
		
		String[] cities = new String[] {
			
				"Trivandram",
				"Mumbai",
				"Goa",
				"Pune",
				"Chennai",
				"Delhi",
				"Kolkatta"
		};
				
		
		System.out.println("Before Sorting ->" + Arrays.toString(cities));			
		Arrays.sort(cities);	
		System.out.println("After Sorting [ASC]->" + Arrays.toString(cities));		
		
		System.out.println();
	}	
}
