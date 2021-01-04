package dynamicProgramming;

// Coding Ninjas Webinar : DP

public class MinStepsToOne {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Min Steps required: " + minSteps(n));
		System.out.println("Min Steps required: " + minSteps2(n));

		int arr[] = new int[n+1];
		for(int e: arr) e = 0 ;
		System.out.println("Min Steps required: " + minSteps3(n, arr));

		System.out.println("Min Steps required: " + minSteps4(n));
	}
	
	static int minSteps(int n) {		// Greedy solution ; will give wrong ans
		if(n == 1) return 0;
		
		if(n%3 == 0) return minSteps(n / 3) + 1;
		
		if(n%2 == 0) return minSteps(n / 2) + 1;
		
		return minSteps(n-1) + 1; 
	}
	
	static int minSteps2(int n) {		// gives correct ans, but many repetitve func calls; use DP to improve
		if(n == 1) return 0;
		
		int ans = minSteps2(n-1) + 1 ;
		
		if(n % 2 == 0) {
			ans = Math.min(ans, minSteps2(n/2) + 1);
		}
		
		if(n % 3 == 0) {
			ans = Math.min(ans, minSteps2(n/3) + 1);
		}
		
		return ans;
	}
	
	static int minSteps3(int n, int arr[]) {		//improved Sol; Top down approach; use bottom-up approach to improve
		if(n == 1) return 0;
		
		if(arr[n] > 0) {
			return arr[n];
		}
		
		int ans = minSteps3(n-1, arr) + 1 ;
		
		if(n % 2 == 0) {
			ans = Math.min(ans, minSteps3(n/2, arr) + 1);
		}
		
		if(n % 3 == 0) {
			ans = Math.min(ans, minSteps3(n/3, arr) + 1);
		}
		
		arr[n] = ans;
		
		return ans;
	}
	
	static int minSteps4(int n) {		//improved Sol; bottom-up approach : Hard to visualize from beginning; No recursion required
		if(n == 1) return 0;				// no time complexity diff bw minstep4 and minstep3 ;  little more effecient
		int arr[] = new int[n+1];
		arr[0] = 1;
		arr[1] = 0;	// Base case
		
		for(int i = 2; i <= n; i++) {
			int ans = arr[i-1] + 1 ;
			
			if(i % 2 == 0) {
				ans = Math.min(ans, arr[i/2] + 1);
			}
			
			if(i % 3 == 0) {
				ans = Math.min(ans, arr[i/3] + 1);
			}
			arr[i] = ans;
		}
		
		return arr[n];
	}
}
