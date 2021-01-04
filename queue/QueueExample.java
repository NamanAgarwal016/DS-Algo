package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		//q.remove();    // throws exception
		System.out.println(q.poll());  // doesn.t throw exception, gives null
		
		q.add(12);
		q.add(24);
		q.add(56);
		
		System.out.println(q);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		System.out.println(q.element());
		
		
	}
}
