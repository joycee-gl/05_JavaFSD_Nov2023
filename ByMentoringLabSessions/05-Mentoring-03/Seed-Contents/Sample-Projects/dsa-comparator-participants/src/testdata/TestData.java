package testdata;
import java.util.ArrayList;
import java.util.List;

import sorting.custom.comparators.employee.Employee;
import sorting.custom.comparators.movies.Movie;

public class TestData {

	public static List<Employee> employeesList(){
		
		List<Employee> employees = new ArrayList<>();		
		
		
		employees.add(new Employee("John", 10000.0D, 5));
		employees.add(new Employee("Mary", 12000D, 7));
		employees.add(new Employee("Elizabeth", 5879D, 4));
		employees.add(new Employee("Joe", 8923D, 1));
		employees.add(new Employee("Michael", 20000D, 2));
		employees.add(new Employee("David", 22000.D, 3));

		return employees;		
	}

	public static List<String> countriesList(){
		
		List<String> countries = new ArrayList<>();
		
		countries.add("India");
		countries.add("Pakistan");
		countries.add("America");
		countries.add("Australia");		
		countries.add("Britain");		
		countries.add("South Africa");		
		countries.add("Bangladesh");		
		
		return countries;		
	}
	
	
	public static List<Movie> moviesList(){
						
		List<Movie> allMovies = new ArrayList<>();
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
