package priorityqueue.demo.complex.order;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueOrderDemo2 {

	public static void main(String[] args) {
		
		List<Order> orders = new ArrayList<Order>();
		
		orders.add(new Order(5, 500F));
		orders.add(new Order(4, 700F));
		orders.add(new Order(2, 50));
		orders.add(new Order(3, 900F));						

		OrderBasedOnQuantityDescComparator comparator = 
			new OrderBasedOnQuantityDescComparator();
		
		Queue<Order> queue = new PriorityQueue<Order>(comparator);
		
		System.out.println("Priority Queue configured to process Orders based on Quantity");
		System.out.println();
		
		PriorityQueueOrderUtils.addOrdersToQueue(queue, orders);
		
		PriorityQueueOrderUtils.pollItems(queue);
	}
}
