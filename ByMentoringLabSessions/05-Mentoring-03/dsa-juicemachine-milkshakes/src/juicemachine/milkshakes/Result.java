package juicemachine.milkshakes;

public class Result {
	
	private OrderProcessingStatus status;
	private int noOfSeconds;
	
	public Result() {
		noOfSeconds = 0;
		status = OrderProcessingStatus.UNDEFINED;
	}

	public OrderProcessingStatus getStatus() {
		return status;
	}

	public void setStatus(OrderProcessingStatus status) {
		this.status = status;
	}

	public int getNoOfSeconds() {
		return noOfSeconds;
	}

	public void setNoOfSeconds(int noOfSeconds) {
		this.noOfSeconds = noOfSeconds;
	}
	
	public void incrementNoOfSeconds(int noOfSeconds) {
		
		setNoOfSeconds(getNoOfSeconds() + noOfSeconds);
	}

	public boolean isDone() {
		
		return status.equals(OrderProcessingStatus.DONE);
	}
	
	public String toString() {
		return "Minimum Time Duration -> " + noOfSeconds + " Seconds ";
	}
	
}
