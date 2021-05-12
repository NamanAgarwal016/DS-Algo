package bitManipulation;

//https://youtu.be/bTauscvOymA?list=PLUcsbZa0qzu3yNzzAxgvSgRobdUUJvz7p

public class XOR {
	public static void main(String[] args) {
		
		/*Properties
		 * a^a = 0
		 * 0^a = a
		 * if a^b = c then a^c = b
		 */
		
		//XOR operations
		//Q1. Find the only non-repeating element in an array where every other element repeats twice. - 
		int a[]  = {5,4,1,4,3,5,1}; 
		
		//soln: Xor each element, using both properties
		int res = 0;					// 5^4^1^4 = 5^1
		for(int e: a) res = res ^ e;
		System.out.println(res); 		// ans: 3
		
		
		//Q2. Find the two non-repeating elements in an array where every other element repeats twice. - 
		int b[]  = {5,4,1,4,3,5,1,2};
		res = 0;					
		for(int e: b) res = res ^ e;
		// then see video
		
		//Q3. Find the only non-repeating element in an array where every other element repeats thrice. - 
		int c[] = {2,2,1,5,1,1,2};
		//same mtd won't work as xor mtd works on binary repetation	
		int count[] = new int[32];
		// then see video
		
	}
}
