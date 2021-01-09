package dynamicProgramming;

// https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9&ab_channel=AdityaVerma

import java.io.*;

//  Magical code using subset code; very slight variation

public class CountSubsetsOfGivenSum {
	static int dp[][];

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3 };
		int n = arr.length;
		int sum = 6;

		dp = new int[n + 1][sum + 1];

		int count = subsetSum(arr, n, sum);
		System.out.println(count);
	}

	
	// Top Down Approach
	static int subsetSum(int arr[], int n, int sum) {
		for (int j = 0; j <= sum; j++) {
			dp[0][j] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];		// Magic Line
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		return dp[n][sum];
	}
}