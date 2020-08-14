package randomQuestions;

import java.util.*;

public class Problem4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n == 0) {
			System.out.println("0");
			return;
		} else {
			sc.nextLine();
			int countPairs = 0;
			
			Set<String> set = new HashSet<String>();
			
	        for(int i = 0; i < n; i++){
	            String str = sc.nextLine();
	            char a[] = str.toCharArray();
	            Arrays.sort(a);
	            str = new String(a);
	            if(set.contains(str)) {
	            	countPairs++;
	            } else {
	            	set.add(str);
				}
	            
	        }
	       System.out.println(countPairs); 
		}
	}
}
