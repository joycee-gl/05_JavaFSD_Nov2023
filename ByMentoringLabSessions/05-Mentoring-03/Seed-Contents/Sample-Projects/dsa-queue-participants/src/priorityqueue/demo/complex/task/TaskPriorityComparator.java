package priorityqueue.demo.complex.task;

import java.util.Comparator;

public class TaskPriorityComparator implements Comparator<Task>{

	@Override
	public int compare(Task t1, Task t2) {
		
		TaskPriority tp1 = t1.getPriority();
		TaskPriority tp2 = t2.getPriority();		
		
		if (tp1.getPriority() > tp2.getPriority()) {
			return -1;
		}else if (tp1.getPriority() < tp2.getPriority()) {
			return +1;
		}else {			
			return 0;
		}			
	}

}
