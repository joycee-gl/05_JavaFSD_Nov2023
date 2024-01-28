package queue.demo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		
		addElements(queue);
		displayQueue(queue);
				
		pollElement(queue);
		displayQueue(queue);
		
		peekElement(queue);
		displayQueue(queue);
		
		isEmpty(queue);
		
		removeElement(queue);
		displayQueue(queue);

		removeElement(queue);
		displayQueue(queue);
		
		removeAllElements(queue);
		isEmpty(queue);		
	}
	
	static void addElements(Queue<String> queue) {
		
		queue.add("A");
		queue.add("F");
		queue.add("G");
		queue.add("N");
		queue.add("T");
		queue.add("Y");		
	}
	
	
	static void pollElement(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Poll Element");
		
		String element = queue.poll();
		
		System.out.println("Element polled out from the Queue -> " + element);
	}
	
	
	static void displayQueue(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Queue - Display Elements");
		
		System.out.println(queue.toString());
	}

	static void peekElement(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Peek Element");
		
		String element = queue.peek();
		
		System.out.println("Element peek'ed out from the Queue -> " + element);
	}

	
	static void isEmpty(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Queue Empty : " + queue.isEmpty());
	}


	static void removeElement(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Remove Element");
		
		String element = queue.remove();
		
		System.out.println("Element removed from the Queue -> " + element);
	}
	
	static void removeAllElements(Queue<String> queue) {
		
		System.out.println();
		System.out.println("Clearing all the elements from the Queue");
		queue.clear();		
	}
	
}
