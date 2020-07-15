package queue;

//k largest elements
//Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.

import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		//instead of regular For loop: 
		//    for(int i = 0; i < testCases; i++){
		// use while loop : 
		while(testCases-- != 0){
		    
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    
		    int arr[] = new int[n];
		    
		    for(int i = 0; i < n; i++){
		        arr[i] = sc.nextInt();
		    }
		    
		    PriorityQueue<Integer> list = new PriorityQueue<Integer>();
		    
		    for(int i = 0; i < k; i++){
		        
		        list.add(arr[i]);
		    }
		    
		    for(int i = k; i < n; i++){
		        
		        if(list.peek() < arr[i]) {
		            list.remove();
		            list.add(arr[i]);
		        }
		    }
		    
		    
		    //Method 1
		    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		    
		    for(int i = 0; i < k; i++){
		        stack.push(list.remove());
		    }
		    
		    for(int i = 0; i < k; i++){
		        System.out.print(stack.pop() + " ");
		    }
		    
		    System.out.println("");
		    
		    //Method 2
//		    ArrayList<Integer> ans = new ArrayList<>(list);
//		    Collections.sort(ans, Collections.reverseOrder());
//		    for(int x: ans) {
//		    	System.out.println(x + " ");
//		    }
//		    System.out.println();
		    
		}
		
		sc.close();
		
	}
}