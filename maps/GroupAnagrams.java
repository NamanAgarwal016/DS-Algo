package maps;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		
		String ques[] = {"dog", "eat", "god", "ate", "cat", "tea", "act", "naman", "manan"};
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for(String s: ques) {
			char arr[] = s.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);
			if(!map.containsKey(sorted )) {
				map.put(sorted, new LinkedList<String>());
			} 
			map.get(sorted).add(s);
		}
		
		List<List<String>> ans = new LinkedList<>(map.values());
		System.out.println(ans);
		
	}
}
