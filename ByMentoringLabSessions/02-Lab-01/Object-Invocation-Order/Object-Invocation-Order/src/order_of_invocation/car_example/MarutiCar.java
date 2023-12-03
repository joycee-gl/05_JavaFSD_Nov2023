package order_of_invocation.car_example;

public class MarutiCar extends Car {
	
	static {
		System.out.println("Basic car framework loaded...");
	}
	
	public MarutiCar() {
		
		System.out.println("MarutiCar.ctor called");
	}

}
