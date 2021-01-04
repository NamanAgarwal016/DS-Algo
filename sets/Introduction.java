package sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Introduction {
	public static void main(String[] args) {

		Set<String> fruits = new HashSet<String>();

		// Order not maintained, returns boolean

		fruits.add("Banana");
		fruits.add("Apple");
		System.out.println(fruits.add("Kiwi"));
		System.out.println(fruits.add("Kiwi"));
		System.out.println(fruits);

		Set<String> fruits1 = new LinkedHashSet<>();

		// Order is maintained
		
		fruits1.add("Mango");
		fruits1.add("Apple");
		fruits1.add("Kiwi");
		System.out.println(fruits1);

		Set<String> fruits2 = new TreeSet<>();

		// Elements is sorted fashion

		fruits2.add("Mango");
		fruits2.add("Apple");
		fruits2.add("Kiwi");
		System.out.println(fruits2);
		
		// Operations of Set
		
		Set<Integer> x = new HashSet<>();
		x.add(23);
		x.add(1);
		x.add(6);
		Set<Integer> y = new HashSet<>();
		y.add(3);
		y.add(1);
		y.add(16);
		
		x.addAll(y); System.out.println(x);			// Union of sets
		System.out.println(x.containsAll(y)); 		// Subset or not  
		x.retainAll(y); System.out.println(x);		// Intersection of sets

	}
}
