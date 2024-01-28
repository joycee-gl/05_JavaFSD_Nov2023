package priorityqueue.demo.simple;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemoSimpleTypes {

	public static void main(String[] args) {
		
		List<String> tasks = new ArrayList<String>();
		
		tasks.add("Project Report complete by this week");
		tasks.add("Send Design Document to Team");
		tasks.add("Complete AWS Certification Course in 4 months");
		tasks.add("Fix the Bug in Production");		
		tasks.add("Finish the Ikigai Book");		
		tasks.add("Movie Editing Course - Complete Assignments");		
				
		itemsDefaultArrangementInPriorityQueue(tasks);
		System.out.println();
		
		itemsReverseArrangementInPriorityQueue(tasks);
		System.out.println();
	}
	
	private static void itemsDefaultArrangementInPriorityQueue(List<String> tasks) {

		Queue<String> queue = new PriorityQueue<String>();

		System.out.println("Normal Ordering of Items for String");
		System.out.println("--------------------------------");
		
		for (String task : tasks) {
			
			queue.add(task);
		}
		
		pollItems(queue);				
	}

	private static void itemsReverseArrangementInPriorityQueue(List<String> tasks) {

		Queue<String> queue = new PriorityQueue<String>(Collections.reverseOrder());

		System.out.println("Reverse Ordering of Items");
		System.out.println("--------------------------------");
		
		for (String task : tasks) {
			
			queue.add(task);
		}
		
		pollItems(queue);				
			
	}
	
	private static void pollItems(Queue<String> queue) {
		
		while (!queue.isEmpty()) {
			
			String value = queue.poll();
			System.out.println(value);
		}		
	}
}
