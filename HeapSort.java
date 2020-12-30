
// https://www.youtube.com/watch?v=HqPJF2L5h9U&ab_channel=AbdulBari

// Creating heap : O[n * logn] ; using Heapify procedure: O[n]
// Deleting all nodes from heap :  O[n * logn]
// heap sort = creating then deleting : 2 * O[n * logn] = O[n * logn]

// inserting a node in heap =  O[logn]
// deleting a node in heap =  O[logn]

// Code works on all +/-/equal elements

// Here assuming the indexing starts at 1

public class HeapSort {
	public static void main(String[] args) {

		int ques[] = { 10, 20, 15, 12, 40, 25, 18 };

		heapSort(ques);
	}

	private static void heapSort(int[] ques) {
		int n = ques.length;
		int ans[] = new int[n];

		// Create Max Heap, Starting index of array from 1, instead of 0
		for (int i = 1; i <= n; i++) {
			insert(ques[i - 1], ans, i);

			// Using heapify method to create heap:
			// ans = heapify(ques, n - i + 1);
		}

		System.out.println("printing Max Heap: ");
		for (int e : ans)
			System.out.print(e + " ");

		// Deleting the elements, Starting index of array from 1, instead of 0
		// Sorting needs to be done only for n-1 element
		for (int i = 1; i <= n - 1; i++) {

			int deletedNode = ans[0];
			ans[0] = ans[n - i];

			// using recursion, moving the node to its correct place, moving downward
			moveDownward(ans[0], ans, 1, n - i);

			// Store deleted node at the last
			ans[n - i] = deletedNode;
		}

		System.out.println("\n\nprinting Sorted Array: ");
		for (int e : ans)
			System.out.print(e + " ");
	}

	private static void insert(int currentNode, int[] ans, int index) {
		// using recursion, moving the node to its correct place, moving upward
		moveUpward(currentNode, ans, index);
	}

	private static void moveUpward(int currentNode, int[] ans, int index) {
		// Base condition
		if (index == 1) {
			ans[index - 1] = currentNode;
			return;
		}

		if (ans[index / 2 - 1] >= currentNode) {
			ans[index - 1] = currentNode;
			return;
		}

		ans[index - 1] = ans[index / 2 - 1];
		moveUpward(currentNode, ans, index / 2);
	}

	private static int[] heapify(int ans[], int index) {
		int length = ans.length;
		int currentNode = ans[index - 1];

		// Base condition 1
		if (length < 2 * index) {
			return ans;
		}
		// Base condition 2
		if (length < 2 * index + 1) {
			if (currentNode >= ans[2 * index - 1]) {
				return ans;
			}
			ans[index - 1] = ans[2 * index - 1];
			ans[2 * index - 1] = currentNode;
			return ans;
		}
		// Base condition 3
		if (currentNode >= ans[2 * index - 1] && currentNode >= ans[2 * index + 1 - 1]) {
			return ans;
		}

		// find largest child index
		int indexOfLargestChild = 2 * index;
		if (ans[2 * index - 1] < ans[2 * index + 1 - 1])
			indexOfLargestChild = 2 * index + 1;

		ans[index - 1] = ans[indexOfLargestChild - 1];
		ans[indexOfLargestChild - 1] = currentNode;

		return heapify(ans, indexOfLargestChild);
	}

	private static void moveDownward(int currentNode, int[] ans, int index, int length) {
		// Base condition 1
		if (length < 2 * index) {
			ans[index - 1] = currentNode;
			return;
		}
		// Base condition 2
		if (length < 2 * index + 1) {
			if (currentNode >= ans[2 * index - 1]) {
				ans[index - 1] = currentNode;
				return;
			}
			ans[index - 1] = ans[2 * index - 1];
			ans[2 * index - 1] = currentNode;
			return;
		}
		// Base condition 3
		if (currentNode >= ans[2 * index - 1] && currentNode >= ans[2 * index + 1 - 1]) {
			ans[index - 1] = currentNode;
			return;
		}

		// find largest child index
		int indexOfLargestChild = 2 * index;
		if (ans[2 * index - 1] < ans[2 * index + 1 - 1])
			indexOfLargestChild = 2 * index + 1;

		ans[index - 1] = ans[indexOfLargestChild - 1];
		ans[indexOfLargestChild - 1] = currentNode;

		moveDownward(currentNode, ans, indexOfLargestChild, length);
	}
}
