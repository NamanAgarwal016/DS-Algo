package randomQuestions;

// More efficient sol by Binary Search Algorithm

public class Problem1 {
	public static void main(String[] args) {
		
		int a[][] = {
				{0, 0, 0, 1, 1},
				{0, 1, 1, 1, 1},
				{0, 0, 0, 0, 1},
				{0, 0, 1, 1, 1},
				};
		
		System.out.println("index Of Largest Row is: " + findMaxRowIndex(a));
		
	}
	
	static int findMaxRowIndex(int a[][]) {
		
		int maxIndex = 0, max = 0, loopCount = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			int count = 0;
			
			for(int j = 0; j < a[i].length; j++) {
				loopCount++;
				if(a[i][j] == 1) {
//					count++;		// more time complexity, O[n*m]
					count = a[i].length - j;		// by first occurence of 1, to reduce time complexity
					break;
				}
			}
			
			if(max < count) {
				max = count;
				maxIndex = i;
			}
		}
		
		System.out.println("loopCount = " + loopCount);
		
		return maxIndex;
	}
}
