package queue;

public class MyDeque<E> {
	
	Node<E> head, tail;
	
	public void addToHead(E data) {
		Node<E> toAdd = new Node<>(data);
		
		if(head == null) {
			head = tail = toAdd;
			return;
		}
		
		head.next = toAdd;
		toAdd.prev = head;
		head = toAdd;
		
	}
	
	public E removeLast() {
		
		if(head == null) {
			return null;
		}
		
		Node<E> toRemove = tail;
		tail = tail.next;
		
		
		if (tail == null) {
			head = null;
		}else {
			tail.prev = null;
		}
		
		return toRemove.data;
		
	}
	
	public static class Node<E>{
		E data;
		Node<E> next, prev;
		
		public Node(E data) {
			this.data = data;
			this.next = this.prev = null;
		}
	}
	
	public static void main(String[] args) {
		MyDeque<Integer> myDeque = new MyDeque<Integer>();
		myDeque.addToHead(16);
		myDeque.addToHead(17);
		myDeque.addToHead(19);
		myDeque.addToHead(12);
		myDeque.addToHead(11);
		
		System.out.println(myDeque.removeLast());
		System.out.println(myDeque.removeLast());
		System.out.println(myDeque.removeLast());
		System.out.println(myDeque.removeLast());
		System.out.println(myDeque.removeLast());
		System.out.println(myDeque.removeLast());
		
	}
	
}













