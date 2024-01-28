package juicemachine.milkshakes;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class JuiceMachinePriorityQueueProcessor {
	
	//two orders from the priority queue
	//bulkOrder1
	//bulkOrder2
	
	private BulkOrder[] bulkOrders;
	private Result result;
	private Queue<BulkOrder> orderProcessingQueue;
	
	
	public JuiceMachinePriorityQueueProcessor(BulkOrder[] bulkOrders) {
		this.bulkOrders = bulkOrders;
		this.result = new Result();
		
		BulkOrderComparator bulkOrderComparator = new BulkOrderComparator();
		this.orderProcessingQueue = new PriorityQueue<BulkOrder>(bulkOrderComparator);
	}
	
	public Result process() {
		
		processInternal();
		
		return result;
	}
	
	private void processInternal() {
		
		for(BulkOrder bulkOrder : bulkOrders) {
			
			System.out.printf("BulkOrder : %s ", bulkOrder.toString());
			System.out.println();
			
			orderProcessingQueue.add(bulkOrder);
		}
		
		Iterator<BulkOrder> iterator = orderProcessingQueue.iterator();
		while(!orderProcessingQueue.isEmpty()) {
			
			BulkOrder firstBulkOrder = null;
			if(iterator.hasNext()) {
				firstBulkOrder = orderProcessingQueue.remove();
			}
			
			BulkOrder secondBulkOrder = null;
			if(iterator.hasNext()) {			
				secondBulkOrder = orderProcessingQueue.remove();
			}
			
			int orders1 = 0;
			int orders2 = 0;
			
			orders1 = firstBulkOrder.getNumberOfOrders();
			orders2 = secondBulkOrder.getNumberOfOrders();
			
			if(orders1 > 0 && orders2 > 0) {
				
				//process two orders
				processTwoOrders(firstBulkOrder, secondBulkOrder);
				
			} else {
				
				if(firstBulkOrder != null && firstBulkOrder.hasActiveOrders()) {
					
					if(secondBulkOrder != null && secondBulkOrder.hasNoOrders()) {
						processSingleOrder(firstBulkOrder);
					} 
				 
				} else {
					
					if(secondBulkOrder != null && secondBulkOrder.hasActiveOrders()) {
						
						if(firstBulkOrder != null && firstBulkOrder.hasNoOrders()) {
							processSingleOrder(secondBulkOrder);
						}
					}
				}
				
			}
			
			if(orders1 == 0 && orders2 == 0) {
				result.setStatus(OrderProcessingStatus.DONE);
			}
			
			if(result.isDone()) {
				
				break;
			} else {
				
				orderProcessingQueue.add(firstBulkOrder);
				orderProcessingQueue.add(secondBulkOrder);
				
			}
			
		}
		
	}

	private void processSingleOrder(BulkOrder bulkOrder) {
		if(bulkOrder == null) {
			return;
		}
		
		System.out.printf("Processing order : %s ", bulkOrder);
		System.out.println();
		
		int orders = bulkOrder.getNumberOfOrders();
		result.incrementNoOfSeconds(orders);
		
		System.out.printf("Incrementing time by %d seconds ", orders);
		System.out.println();
		
		result.setStatus(OrderProcessingStatus.DONE);
	}

	private void processTwoOrders(BulkOrder firstBulkOrder, BulkOrder secondBulkOrder) {
		System.out.printf("Processing orders : %s & %s",
				firstBulkOrder, secondBulkOrder);
		System.out.println();
		
		result.incrementNoOfSeconds(1);
		System.out.println("Incrementing time by 1 second ");
		
		firstBulkOrder.decrementOrdersBy(1);
		secondBulkOrder.decrementOrdersBy(1); 
		
	}
	

}
