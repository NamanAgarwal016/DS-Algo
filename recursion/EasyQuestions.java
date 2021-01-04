package recursion;

public class EasyQuestions {

	static int stepCount = 0;

	public static void main(String[] args) {
		System.out.println(sum(100));

		System.out.println(power(2, 20) + " step count = " + stepCount);
		
		stepCount = 0;
		System.out.println("\nValue of b in each step in fastPower method: ");
		System.out.println(fastPower(2, 20) + " step count = " + stepCount);
		
		System.out.println("\nNo. of paths in a matrix = " + path(4, 2));
	}

	static int sum(int n) {
		if (n == 1) {
			return 1;
		}

		return n + sum(n - 1);
	}

	static int power(int a, int b) {
		stepCount++;
		if (b == 0) {
			return 1;
		} 
		return a * power(a, b-1);
	}
	
	static int fastPower(int a, int b) {
		System.out.println(b);
		stepCount++;
		if (b == 0) {
			return 1;
		} 
		if(b%2 == 0) {
			return fastPower(a*a, b/2);
		}
		return a * fastPower(a, b-1);
	}
	
	static int path(int n, int m) {
		if(n == 1 || m == 1) {
			return 1;
		}
		return path(n, m-1) + path(n-1, m);
	}

}
