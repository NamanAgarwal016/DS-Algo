package sortingAlgo;

// Recursive : https://www.youtube.com/watch?v=Dl6HT-NM_q4
// Iterative : https://youtu.be/ACfwCEGzPnM

import java.util.Stack;

// for iterative: Storing starting & ending index of subarray in an explicit stack, Partition logic same as recursive

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 2, 6, 9, 2, 1, 0, 3 };

		quickSortInterative(arr, 0, arr.length - 1);

		for (int e : arr)
			System.out.print(e + " ");
	}

	public static void quickSort(int arr[], int l, int r) {
		if (l < r) {
			int pi = partition(arr, l, r);		// pivot index

			quickSort(arr, l, pi - 1);
			quickSort(arr, pi + 1, r);
		}
	}
	
	public static void quickSortInterative(int arr[], int l, int r) {
		// create an auxiliary stack
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(l);	// push initial values of l & h in stack
		stack.push(r);
		
		while(!stack.isEmpty()) {
			r = stack.pop();
			l = stack.pop();
			
			int pi = partition(arr, l, r);		// 	set pivot element at its correct position
			
			// if there are elements on left side of pivot, push them first
			if(pi - 1 > l) {
				stack.push(l);
				stack.push(pi - 1);
			}
			
			// Now push right side elements of pivot if available
			if(pi + 1 < r) {
				stack.push(pi + 1);
				stack.push(r);
			}
		}
	}

	public static int partition(int arr[], int l, int r) {
		int pivot = arr[r];

		int i = l - 1;

		for (int j = l; j < r; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i + 1, r);
		return i + 1;
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
