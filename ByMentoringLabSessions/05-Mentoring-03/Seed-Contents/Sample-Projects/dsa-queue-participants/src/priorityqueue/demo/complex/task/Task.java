package priorityqueue.demo.complex.task;

public class Task {

	public String name;
	public TaskPriority priority;
	
	public Task(String name, TaskPriority priority) {
		
		this.name = name;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
	
	public String toString() {
		
		return String.format("[Name : %s, Priority : %s]", this.name, this.priority);
	}
}
