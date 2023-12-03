package this_demo;

public class Mobile2 {

	String owner;
	
	String model;
	double price;
	
	
	public Mobile2(String o, String m, double p) {
		
		
		owner = o;
		
		model = m;
		
		price = p;			
	}
	
	
	public void display() {
		
		System.out.println("Mobile.display " + owner + ", " +  model + ", " + price);

	}
}
