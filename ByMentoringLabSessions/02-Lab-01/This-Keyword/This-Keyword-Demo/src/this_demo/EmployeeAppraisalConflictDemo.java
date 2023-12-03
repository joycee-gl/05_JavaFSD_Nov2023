package this_demo;

public class EmployeeAppraisalConflictDemo {

	public static void main(String[] args) {
		
		
		Employee managerRaj = new Employee();
		
		Employee anil = new Employee();
		
		Employee neha = new Employee();
		
		managerRaj.performAppraisal(anil, neha);
	}
}
