package bitManipulation;

// https://www.geeksforgeeks.org/bits-manipulation-important-tactics/
// https://www.geeksforgeeks.org/bitwise-hacks-for-competitive-programming/
// Following theory by anuj bhaiya

public class BitManipulation {
	public static void main(String[] args) {
		// xor operation : ^
		
		// right/ left shift operator
		System.out.println(12 >> 2);	// shifting bits of 12 right side 2 times
		System.out.println(12 << 2);	// shifting bits of 12 left side 2 times
		
		
		// right shift by 1 == dividing by 2; left shift == multiply by 2
		System.out.println(7 << 1);
		
		// check even/ odd : check only the last bit using masking by 1
		int e = 6;
		if((e & 1) == 0) System.out.println("Even no.");
		
		
		// Swap nos.
		int a = 8;
		int b = 3;
		
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a = " + a + " b = " + b);
		
		
		// To convert sequence into the number in decimal, without finding size of arr
		// int arr[] = {1, 0, 1} traversing arr = MSB to LSB
		
		// Approach 1: num = num * 2 + x
		// Approach 2: num = (num << 1) | x
 	}
	
}
