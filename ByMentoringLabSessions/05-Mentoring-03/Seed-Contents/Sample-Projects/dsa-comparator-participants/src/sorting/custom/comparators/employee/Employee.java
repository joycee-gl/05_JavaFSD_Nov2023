package sorting.custom.comparators.employee;

public class Employee {

	public String name;
	public Double salary;
	public int experienceInYears;
	
	
	public Employee(String name, Double salary, int experienceInYears) {
		
		this.name = name;
		this.salary = salary;
		this.experienceInYears = experienceInYears;
	}

	public String toString() {
		
		return String.format("[Name is %s, Salary is %f, Experience is %d]", 
			name, salary, experienceInYears);
	}
}
