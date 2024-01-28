package juicemachine.milkshakes;

public class BulkOrder {
	//MANGO, 1
	//ORANGE, 4
	//PINEAPPLE, 2
	private JuiceType juiceType;
	private int numberOfOrders;
	
	public BulkOrder(JuiceType juiceType, int numberOfOrders) {
		
		this.juiceType = juiceType;
		this.numberOfOrders = numberOfOrders;
	}

	public JuiceType getJuiceType() {
		return juiceType;
	}

	public void setJuiceType(JuiceType juiceType) {
		this.juiceType = juiceType;
	}

	public int getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}
	
	public String toString() {
		return String.format("[%s -> %d]", juiceType, numberOfOrders);
	}
	
	public void decrementOrdersBy(int decrementNo) {
		
		setNumberOfOrders(getNumberOfOrders() - decrementNo);
	}
	
	public boolean hasActiveOrders() {
		return (numberOfOrders != 0);
	}
	
	public boolean hasNoOrders() {
		return !hasActiveOrders();
	}

}
