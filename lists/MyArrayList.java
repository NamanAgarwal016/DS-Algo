package lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyArrayList {
	
	public static void main(String[] args) {
		
		List<String> fruits = new LinkedList<String>();
		ArrayList<String> vegetables = new ArrayList<String>();
		
		//Various Functions on lists
		
		//add
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		System.out.println(fruits);
		
		vegetables.add("Potato");
		vegetables.add("Tomato");
		
		//addAll
		fruits.addAll(vegetables);
		System.out.println(fruits);
		
		//get
		System.out.println(fruits.get(3));
		
		//set
		fruits.set(3, "Bhindi");
		System.out.println(fruits);
		
		//remove
		fruits.remove(0);
		System.out.println(fruits);
		
		//size
		System.out.println(fruits.size());
		
		//contains
		System.out.println(fruits.contains("Mango"));
		
		//toArray
		String temp[] = new String[fruits.size()];
		fruits.toArray(temp);
		for(String e: temp) {
			System.out.println(e);
		}
		
		//removeAll
		List<String> toRemoveList = new ArrayList<String>();
		toRemoveList.add("Orange");
		toRemoveList.add("Tomato");
		 
		fruits.removeAll(toRemoveList);
		System.out.println(fruits);
		
		//clear
		fruits.clear();
		System.out.println(fruits);
		
		//isEmpty
		System.out.println(fruits.isEmpty());
		
		//Generic Pair Class
		Pair<String, Integer> p1 = new Pair<>("Naman", 16);
		Pair<Boolean, String> p2 = new Pair<>(true, "Bits");
		p1.getDescriptio();
		p2.getDescriptio();
		
	}

}
