package sorting.simple.custom;

import java.util.Collections;
import java.util.List;

import testdata.TestData;

public class SortingSimpleElementsCustomized {

	public static void main(String[] args) {
		
//		sortUsingNaturalOrdering();
		
		sortViaMaxLength();
	}
	
    public static void sortUsingNaturalOrdering(){
    	
    	List<String> countries = TestData.countriesList(); 
    	System.out.println("Before Sorting");
    	System.out.println(countries);
    	
    	System.out.println();
    	
    	Collections.sort(countries);
    	System.out.println("After Sorting - Natural Order [ASC]");
    	System.out.println(countries);
    }

    public static void sortViaMaxLength(){
    	
		List<String> countries = TestData.countriesList(); 
		System.out.println("Before Sorting");
		System.out.println(countries);
		
		System.out.println();
		
		SortViaMaxLengthComparator maxLengthComparator 
			= new SortViaMaxLengthComparator();
		
		Collections.sort(countries, maxLengthComparator);
		System.out.println("After Sorting - Custom - MaxLength Comparator");
		System.out.println(countries);
    }
		
}


