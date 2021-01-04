package lists;

public class MyLinkedList<E> {

	public static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
			next = null;
		}
	}

	Node<E> head;

	public void add(E data) {

		Node<E> toAdd = new Node<E>(data);

		if (head == null) {
			head = toAdd;
			return;
		}

		Node<E> temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = toAdd;

	}

	public void print() {

		Node<E> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println("");

	}

	public E get(int index) {

		Node<E> temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	public void set(int index, E data) {

		Node<E> toAdd = new Node<E>(data);
		Node<E> temp = head;
		Node<E> prevTemp = head;

		if (index == 0) {
			toAdd.next = head;
			head = toAdd;

			return;
		}

		for (int i = 0; i < index; i++) {
			prevTemp = temp;
			temp = temp.next;
		}

		toAdd.next = temp;
		prevTemp.next = toAdd;

	}

	public void remove(int index) {

		Node<E> temp = head;
		Node<E> prevTemp = head;

		if (index == 0) {
			head = head.next;
			return;
		}

		for (int i = 0; i < index; i++) {
			prevTemp = temp;
			temp = temp.next;
		}

		prevTemp.next = temp.next;

	}

	public void printReverse(Node<E> head) {

		if (head == null)
			return;

		// print list of head node
		printReverse(head.next);
		// In recursion, once the last function is completed, it goes next to complete
		// the left lines of previous function
		// After everything else is printed
		System.out.print(head.data + " ");

	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {

		Node<E> temp = head;

		int count = 0;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;

	}

	public static void main(String[] args) {

		MyLinkedList<String> naman = new MyLinkedList<>();

		naman.add("16");
		naman.add("naman");
		naman.add("bits");
		naman.add("09");

		naman.print();

		System.out.println(naman.get(2));

		naman.set(0, "pilani");
		naman.print();

		naman.remove(0);
		naman.print();

		naman.printReverse(naman.head);

		System.out.println("");
		System.out.println(naman.size());

	}

}
