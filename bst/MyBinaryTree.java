package bst;

public class MyBinaryTree<E> {

	public static class TreeNode<E>{
		E data;
		TreeNode<E> left, right;
		
		public TreeNode(E data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public void createBinaryTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(1);
		root.left = new TreeNode<Integer>(2);
		root.right = new TreeNode<Integer>(3);
		
		root.left.left = new TreeNode<Integer>(4);	
	}
	
	public static void main(String[] args) {
		MyBinaryTree<Integer>  myBt = new MyBinaryTree<Integer>();
		myBt.createBinaryTree();
	}
	
}


