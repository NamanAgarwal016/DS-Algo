package recursion;

public class MatrixFloodFill {
	public static void main(String[] args) {

		int a[][] = { 
				{ 1, 1, 1, 1, 2, 2, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 0, 0 }, 
				{ 1, 0, 0, 1, 1, 0, 1, 1 },
				{ 1, 2, 2, 2, 2, 0, 1, 0 }, 
				{ 1, 1, 1, 2, 2, 0, 1, 0 }, 
				{ 1, 1, 1, 2, 2, 2, 2, 0 },
				{ 1, 2, 1, 1, 1, 2, 1, 1 }, 
				{ 2, 2, 2, 1, 1, 2, 2, 1 }, 
					};

		print(a);
		
		floodFill(a, 4, 3, 9, 2);

		print(a);

	}

	private static void print(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;

		for (int i = 0; i < a.length; i++) {
			for (int x : a[i]) {
				System.out.print(" " + x);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void floodFill(int a[][], int r, int c, int toFill, int prevFill) {
		int rows = a.length;
		int cols = a[0].length;

		if (r < 0 || r >= rows || c < 0 || c >= cols)
			return;

		if (a[r][c] != prevFill)
			return;

		a[r][c] = toFill;

		floodFill(a, r - 1, c, toFill, prevFill); // upper
		floodFill(a, r + 1, c, toFill, prevFill); // bottom
		floodFill(a, r, c - 1, toFill, prevFill); // left
		floodFill(a, r, c + 1, toFill, prevFill); // right
	}
}
