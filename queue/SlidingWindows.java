package queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindows {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int a[] = {4, 3, 1, 2, 5, 3, 4, 7, 1, 9};
		int ans[] = solution.maxSlidingWindow(a,4);
		
		for(int x: ans) {
			System.out.print(x + " ");
		}
		
	}
	
	static class Solution{
		public int[] maxSlidingWindow(int a[], int k) {
			int n = a.length;
			if(n <= 1) return a;	// handling empty and single element array cases
			Deque<Integer> dq = new LinkedList<Integer>();	// double ended queue for making that window which will slide
			
			int ans[] = new int[n-k+1];
			
			int i=0;	//for index
			
			for(; i<k; i++) {		// Fill first K nos. in the queue
				while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {		// to fill it with index of elements in descending order
					dq.removeLast();
				}
				dq.addLast(i);
			}
			
			for(; i<n; i++) {		// now filling with shifting window by 1 element
				ans[i-k] = a[dq.peekFirst()];		// ans array = first element(Largest) of window each time
 				
				while(!dq.isEmpty() && dq.peekFirst() <= i-k) {		// remove any index in window which is now not coming in current window
					dq.removeFirst();
				}
				while(!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {		// same as earlier, line 30
					dq.removeLast();
				}
				dq.addLast(i);
			}
			
			ans[i-k] = a[dq.peekFirst()];		// for adding the last iteration element, as 38th line will not work bcoz of i=n
			
			return ans;
			
		}
	}
	
}