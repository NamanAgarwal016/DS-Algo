package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {

	public static void main(String[] args) {
		
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		
		//Queue functions
		ad.addFirst(12);
		ad.addFirst(56);
		
		ad.pop();
		System.out.println(ad.peek());
		ad.pop();
		System.out.println(ad.isEmpty());
		
		//Stack functions
		// for stack, use :   Deque<Integer> stack = new ArrayDeque<Integer>();
		ad.push(1);
		ad.push(2);
		ad.push(3);
		
		System.out.println(ad.pop());
		System.out.println(ad.pop());
		System.out.println(ad.peek());
	
	}
}
