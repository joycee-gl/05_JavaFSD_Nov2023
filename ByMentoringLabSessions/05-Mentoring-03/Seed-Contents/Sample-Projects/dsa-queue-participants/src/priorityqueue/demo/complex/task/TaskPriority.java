package priorityqueue.demo.complex.task;

public enum TaskPriority {

	LOW (0),
	
	MEDIUM (1),
	
	HIGH (2);
	
	private int priority;
	
	private TaskPriority(int priority) {
	
		this.priority = priority;
	}
	
	public int getPriority() {
		
		return priority;
	}
}
