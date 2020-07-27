package recursion;

// soultion from coding ninjas India youtube channel

public class AllSubsequencesOfString {
	public static void main(String[] args) {

		// simply print all subsequences
		// printSubs("abc", "");

		// returning all subsequences
		for (String str : returnSubs("bc")) {
			System.out.println(str);
		}

		// code for returning Longest Palindromic subsequence
		String maxLengthPalindrome = "empty";
		int countMax = 0;

		for (String str : returnSubs("BBABCBCAB")) {
			if (Palindrome.checkPalindrome(str, 0, str.length() - 1)) {

				if (countMax < str.length()) {
					countMax = str.length();
					maxLengthPalindrome = str;
				}
			}
		}

		System.out.println("\nOne of the longest Palindromic sequence is: " + maxLengthPalindrome);
		
		
	}

	static void printSubs(String input, String outputSoFar) {
		if (input.length() == 0) {
			if (outputSoFar.length() == 0)
				return;
			System.out.println(outputSoFar);
			return;
		}
		// we choose not to include the first character
		printSubs(input.substring(1), outputSoFar);

		// we choose to include the first character
		printSubs(input.substring(1), outputSoFar + input.charAt(0));

	}

	static String[] returnSubs(String str) {

		if (str.length() == 0) {
			String ans[] = { "" };
			return ans;
		}

		String smallAns[] = returnSubs(str.substring(1));

		String ans[] = new String[2 * smallAns.length];

		// now filling our ans[] with smallAns[] elements + appending each element of
		// smallAns[] with first char of input string
		
		for (int i = 0; i < ans.length / 2; i++) {
			ans[i] = smallAns[i];
		}
		for (int i = ans.length / 2; i < ans.length; i++) {
			ans[i] = str.charAt(0) + smallAns[i - ans.length / 2];
		}

		return ans;

	}
}