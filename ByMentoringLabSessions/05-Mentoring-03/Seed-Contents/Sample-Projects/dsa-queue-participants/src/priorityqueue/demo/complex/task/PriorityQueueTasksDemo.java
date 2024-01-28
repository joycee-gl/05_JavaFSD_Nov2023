package priorityqueue.demo.complex.task;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class PriorityQueueTasksDemo {

	public static void main(String[] args) {
				
		
		List<Task> tasks = new ArrayList<Task>();
		
		tasks.add(new Task("Project Report complete by this week", TaskPriority.MEDIUM));
		tasks.add(new Task("Send Design Document to Team", TaskPriority.MEDIUM));
		tasks.add(new Task("Product Demo Meeting with Customer", TaskPriority.HIGH));		
		tasks.add(new Task("Complete AWS Certification Course in 4 months", TaskPriority.LOW));
		tasks.add(new Task("Fix the Bug in Production", TaskPriority.HIGH));		
		tasks.add(new Task("Finish the Ikigai Book", TaskPriority.MEDIUM));		
		tasks.add(new Task("Movie Editing Course - Complete Assignments", TaskPriority.LOW));
		

		TaskPriorityComparator comparator = new TaskPriorityComparator();		
		Queue<Task> queue = new PriorityQueue<Task>(comparator);
		
		priorityQueueDemo(queue, tasks);
	}
	
	
	private static void priorityQueueDemo(Queue<Task> queue, List<Task> tasks) {
		
		addTasksToQueue(queue, tasks);
		pollItems(queue);				
			
	}
	
	private static void addTasksToQueue(Queue<Task> queue, List<Task> tasks) {
				
		for (Task task : tasks) {
			
			queue.add(task);
		}
	}
	
	private static void pollItems(Queue<Task> queue) {
		
		while (!queue.isEmpty()) {
			
			Task task = queue.poll();
			System.out.println(task);
		}		
	}
	
}
