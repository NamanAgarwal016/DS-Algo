package bitManipulation;

public class BitMasking {
	public static void main(String[] args) {
		
		// find ith bit in n:
		int n = 0b0110101;	
		int i = 5;
		int mask = 1 << i;
		if((n & mask) != 0) System.out.println("ith bit is 1");
		
		
		// set the ith bit to 1
		i = 4;
		mask = 1 << i;
		int a = 0b101111;
		a = a | mask;
		System.out.println(Integer.toBinaryString(a));
		
		
		// clear ith bit
		i = 4;
		mask = ~(1 << i);
		int b = 0b111111;
		b = b & mask;
		System.out.println(Integer.toBinaryString(b)); 
		
		
		// Find nos. of bits to change to convert a to b:
		a = 0b10100;
		b = 0b11011;
		n = a^b;
		// now ques changes to: 
		// how many times 1 appears in a number
		// using n & n-1 trick : it makes the least significant set(1) digit to 0
		// simply counting no. of times it takes the number to become zero.
		int count = 0;
		while(n != 0 ) {
			n = n & n-1;
			count++;
		}
		System.out.println("nos. of bits need to be changed: " + count);

	}
}
