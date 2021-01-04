package backtracking;

public class NQueens {
	public static void main(String[] args) {

		int n = 5;

		// random empty board
		int board[][] = new int[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = 0;
			}
		}

		solveNQueen(board, 0, n);

	}

	static boolean solveNQueen(int board[][], int i, int n) {
		// here i = row index, n = no. of queens = no. of total rows

		// Base Case
		if (i == n) {

			// You have successfully placed queens in n rows (o ... n-1)
			// print the board

			for (int i1 = 0; i1 < n; i1++) {
				for (int j = 0; j < n; j++) {
					if (board[i1][j] == 1) {
						System.out.print("Q ");
					} else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}

			System.out.println("\n\n");

			return false; // magic line due to which all possible arrangements are printing
		}

		// Recursive Case
		// Try to place the queen in the current row and call on the remaining part
		// which will be solved by recursion
		for (int j = 0; j < n; j++) {
			

			// check if i, j position is safe to place the queen or not.
			// just need to check in upper side part = uper col, right+left top diag

			if (isSafe(board, i, j, n)) {
				// place the queen - assuming i, j is right position
				board[i][j] = 1;

				boolean nextQueenRakhPayenge = solveNQueen(board, i + 1, n);
				if (nextQueenRakhPayenge) {
					return true;
				}

				// else condition, Means i, j is not the right position - assumption wrong
				board[i][j] = 0; // Backtrack
			}

		}

		// Can't place a queen in any position in this particular row
		return false;

	}

	static boolean isSafe(int board[][], int i, int j, int n) {

		// col check
		for (int row = 0; row < i; row++) {
			if (board[row][j] == 1) {
				return false;
			}
		}

		// left Diag check
		int x = i, y = j;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y--;
		}

		// right Diag check
		x = i;
		y = j;
		while (x >= 0 && y < n) {
			if (board[x][y] == 1) {
				return false;
			}
			x--;
			y++;
		}

		// position is now safe from col and diagonals
		return true;

	}
}