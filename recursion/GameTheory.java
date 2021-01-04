package recursion;

public class GameTheory {

	public static void main(String[] args) {
		
		int a[] = { 1, 3, 700, 2, 9, 10, 500, 50};
		
		System.out.println("Maximum Which you can earn : " + coinMax(a, 0, a.length-1));
	}

	static int coinMax(int a[], int l, int r) {
		if (l + 1 == r) {
			return Math.max(a[l], a[r]);
		}

		return Math.max(
				a[l] + Math.min(coinMax(a, l + 2, r), coinMax(a, l + 1, r - 1)) ,
				a[r] + Math.min(coinMax(a, l + 1, r - 1), coinMax(a, l, r - 2))
				);
	}
}
