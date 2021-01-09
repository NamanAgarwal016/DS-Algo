package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Introduction {
	public static void main(String[] args) {

		Map<String, Integer> numbers = new HashMap<String, Integer>();
		numbers.put("one", 1);
		numbers.put("seven", 7);
		numbers.put("ten", 10);
		
		System.out.println(numbers.get("one"));
		System.out.println(numbers);
		numbers.put("ten", 7);
		System.out.println(numbers);
		System.out.println(numbers.keySet().toArray()[1]);
		System.out.println(numbers.values());
		System.out.println(numbers.entrySet());
		
		//Entry Set
		
		// to iterate over all entries of this entry Set
		
		Set<Entry<String, Integer>> entries = numbers.entrySet();
		// using for each loop
		for(Entry<String, Integer> entry: numbers.entrySet()) {
			 entry.setValue(entry.getValue() * 10);
		}
		
		System.out.println(numbers + " naman");
		
		for(Map.Entry<String, Integer> entry : numbers.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
	}
}
