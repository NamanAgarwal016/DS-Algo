package queue;

public class MyQueue<E> {

	// same node as earlier, also can import and use
	public static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	private Node<E> head, rear;

	public void enqueue(E e) {

		Node<E> toAdd = new Node<>(e);

		if (head == null) {
			head = rear = toAdd;
			return;
		}

		rear.next = toAdd;
		rear = rear.next;

	}

	public E dequeue() {

		if (head == null) {
			return null;
		}

		Node<E> toRemove = head;
		head = head.next;

		if (head == null) {
			rear = null;
		}
		return toRemove.data;
	}

	public E peek() {

		if (head == null) {
			return null;
		}

		Node<E> toPeek = head;

		return toPeek.data;
	}

	public static void main(String[] args) {

		MyQueue<Integer> q = new MyQueue<Integer>();
		q.enqueue(15);
		q.enqueue(5);
		q.enqueue(45);
		q.enqueue(18);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.peek());

	}

}
