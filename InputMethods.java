import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputMethods {
	public static void main(String[] args) throws IOException{

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
		System.out.println(a+b + " string starts " + name + collegeString);
		
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int i = Integer.parseInt(br.readLine());
		// String s = br.readLine();
		
	}
}