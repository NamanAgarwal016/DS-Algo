package randomQuestions;

import java.io.*;
import java.util.*;

public class Problem5 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCases; i++) {	

			int n = Integer.parseInt(br.readLine());
			int arr[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int countMax = 0;
			int previousRecord  = 0;
			for (int j = 0; j < n; j++) {
				
				// check for last no.
				if (j == n - 1) {
					if (arr[j] > previousRecord) {
						countMax++;
					}
					break;
				}

				if (arr[j] > arr[j + 1] ) {
					boolean isLargest = true;
					
					if (arr[j] > previousRecord) {
						countMax++;
					}
				}
				
				previousRecord = Math.max(arr[j], previousRecord);
			}

			System.out.println("Case #" + (i + 1) + ": " + countMax);

		}
	}
}
