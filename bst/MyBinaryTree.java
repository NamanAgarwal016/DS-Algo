package bst;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
	static Node root;

	// Driver function
	public static void main(String[] args) {

		// formation of tree
		root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(9);
		root.left.left = new Node(7);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		// print inorder traversal
		inorder(root);

		insert(root, 12);
		System.out.println("\n\nAfter insertion");
		inorder(root);

		deleteNode(root, 10);
		System.out.println("\n\nAfter deletion");
		inorder(root);

	}

	// printing in inorder traversal using recursion
	static void inorder(Node root) {
		if (root == null)					// base condition
			return;

		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	// insert node
	static void insert(Node root, int key) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp;
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new Node(key);
				break;
			} else
				q.add(temp.left);

			if (temp.right == null) {
				temp.right = new Node(key);
				break;
			} else
				q.add(temp.right);
		}
	}

	// delete node, by replacing it with bottommost-rightmost node
	static void deleteNode(Node root, int key) {
		Node target = findNode(root, key);
		Node deepest = findBottomRightmostNode(root);

		target.key = deepest.key;

		deleteDeepestNode(root);
	}

	// find specific node
	static Node findNode(Node root, int key) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		Node temp;
		Node keyNode = null;

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.key == key) {
				keyNode = temp;
				break;
			}
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		}

		return keyNode;
	}

	// find rightmost bottom node
	static Node findBottomRightmostNode(Node root) {
		Node temp = root;

		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}

	// Delete deepest rightmost node
	static void deleteDeepestNode(Node root) {
		Node temp = root;

		while (temp.right.right != null) {
			temp = temp.right;
		}

		temp.right = null;
	}

	// create node class
	public static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

}
