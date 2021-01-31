package dynamicProgramming;

public class KnapSack01 {
	public static void main(String[] args) {
		int val[] = {1,2,3}; int wt[] = {4,5,1};
		int ans = Knapsack.knapSack(4, wt, val, 3);
		System.out.println(ans);
	}
}

class Knapsack {
	// Returns the maximum value that can be put in a knapsack of capacity W

	static int knapSack(int W, int wt[], int val[], int n) {
		// Simple Recursive approach
//		 return knapSack1(W, wt, val, n);

		
		// Recursive + Memoization
		int dp[][] = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= W; j++)
				dp[i][j] = -1;
		 return knapSack2(W, wt, val, n, dp);
//
//		
//		// Top down approach
//		return knapSack3(W, wt, val, n);
	}

	static int knapSack1(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return 0;
		if (wt[n - 1] <= W) {
			return Math.max(val[n - 1] + knapSack1(W - wt[n - 1], wt, val, n - 1), knapSack1(W, wt, val, n - 1));
		} else {
			return knapSack1(W, wt, val, n - 1);
		}
	}

	static int knapSack2(int W, int wt[], int val[], int n, int dp[][]) {
		if (dp[n][W] != -1)
			return dp[n][W];

		if (n == 0 || W == 0)
			return dp[n][W] = 0;
		if (wt[n - 1] <= W) {
			return dp[n][W] = Math.max(val[n - 1] + knapSack2(W - wt[n - 1], wt, val, n - 1, dp),
					knapSack2(W, wt, val, n - 1, dp));
		} else {
			return dp[n][W] = knapSack(W, wt, val, n - 1);
		}
	}

	static int knapSack3(int W, int wt[], int val[], int n) {
		int dp[][] = new int[n + 1][W + 1];

		for (int j = 0; j <= W; j++)
			dp[0][j] = 0;
		for (int i = 0; i <= n; i++)
			dp[i][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][W];
	}
}