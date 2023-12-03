package order_of_invocation.car_example;

public class Car {
	
	private String brand;
	
	private String model;
	
	private int yearOfManufacture;
	
	private double price;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Car() {
		
		System.out.println("car.ctor called");
	}
	
	public Car (String brand, String model) {
		
		//this.setBrand(brand);
		this.model = model;
		this.brand = brand;
		System.out.println("car.ctor with parameters called");
	}

		
}
