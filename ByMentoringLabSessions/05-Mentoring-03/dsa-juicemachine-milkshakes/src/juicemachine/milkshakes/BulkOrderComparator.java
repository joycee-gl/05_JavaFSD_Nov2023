package juicemachine.milkshakes;

import java.util.Comparator;

public class BulkOrderComparator implements Comparator<BulkOrder>{
	
	public int compare(BulkOrder o1, BulkOrder o2) {
		
		//Descending order - number of orders
		
		if(o1.getNumberOfOrders() < o2.getNumberOfOrders()) {
			return +1;
		} else if (o1.getNumberOfOrders() > o2.getNumberOfOrders()) {
			return -1;
		} else {
			return 0;
		}
		
	}

}
