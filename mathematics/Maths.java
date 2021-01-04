package mathematics;

import java.util.Arrays;

public class Maths {
	public static void main(String[] args) {
		
		// to find all prime in till n
//		int n = 20;
//		boolean[] isPrime = sieveOfEratosthenes(n);
//		for(int i = 1; i <= n; i++) {
//			System.out.println(i + " : " + isPrime[i]);
//		}
		
		// to find GCD of two numbers  : gcd(a,b) = gcd(b, a%b)   <-- imp property  --> a*b = LCM * GCD 
//		System.out.println("GCD of nos. is : " + gcd(24, 36));
		
		// fast method to calculate power
		System.out.println(fastPower(2, 10));
	}
	
	static int fastPower(int a, int b) {
		if(b == 1) return a;
		if(b%2 == 0) {		// instead of b%2, use : for odd b, b&1 = true
			return fastPower(a*a, b/2);
		}
		return a * fastPower(a, b-1);
	}
	
	static boolean[] sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i = 2; i*i <= n; i++) {
			for(int j = 2*i; j <= n; j = j + i) {
				isPrime[j] = false;
			}
		}
		
		return isPrime;
	}
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
