package priorityqueue.demo.complex.order;

import java.util.Comparator;

public class OrderBasedOnQuantityDescComparator 
	implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		
		if (o1.getQuantity() < o2.getQuantity()) {
			return +1;
		}else if (o1.getQuantity() > o2.getQuantity()) {
			return -1;
		}else {
			return 0;
		}
	}	
}
