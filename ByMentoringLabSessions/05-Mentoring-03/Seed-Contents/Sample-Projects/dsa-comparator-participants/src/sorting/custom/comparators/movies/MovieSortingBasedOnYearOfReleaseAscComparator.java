package sorting.custom.comparators.movies;

import java.util.Comparator;

public class MovieSortingBasedOnYearOfReleaseAscComparator 
	implements Comparator<Movie>{

	public int compare(Movie movie1, Movie movie2) {
		
		// Ascending Order - Year of release
				
		if (movie1.getYearOfRelease() < movie2.getYearOfRelease()) {
			return -1;
		}else if (movie1.getYearOfRelease() > movie2.getYearOfRelease()) {
			return +1;
		}else {
			return 0;
		}				
	}

}
