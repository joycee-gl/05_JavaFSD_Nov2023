package sorting.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingListElements {

	public static void main(String[] args) {
				
//		sortNumbers();
		
//		sortAges();
		
		sortCities();
	}
	
	static void sortNumbers() {
		
		System.out.println("For Numbers");
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(5);
		numbers.add(25);
		numbers.add(-50);
		numbers.add(-100);
		numbers.add(-10);		
		numbers.add(7);
		
		System.out.println("Before Sorting -> " + numbers);
		Collections.sort(numbers);
		
		System.out.println("After Sorting [ASC]-> " + numbers);		
		
		Collections.sort(numbers, Collections.reverseOrder());
		System.out.println("After Sorting [DESC]->" + numbers);	
		
		System.out.println();		
	}
	
	static void sortAges() {

		System.out.println("For Ages");
		List<Integer> ages = new ArrayList<Integer>();
				
		ages.add(10);
		ages.add(5);
		ages.add(15);
		ages.add(28);
		ages.add(23);
		
		System.out.println("Before Sorting ->" + ages);		
		Collections.sort(ages);
	
		System.out.println("After Sorting [ASC]->" + ages);		

		Collections.sort(ages, Collections.reverseOrder());
		System.out.println("After Sorting [DESC]->" + ages);	
		
		System.out.println();
	}


	static void sortCities() {

		System.out.println("For Cities");
		
		List<String> cities = new ArrayList<String>();
				
		cities.add("Trivandram");
		cities.add("Mumbai");
		cities.add("Goa");
		cities.add("Pune");
		cities.add("Chennai");
		cities.add("Delhi");
		cities.add("Kolkatta");
		
		System.out.println("Before Sorting ->" + cities);		
		Collections.sort(cities);
	
		System.out.println("After Sorting [ASC]->" + cities);		

		Collections.sort(cities, Collections.reverseOrder());
		System.out.println("After Sorting [DESC]->" + cities);		
	}

}
