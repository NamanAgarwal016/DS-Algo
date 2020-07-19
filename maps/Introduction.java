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

		numbers.putIfAbsent("ten", 7);
		System.out.println(numbers);
		System.out.println(numbers.keySet());
		System.out.println(numbers.values());
		System.out.println(numbers.entrySet());
		
		//Entry Set
		
		// to iterate over all entries of this entry Set
		
		Set<Entry<String, Integer>> entries = numbers.entrySet();
		// using for each loop
		for(Entry<String, Integer> entry: entries) {
			 entry.setValue(entry.getValue() * 10);
		}
		
		System.out.println(numbers);

	}
}
