package randomQuestions;

import java.util.*;
import java.util.Map.Entry;

public class Problem2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> ans = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			if(!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				int count = map.get(s);
				count++;
				map.put(s, count);
			}
		}
		
		int maxValueInMap=(Collections.max(map.values())); 
		
		for (Entry<String, Integer> entry : map.entrySet()) {  
            if (entry.getValue()==maxValueInMap) {
                ans.add(entry.getKey());     
            }
        }
		
		Collections.sort(ans);
		
		for(String s: ans) {
			System.out.println(s);
		}

	}
}
