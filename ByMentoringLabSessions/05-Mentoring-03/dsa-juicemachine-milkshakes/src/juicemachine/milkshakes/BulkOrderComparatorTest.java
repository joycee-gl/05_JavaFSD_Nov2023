package juicemachine.milkshakes;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BulkOrderComparatorTest {
	
	public static void main(String[] args) {
		
		test01();
	}

	static void test01() {
		
		BulkOrder[] bulkOrders = TestData.TEST_03_INPUT;
		normalQueue(bulkOrders);	
		priorityQueue(bulkOrders);
	}
	
	static void normalQueue(BulkOrder[] bulkOrders) {
		Queue<BulkOrder> normalQueue = new LinkedList<BulkOrder>();
		System.out.println("Normal Queue");
		//add and retrieve
		addObjectsAndRetrieveObjects(normalQueue, bulkOrders);
		System.out.println();
	}
	
	static void priorityQueue(BulkOrder[] bulkOrders) {
		PriorityQueue<BulkOrder> customPriorityQueue = 
				new PriorityQueue<BulkOrder>(new BulkOrderComparator());
		System.out.println("Priority queue");
		addObjectsAndRetrieveObjects(customPriorityQueue, bulkOrders);
		System.out.println();
		
	}
	
	static void addObjectsAndRetrieveObjects(Queue<BulkOrder> queue, 
			BulkOrder[] bulkOrders) {
		
		for (BulkOrder bulkOrder : bulkOrders) {
			queue.add(bulkOrder);
		}
		
		while(true) {
			BulkOrder bulkOrder = queue.poll();
			
			if(bulkOrder == null) {
				break;
			}
			
			System.out.println(bulkOrder);
		}
			
		
	}
	
}
