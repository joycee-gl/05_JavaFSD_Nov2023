package this_demo;

public class Mobile {

	String owner;
	
	String model;
	double price;
	
	
	public Mobile(String owner, String model, double price) {
		
		
		this.owner = owner;
		
		this.model = model;
		
		this.price = price;
			
		System.out.println("Mobile.ctor " + this.owner + ", " +  this.model + ", " + this.price);
	}
	
	
	public void display() {
		
		System.out.println("Mobile.display " + this.owner + ", " +  this.model + ", " + this.price);

	}
}
