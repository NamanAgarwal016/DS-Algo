package randomQuestions;

import java.util.*;
import java.util.Map.Entry;

public class Problem3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int ques[] = new int[n];

		for (int i = 0; i < n; i++) {

			ques[i] = sc.nextInt();

		}
		
		Arrays.sort(ques);

		Map<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			int x = ques[i];

			if (!map.containsKey(x)) {
				map.put(x, 1);
			} else {
				int count = map.get(x);
				count++;
				map.put(x, count);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}

		Collections.sort(ans);

		Set<Integer> set = new HashSet<Integer>();

		for (int s : ans) {
			set.add(s);
		}

		int sum = 0;
		for (int x : set) {
			sum = sum + x;
		}

		System.out.println(sum);

	}
}
