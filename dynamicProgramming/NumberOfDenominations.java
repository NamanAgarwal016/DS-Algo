package dynamicProgramming;

public class NumberOfDenominations {
	public static void main(String[] args) {
		int n = 4;
		int d[] = {1, 2};
		System.out.println("No. of possible ways to give change = " + numChange(n, d, d.length, 0));
		
	}

	static int numChange(int n, int d[], int k, int l) {
		// n = total amt for which change is asked, d[] = denomination array,
		// k = no. of elements in d[], l = start index in array

		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (k == 0)
			return 0;

		int option1 = numChange(n - d[l], d, k, l);
		int option2 = numChange(n, d, k - 1, l + 1);
		return option1 + option2;
	}
	
	static int numChange2(int n, int d[], int k, int l, int dp[][]) {		// more effecient, if calc is done then no need to repeat
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (k == 0 )
			return 0;
		
		if(dp[n][k] >= 0) {
			return dp[n][k];
		}
		
		int option1 = numChange2(n - d[l], d, k, l, dp);
		int option2 = numChange2(n, d, k - 1, l + 1, dp);
		
		// dynamic programming line
		dp[n][k] = option1 + option2;
		return dp[n][k] ;
		
	}
}
