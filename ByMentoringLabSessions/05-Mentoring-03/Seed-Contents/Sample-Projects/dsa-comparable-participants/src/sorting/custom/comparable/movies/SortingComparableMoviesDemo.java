package sorting.custom.comparable.movies;

import java.util.Collections;
import java.util.List;

import testdata.TestData;

public class SortingComparableMoviesDemo {

	public static void main(String[] args) {
		
		defaultSortingBasedOnRating();
	}
	
	static void defaultSortingBasedOnRating() {
				
		List<Movie> allMovies = TestData.moviesList();
		
		System.out.println("Before Sorting - Movies");
		System.out.println(allMovies);
		System.out.println();
		
		Collections.sort(allMovies);
		
		System.out.println("After Sorting - Movies - Comparable - Based On Highest Rating");
		System.out.println(allMovies);		
	}	
}
