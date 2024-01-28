package sorting.custom.comparators.movies;

public class Movie {

	private String name;
	private int yearOfRelease;
	private float rating;
	private int runDays;
	
	public Movie(String name, int yearOfRelease, float rating, int runDays) {
				
		this.name = name;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
		this.runDays = runDays;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getRunDays() {
		return runDays;
	}
	public void setRunDays(int runDays) {
		this.runDays = runDays;
	}
	
	public String toString() {
		return String.format("[Name : %s, YearOfRelease : %d, Rating : %f, RunDays : %d]", 
			name, yearOfRelease, rating, runDays);
	}
}
