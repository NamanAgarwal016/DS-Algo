package dynamicProgramming;

// Aditya Verma Youtube dp playlist
// https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7

import java.io.*;

public class SubsetSum {
	static boolean dp[][];

	public static void main(String[] args) {
		int arr[] = { 1, 5, 5, 11 };
		int n = arr.length;
		int sum = 6;

		dp = new boolean[n + 1][sum + 1];

		boolean possible = subsetSum(arr, n, sum);
		System.out.println(possible);
	}

	// pure recursion
// 	static boolean subsetSum(int arr[], int n, int sum){
// 	    if(sum == 0) return true;

// 	    if(n == 0) return false;

// 	    if(arr[n-1] <= sum){
// 	        return subsetSum(arr, n-1, sum - arr[n-1]) || subsetSum(arr, n-1, sum);
// 	    } else {
// 	        return subsetSum(arr, n-1, sum);
// 	    }
// 	}

	// recursion + Memoization
//     static boolean subsetSum(int arr[], int n, int sum){
// 	    if(sum == 0) return true;

// 	    if(n == 0) return false;

// 	    if(dp[n][sum]) return dp[n][sum];

// 	    if(arr[n-1] <= sum){
// 	        return dp[n][sum] = subsetSum(arr, n-1, sum - arr[n-1]) || subsetSum(arr, n-1, sum);
// 	    } else {
// 	        return dp[n][sum] = subsetSum(arr, n-1, sum);
// 	    }
// 	}

	// Top Down Approach
	static boolean subsetSum(int arr[], int n, int sum) {
		for (int j = 0; j <= sum; j++) {
			dp[0][j] = false;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		return dp[n][sum];
	}
}