package priorityqueue.demo.complex.order;

public class Order implements Comparable<Order> {

	private int quantity;
	private float price;
	
	public Order(int quantity, float price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String toString() {
		return String.format("[Quantity : %d, Amount : %f]", 
				quantity, price);
	}

	@Override
	public int compareTo(Order o2) {
		
		// Descending Order - Price
		
		Order o1 = this;
		
		if (o1.price < o2.price) {
			return +1;
		}else if (o1.price > o2.price) {
			return -1;
		}else {
			return 0;
		}
				
	}	
}
