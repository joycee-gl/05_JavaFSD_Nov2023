package testdata;
import java.util.ArrayList;
import java.util.List;

import sorting.custom.comparable.movies.Movie;

public class TestData {
	
	public static List<Movie> moviesList(){
						
		List<Movie> allMovies = new ArrayList<Movie>();
		allMovies.add(new Movie("Terminator Salvation", 
				2010, 6.5F, 70));
		allMovies.add(new Movie(
				"Terminator II", 1992, 8.5F, 150));
		allMovies.add(new Movie("X Men - Part I", 
				2000, 8.1F, 120));
		allMovies.add(new Movie("XMen - First Class", 2011, 
				8.4F, 110));
		allMovies.add(
				new Movie("Terminator 1", 1983, 8.1F, 100));
		allMovies.add(
				new Movie("Terminator 3", 2003, 6.5F, 150));
				
		return allMovies;
	}

}
