package maps;

/*
 *  An obj is equal to another obj only if :
 *  either both have refrence of the same memory location, means memory location must be same for both obj, which can't happen for 2 diff obj
 *  other option is to ovveride hashCode and equals method of that class. 
 *  
 *  Eclipse provides implementation of hashcode and equal to modify acc to us.
 */


import java.util.HashSet;
import java.util.Set;

public class HashCodeAndEquals {

	public static void main(String[] args) {
		Pen pen1 = new Pen(10, "red");
		Pen pen2 = new Pen(10, "red");
		System.out.println(pen1 == pen2);
		System.out.println(pen1);
		System.out.println(pen2);
		
		System.out.println(pen1.equals(pen2));
		
		Set<Pen> pens = new HashSet<>();
		pens.add(pen1);
		pens.add(pen2);
		
		System.out.println(pens);

	}

}

class Pen {
	int price;
	String color;

	public Pen(int price, String color) {
		this.price = price;
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		Pen that = (Pen) obj; 							// casting the object into Pen object
		
		boolean isEqual = this.price == that.price && this.color.equals(that.color) ;
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		return price + color.hashCode();
	}
	
	// Many edge cases are not handled here. Can generate these directly from Eclipse
}
