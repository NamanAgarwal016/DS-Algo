import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputMethods {
	public static void main(String[] args) throws IOException {

		// Scanner class Experiments
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter any no.");
//		int a = sc.nextInt();
//		System.out.println("Enter name");
//		sc.nextLine();
//		String name = sc.nextLine();
//		int b = sc.nextInt();
//		sc.nextLine();
//		String collegeString = sc.nextLine();
//		System.out.println(a+b + " string starts " + name + collegeString);

		// BufferedReader Class experiments
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter any no.");
		int a = Integer.parseInt(br.readLine());
		System.out.println("Enter name");
		String name = br.readLine();
		int b = Integer.parseInt(br.readLine());
		String collegeString = br.readLine();
		System.out.println(a + b + " string starts " + name + collegeString);

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int i = Integer.parseInt(br.readLine());
		// String s = br.readLine();

		String s = "6, 2, 4, 9, 56";
		int arr[] = new int[5];
		StringTokenizer st = new StringTokenizer(s, ", ");
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int e : arr)
			System.out.println(e);

//		StringTokenizer st = new StringTokenizer("my name is khan", " ");
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
	}
}
