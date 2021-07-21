package heaps;

/*
 * heap is always a complete binary tree. So that we can denote heap as an ARRAY.
 * height = log(n) , n: no. of nodes
 * Max Heap: parent > both child
 * Min Heap: parent < both child
 * there can be repeating elements, no order in child
 * 
 * Node = i, parent = i/2, left_child = 2*i, right_child = 2*i + 1	(due to complete BT)
 * leaf nodes: [n/2 + 1 to n]
 * 
 * Insert operation (O[logn]): always first inserted as leftmost-bottomost leaf or as a last element in array.
 * then move it up by comparing parent.
 * 
 * Delete operation (O[logn]): always done on root node.
 * first delete root value, (first element of array)
 * replace it with last leaf, (last element of array)
 * now satisfy heap property: replace parent if it is smaller than largest child.
 * 
 * Heapify Algo (O[n]): to construct a new heap
 * using again & again insert operation takes nlogn, but heapify takes O[n]
 * algo is used to convert given array into heap array.
 * using propert that each subtree is itself maxHeap internally.
 * will start from last n/2 index, bcoz leaf nodes are itself maxHeaps.
 */

public class Heaps {
	public static void main(String[] args) {
		//Max Heap
		
		int heap[] = new int[1000];
		heap[0] = -1; // this is must for parent = i/2 to correctly work.
		
		//initial data
		heap[1] = 50; heap[2] = 30; heap[3] = 40; heap[4] = 10;
		heap[5] = 5; heap[6] = 20; heap[7] = 30;
 		
		print(heap);				//-1 50 30 40 10 5 20 30 
		
		insert(60, 7, heap);		//-1 60 50 40 30 5 20 30 10 
		insert(45, 8, heap);		//-1 60 50 40 45 5 20 30 10 30 
		
		delete(9, heap);			//-1 50 45 40 30 5 20 30 10
		delete(8, heap);			//-1 45 30 40 10 5 20 30 
		
		int arr[] = {-1, 10, 30, 50, 20, 35, 15};
		heapify(arr.length-1, arr);
	}
	
	static void insert(int val, int n, int heap[]) {
		n++;
		heap[n] = val;
		int curr = n, parent = curr/2;	//index
		
		while(curr > 1 && heap[parent] < heap[curr]) {
			//swap;
			int temp = heap[parent];
			heap[parent] = heap[curr];
			heap[curr] = temp;
			
			curr = parent;
			parent = curr/2;
		}
		
		print(heap);
	}
	
	static void delete(int n, int heap[]) {
		heap[1] = heap[n];
		heap[n] = 0;
		n--;
		
		int curr = 1;
		
		while(curr < n) {
			int larger = heap[2*curr] > heap[2*curr+1] ? 2*curr : 2*curr+1;
			
			if(heap[curr] > heap[larger])
				break;
			else {
				//swap
				int temp = heap[larger];
				heap[larger] = heap[curr];
				heap[curr] = temp;
				
				curr = larger;
			}
		}
		
		print(heap);
	}
	
	static void heapify(int n, int arr[]) {
		int curr = n/2;
		
		while(curr >= 1) {
			int larger;
			if(2*curr+1 > n)
				larger = 2*curr;
			else
				larger = arr[2*curr] > arr[2*curr+1] ? 2*curr : 2*curr+1;
			 
			if(arr[curr] < arr[larger]) {
				//swap
				int temp = arr[larger];
				arr[larger] = arr[curr];
				arr[curr] = temp;
			}
			curr--;
		}
		
		print(arr);
	}
	
	static void print(int heap[]) {
		for(int e: heap) {
			if(e == 0) break;
			else System.out.print(e + " ");
		}
		System.out.println();
	}
}
