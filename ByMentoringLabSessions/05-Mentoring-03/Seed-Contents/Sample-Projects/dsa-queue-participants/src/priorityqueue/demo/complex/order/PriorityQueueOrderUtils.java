package priorityqueue.demo.complex.order;

import java.util.List;
import java.util.Queue;

public class PriorityQueueOrderUtils {
	
	public static void addOrdersToQueue(
			Queue<Order> queue, List<Order> orders) {
				
		for (Order order : orders) {
			
			queue.add(order);
		}
	}
	
	public static void pollItems(Queue<Order> queue) {
		
		while (!queue.isEmpty()) {
			
			Order order = queue.poll();
			System.out.printf("The Order %s will be processed", order);
			System.out.println();
		}		
	}	
}
