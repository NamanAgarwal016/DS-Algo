package dynamicProgramming;

// Geeks for geeks
// Given a sequence, find the length of the longest palindromic subsequence in it.

public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String seq = "GEEKSFORGEEKS";
		int n = seq.length();

		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = 0;
			}
		}
		System.out.printf("The length of the LPS is %d", lps2(seq.toCharArray(), 0, n - 1, arr));

	}

	// A utility function to get max of two integers
	static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	// Returns the length of the longest palindromic subsequence in seq
	static int lps(char seq[], int i, int j) {
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;

		// If the first and last characters match
		if (seq[i] == seq[j])
			return lps(seq, i + 1, j - 1) + 2;

		// If the first and last characters do not match
		return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}

	static int lps2(char seq[], int i, int j, int arr[][]) { // top down fashion; less effecient dp approach ; bottom up
																// is more faster
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;

		if (arr[i][j] > 0)
			return arr[i][j];

		// If the first and last characters match
		if (seq[i] == seq[j]) {
			arr[i][j] = lps(seq, i + 1, j - 1) + 2;
			return arr[i][j];
		}

		// If the first and last characters do not match
		arr[i][j] = max(lps(seq, i, j - 1), lps(seq, i + 1, j));
		return arr[i][j];
	}

	static int lps(String seq) {			// Bottom up; best dp solution
		
		int n = seq.length();
		int i, j, cl;
		// Create a table to store results of subproblems
		int L[][] = new int[n][n];

		// Strings of length 1 are palindrome of length 1
		for (i = 0; i < n; i++) {
			L[i][i] = 1;
		}
		
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
	}
}
