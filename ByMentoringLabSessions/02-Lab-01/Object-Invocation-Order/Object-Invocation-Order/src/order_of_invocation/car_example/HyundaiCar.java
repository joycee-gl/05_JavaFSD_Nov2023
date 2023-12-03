package order_of_invocation.car_example;

public class HyundaiCar extends Car {

	public HyundaiCar() {
		System.out.println("HyundaiCar.ctor called"); 
	}

	public HyundaiCar(String modelName) {
		System.out.println("HyundaiCar.ctor called");
	}

	public HyundaiCar(String brand, String model) {

		super(brand, model);

		System.out.println("HyundaiCar.ctor with parameters called");
	}
}
