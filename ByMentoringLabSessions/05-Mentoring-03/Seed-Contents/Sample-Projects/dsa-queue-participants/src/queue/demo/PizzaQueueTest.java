package queue.demo;

import java.util.LinkedList;
import java.util.Queue;

public class PizzaQueueTest {

	private static Queue<String> peopleQueuePizza = new LinkedList<>();
	
	public static void main(String[] args) {
		
		enqueue("Punith");
		enqueue("Indrajith");
		enqueue("Sweta");

		dequeue();
		dequeue();
		
		enqueue("Zaheer");
		enqueue("Zeena");
		enqueue("Alia");
		
		dequeue();
		dequeue();
		dequeue();
		dequeue();
		
		
		dequeue();
		dequeue();
		dequeue();
	}
		
	private static void enqueue(String person) {
	
		System.out.println("Person " + person + " joined the Pizza Queue");
		peopleQueuePizza.add(person);		
	}
	
	
	private static void dequeue() {
		
		String personToBeServiced = peopleQueuePizza.poll();
		
		if (personToBeServiced != null) {
			System.out.println("Person to be serviced with Pizza is " + personToBeServiced);			
		}else {
			System.out.println("Queue is empty");
		}		
	}
}
