package randomQuestions;

import java.util.*;

class RoughWork {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.left = new Node(3);
		node.right = new Node(2);

		Tree tree = new Tree();
		ArrayList<Integer> ans = tree.reverseLevelOrder(node);
		for (int e : ans)
			System.out.print(e + " ");
	}

}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class Tree {
	public ArrayList<Integer> reverseLevelOrder(Node node) {
		// code here
		ArrayList<Integer> ans = new ArrayList<>();

//		 int h = findHeight(node);
//
//		 for(int i = h; i >= 1; i--){
//		 printLevelOrder(node, i, ans);
//		 }

		// Alternate solution by stack:
		Stack<Integer> stack = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			stack.push(curr.data);

			if (curr.right != null)
				q.add(curr.right);
			if (curr.left != null)
				q.add(curr.left);
		}

		for(int i=0; i<stack.size()+2; i++) {
			System.out.println(i);
			ans.add(stack.pop());
		}

		return ans;
	}
	
	public int findHeight(Node node){
        if(node == null) return 0;
        
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public void printLevelOrder(Node node, int level, ArrayList<Integer> ans){
        if(node == null) return;
        if(level == 1){
            ans.add(node.data);
            return;
        } 
        
        if(level > 1){
            printLevelOrder(node.left, level - 1, ans);
            printLevelOrder(node.right, level - 1, ans);
        }
    }
}