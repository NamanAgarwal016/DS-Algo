package lists;

public class MyStack<E> {

	private MyLinkedList<E> ll = new MyLinkedList<E>();

	void push(E e) {
		ll.add(e);
	}

	void pop() throws Exception {

		if (ll.isEmpty()) {
			throw new Exception("Invalid Operation: Popping from empty stack");
		}
		
		ll.remove(ll.size() - 1);
		
	}

	E peek() throws Exception {

		if (ll.isEmpty()) {
			throw new Exception("Invalid Operation: Peeking on empty stack");
		}

		E e = ll.get(ll.size() - 1);

		return e;
	}

	boolean isEmpty() {
		if (ll.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {

		MyStack<Integer> stack = new MyStack<Integer>();

		// System.out.println(stack.pop());
		// System.out.println(stack.peek());
		
		System.out.println(stack.isEmpty());

		stack.push(25);
		stack.push(16);

		System.out.println(stack.peek());

		stack.pop();

		System.out.println(stack.peek());
		
		stack.pop();
		
		System.out.println(stack.isEmpty());

		System.out.println(stack.peek());
		
		System.out.println(stack.isEmpty());

	}

}
