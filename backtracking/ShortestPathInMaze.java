package backtracking;

// https://www.youtube.com/watch?v=S3rnLLHl0PM&ab_channel=ApniKaksha

public class ShortestPathInMaze {
	public static void main(String[] args) {
		
		int a[][] = { 
				
		//	      0  1  2  3  4  5  6  7  8  9
				
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, 
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1}, 
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1}, 
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1}, 
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1}, 
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, 
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1}, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0}, 
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, 
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1}, 
				
					};
		
		int b[][] = { 
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};	
		
		int result = shortestPath(b, 0, 0, 3, 3);
		if( result >= 100000) {
			System.out.println("No path poosible");
		} else {
			System.out.println("Shortest path contains " + result + " steps");
		}
		
		
	}
	
	static int shortestPath(int a[][], int i, int j, int x, int y) {
		int rows = a.length;
		int cols = a[0].length;
		
		boolean isVisted[][] =  new boolean[rows][cols];	// 2D array of type boolean
		
		return shortestPath(a, i, j, x, y, isVisted);
		
	}
	
	static int shortestPath(int a[][], int i, int j, int x, int y, boolean isVisted[][]) {
		
		if(!isValid(a, i, j, isVisted)) return 100000;
		
		if(i == x && j == y) {
			
			// To print all possible paths
			
			isVisted[x][y] = true;
			for(int h = 0; h < isVisted.length; h++) {
				for(int k = 0; k < isVisted[0].length; k++) {
					System.out.print("\t" + isVisted[h][k] + " ");
				}
				System.out.println();
			}
			isVisted[x][y] = false;
			System.out.println("\n\n\n");
			
			// printing code over
					
			return 0;
		}
		
		isVisted[i][j] = true;
		
		int left = shortestPath(a, i, j-1, x, y, isVisted) + 1;
		int right = shortestPath(a, i, j+1, x, y, isVisted) + 1;
		int top = shortestPath(a, i-1, j, x, y, isVisted) + 1;
		int bottom = shortestPath(a, i+1, j, x, y, isVisted) + 1;
		
		// This is the magically Backtracking line 
		isVisted[i][j] = false;
		
		return Math.min(Math.min(left, right), Math.min(top, bottom));
	}
	
	static boolean isValid(int a[][], int i, int j, boolean isVisted[][]) {
		int rows = a.length;
		int cols = a[0].length;
		
		return  i >=0 && i < rows 	&&
				j >=0 && j < cols 	&&
				a[i][j] == 1 		&&
				!isVisted[i][j]		;
	}
	
}
