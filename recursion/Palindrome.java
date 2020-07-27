package recursion;

public class Palindrome {
	public static void main(String[] args) {
		
		String s = "naman";
		
		System.out.println(checkPalindrome(s, 0, s.length()-1));
	}

	static boolean checkPalindrome(String s, int l, int r) {
		
		if(s.length() == 0) return true;
		
		if(s.length() % 2 != 0) {
			if(l == r ) return true;
		}
		
		if(l+1 == r ) {
			if(s.charAt(l) == s.charAt(r)) return true;
			else return false;
		}
		
		if(s.charAt(l) != s.charAt(r)) return false;
		
		return checkPalindrome(s, l+1, r-1);
	}
}
