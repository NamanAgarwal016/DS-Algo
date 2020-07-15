package lists;

import java.util.Scanner;

public class BalanceTheBrackets {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter continuous series of brackets of any type: ");	
		String brackets = scanner.nextLine();
		scanner.close();

		if (checkIfBalanced(brackets)) {
			System.out.println("Balanced :)");
		} else {
			System.out.println("Na na, Not Balanced :( ");
		}

	}

	private static boolean checkIfBalanced(String brackets) throws Exception {

		char arr[] = brackets.toCharArray();

		MyStack<Character> stack = new MyStack<Character>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
				stack.push(arr[i]);
				continue;

			} else if (arr[i] == '}' || arr[i] == ']' || arr[i] == ')') {
				
				if(stack.isEmpty()) return false;

				char topOpenBracket = stack.peek();

				if (topOpenBracket == '{') {
					if (arr[i] == '}') {
						stack.pop();
						continue;
					} else
						return false;
				} else if (topOpenBracket == '[') {
					if (arr[i] == ']') {
						stack.pop();
						continue;
					} else
						return false;
				} else if (topOpenBracket == '(') {
					if (arr[i] == ')') {
						stack.pop();
						continue;
					} else
						return false;
				}

			} else {
				System.out.println("Bracket ka mtlb samj nhi aata kya >:( ");
				return false;
			}

		}
		
		return stack.isEmpty();

	}

}
