package backtracking;

// https://www.youtube.com/watch?v=EgoKDqfpbMg&ab_channel=Pepcoding

public class KnightTour {
	public static void main(String[] args) {

		int n = 5;
		int board[][] = new int[n][n];

		knightTour(board, n, 2, 0, 1);
	}

	private static void knightTour(int[][] board, int n, int i, int j, int move) {

		if (!isValid(board, n, i, j))
			return;

		if (move == n * n) {
			board[i][j] = move;

			// print ans
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					System.out.print(board[a][b] + "\t");
				}
				System.out.println("\t");
			}

			System.out.println("\n\n\n");

			board[i][j] = 0;
			return;
		}

		board[i][j] = move;

		knightTour(board, n, i - 2, j + 1, move + 1);
		knightTour(board, n, i - 1, j + 2, move + 1);
		knightTour(board, n, i + 1, j + 2, move + 1);
		knightTour(board, n, i + 2, j + 1, move + 1);
		knightTour(board, n, i + 2, j - 1, move + 1);
		knightTour(board, n, i + 1, j - 2, move + 1);
		knightTour(board, n, i - 1, j - 2, move + 1);
		knightTour(board, n, i - 2, j - 1, move + 1);

		board[i][j] = 0;

		return;
	}

	static boolean isValid(int[][] board, int n, int i, int j) {

		return i >= 0 && i < n && j >= 0 && j < n && board[i][j] == 0;
	}
}
