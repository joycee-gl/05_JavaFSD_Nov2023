package sorting.custom.comparators.movies;


import java.util.Collections;
import java.util.List;

import testdata.TestData;

public class MovieSortingDemo {

	public static void main(String[] args) {
		
		sortBasedOnRunDays();
		
//		sortBasedOnYearOfRelease();
	}
	
	static void sortBasedOnRunDays() {
		
		
		List<Movie> allMovies = TestData.moviesList();
		
		System.out.println("Before Sorting - Movies");
		System.out.println(allMovies);
		System.out.println();
		
		Collections.sort(allMovies, 
			new MovieSortingBasedOnRunDaysDescComparator());
		
		System.out.println("After Sorting - Movies - Based on Run  Days DESC");
		System.out.println(allMovies);		
	}
	
	
	static void sortBasedOnYearOfRelease() {
		
		List<Movie> allMovies = TestData.moviesList();
		
		System.out.println("Before Sorting - Movies");
		System.out.println(allMovies);
		System.out.println();
		
		Collections.sort(allMovies, 
			new MovieSortingBasedOnYearOfReleaseAscComparator());
		
		System.out.println("After Sorting - Movies - Based on YearOfRelease ASC");
		System.out.println(allMovies);		
	}
	
}