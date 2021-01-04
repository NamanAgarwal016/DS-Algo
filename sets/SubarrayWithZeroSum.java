package sets;

import java.util.HashSet;
import java.util.Set;

import jdk.nashorn.internal.ir.WithNode;

/*
 * Given an array, find number of subarray with sum equals to zero.
 *  n < 10^5
 *  subarray =  means elements should be in continuous manner.   Most imp confusion for me
 */

public class SubarrayWithZeroSum {

	public static void main(String[] args) {

		int a[] = { 2, -2, -3, 6, -3, 2, 1, -1, -2 };
		boolean found = false;

		/*
		 * ans for this array is: 6 zero Subarrays
		 * 2 -2
		 * -3 6 -3
		 * 1 -1
		 * 2 1 -1 2
		 * -3 2 1
		 * -3 6 -3 2 1 -1 -2
		 */
		
		// Raw method - doesn't work here due to time limit  
		// for finding if any such subarray exist
//		for(int i=0; i < a.length; i++) {
//			int sum = 0;
//			for(int j = i; j < a.length; j++) {
//				sum = sum + a[j];
//				if(sum == 0) {
//					found = true;
//					break;
//				}
//			}
//			if(found) break;
//		}

		// It will give sol in o[n^2]
		// Using sets we'll make it in o[n]

		// Concept : If there is any subarray with 0 sum then cumulative sum will repeat
		// atleast once.

		// if already a that sum is present (then false is returned by add func ) that
		// means, recently a sub array was hit with a zero sum

		Set<Integer> sumSet = new HashSet<Integer>();

		int sum = 0;
		int count = 0; 								// for counting no. of zero subarrays.
		sumSet.add(sum); 							// set will store sum after each iteration
		for (int i = 0; i < a.length; i++) {
			sumSet.add(sum); 						// set will store sum after each iteration

			sum += a[i];

			if (sumSet.contains(sum)) {
				found = true;
				count++;
			}

		}

		// this sol is in o[n], but it also takes extra space

		System.out.println("Zero Subarray found " + found + " with count = " + count);

	}

}
