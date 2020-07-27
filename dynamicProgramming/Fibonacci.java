package dynamicProgramming;

//Coding Ninjas Webinar : DP

public class Fibonacci {
	public static void main(String[] args) {
		int n = 10;
		
		int arr[] = new int[n+1];
		for(int e: arr) e = 0;
		System.out.println(fib2(n, arr));
		
		System.out.print(fib3(n + 1));
		
	}
	
	static int fib(int n) {				// time complexiy = exponential of n ; 2^n function calls
		if(n == 0 || n == 1) {			// space = O[n] ; recursion takes space
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
	
	static int fib2(int n, int arr[]) {		// time complexiy = O[n] ; 2n function calls
		if(n == 0 || n == 1) {
			return 1;
		}
		if(arr[n] > 0) {
			return arr[n];
		}
		arr[n] = fib2(n-1, arr) + fib2(n-2, arr);
		return arr[n];
	}
	
	static int fib3(int n) {			// time complexiy = O[n] ; without recursion
		int arr[] = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
}
