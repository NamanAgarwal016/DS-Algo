package heaps;

/*
 * heap is always a complete binary tree. So that we can denote heap as an ARRAY.
 * height = log(n) , n: no. of nodes
 * Max Heap: parent > both child
 * Min Heap: parent < both child
 * there can be repeating elements, no order in child
 * 
 * Node = i, parent = (i-1)/2, left_child = 2*i+1, right_child = 2*i + 2	(due to complete BT)
 * leaf nodes: [n/2 to n-1]
 * 
 * Insert operation (O[logn]): always first inserted as leftmost-bottomost leaf or as a last element in array.
 * then move it up by comparing parent.
 *  direction is upwards.
 * 
 * Delete operation (O[logn]): always done on root node.
 * first delete root value, (first element of array)
 * replace it with last leaf, (last element of array)
 * now satisfy heap property: replace parent if it is smaller than largest child.
 * direction is downwards.
 * 
 * Heapify Algo (O[n]): to construct a new heap
 * opposite direc to insertion
 * using again & again insert operation takes nlogn, but heapify takes O[n]
 * algo is used to convert given array into heap array.
 * using propert that each subtree is itself maxHeap internally.
 * will start from last n/2 index, bcoz leaf nodes are itself maxHeaps.
 * direction is downwards.
 */

public class Heaps {
	public static void main(String[] args) {
		int arr[] = {10, 2, 30, 50, 20, 35, 15};
		heapSort(arr);

		//insert 40 in the given max-heap[], in place of -1(always in last)
		int heap[] = {50, 20, 35, 2, 10, 30, 15, -1};
		insertion(heap, 40);
	}

	//HeapSort: creating heap using heapify, then deletion of elements
	//sorting in ascending order
	// No extra space: in-place sorting algo
	// Not a stable algo, duplicates will not maintain same relative position
	// will work for all int[]: duplicates, -ve, +ve, 0
	static void heapSort(int arr[]) {
		int n = arr.length;

		int heap[] = arr;
		print(heap);

		//creating a MaxHeap using heapify mtd
		heapify(heap);
		print(heap); 

		//Now deletion & storing
		for(int i = n-1; i >= 2; i--)
			heap[i] = deletion(heap, i);
		swap(heap, 0, 1);	//for the starting 2 elements, just a swap needed

		print(heap);
	}

	static void heapify(int heap[]) {
		int n = heap.length;
		for(int i = n/2 -1; i >= 0; i--) {
			adjustNodeDownwards(heap, i, n);  //adjusting ith node in heap size of n;
		}
	}

	static int deletion(int heap[], int last) {
		swap(heap, 0, last);
		int i = 0;
		int n = last;		//len of heap[] is reduced now

		//Now adjust the disturbed heap[]:
		adjustNodeDownwards(heap, i, n);

		//Now just returning the deleted element
		return heap[last];
	}

	static void adjustNodeDownwards(int heap[], int i, int n) {
		int node = heap[i];
		int left = heap[2*i + 1];
		int right = 2*i+2 <= n-1 ? heap[2*i + 2] : -1;		//bcoz right may exist may not

		while(node < Math.max(left, right)) {
			if(left >= right) {
				swap(heap, i, 2*i+1);
				i = 2*i+1;
			}
			else if(right > left) {
				swap(heap, i, 2*i+2);
				i = 2*i+2;
			}
			if(i > n/2 -1)
				break;
			node = heap[i];
			left = heap[2*i + 1];
			right = 2*i+2 <= n-1 ? heap[2*i + 2] : -1;
		}
	}
	
	//here length will increase, as ele is inserted
	// before passing, inc heap[] size by 1, put -1 at the last
	static void insertion(int heap[], int val) {
		int n = heap.length;
		heap[n-1] = val;

		int i = n-1;
		int node = heap[i];
		int parent = heap[(i-1)/2];

		while(node > parent) {
			swap(heap, i, (i-1)/2);
			i = (i-1)/2;
			node = heap[i];
			parent = heap[(i-1)/2];
		}

		//print the final heap[]
		print(heap);
	}

	static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void print(int heap[]) {
		for(int e: heap) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
