package sets;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array, find if there exists a subarray with sum equals to k
 *  n < 10^5
 */

public class SubarrayWithVariableSum {

	public static void main(String[] args) {

		int a[] = { 2, 3, 6, -3 };
		int k = 9;
		boolean found = false;

		// Using sets we'll make it in o[n]

		// Concept : If there is any subarray with sum k, then cumulative sum will
		// .......

		Set<Integer> sumSet = new HashSet<Integer>();

		int sum = 0;

		for (int i = 0; i < a.length; i++) {
			sumSet.add(sum); // set will store sum after each iteration

			sum += a[i];

			if (sumSet.contains(sum - k)) {
				found = true;
				break;
			}

		}

		System.out.println(" found " + found);
	}
}
