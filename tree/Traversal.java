package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Traversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("\nHeight of tree is : " + height(root));

		System.out.print("Inorder Traversal : ");
		inorder(root);
		System.out.print("\nPreorder Traversal : ");
		preorder(root);
		System.out.print("\nPostorder Traversal : ");
		postorder(root);
		System.out.print("\nLevelorder Traversal : ");
		levelorder3(root);
	}

	// calculate height of tree
	static int height(Node root) {
		if (root == null)
			return 0;

		int heightLeft = height(root.left);
		int heightRight = height(root.right);

		return Math.max(heightLeft + 1, heightRight + 1);
	}

	// BFS : Breadth first traversal

	static void levelorder(Node root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}

	/* Print nodes at the given level */
	static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.key + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	// alternate mtd of bfs
	static void levelorder2(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.key + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
	
	// Same mtd, but executing level wise 
	static void levelorder3(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
            int cls = q.size(); //curr_level_size
            
            for(int i=0; i < cls; i++){
                Node curr = q.poll();
                System.out.print(curr.key + " ");
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            //System.out.println();
        }
	}
	
	// DFS : Depth first traversal

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}

	static void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.key + " ");
		preorder(root.left);
		preorder(root.right);
	}

	static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.key + " ");
	}

	static class Node {
		int key;
		Node left, right;

		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
}
