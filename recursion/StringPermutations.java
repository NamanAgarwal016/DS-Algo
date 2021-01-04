package recursion;

import java.util.*;

public class StringPermutations {

	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {

		permutations("aabc", 0, 3);
	}

	static void permutations(String s, int l, int r) {
		if (l == r) {
			if (set.contains(s))
				return;
			set.add(s);
			System.out.println(s);
			return;
		}

		for (int i = l; i <= r; i++) {
			s = interchangeChar(s, i, l);
			permutations(s, l + 1, r);
			s = interchangeChar(s, i, l);
		}
	}

	static String interchangeChar(String s, int i, int l) {
		char arr[] = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[l];
		arr[l] = temp;
		return new String(arr);
	}
}
