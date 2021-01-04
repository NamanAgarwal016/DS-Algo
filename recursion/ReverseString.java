package recursion;

public class ReverseString {
	public static void main(String[] args) {

		reverse("reverse");
	}

	static void reverse(String s) {
		int n = s.length();
		if (n == 0) {
			System.out.println("String is empty");
			return;
		}

		reverse(s, n);
	}

	static void reverse(String s, int n) {

		if (n > 0) {
			System.out.print(s.charAt(n - 1));
			reverse(s, n - 1);
		} else
			return;
	}
}
