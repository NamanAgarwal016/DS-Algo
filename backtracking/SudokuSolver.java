package backtracking;

// Coding Ninjas Webinar : Backtracking

public class SudokuSolver {
	public static void main(String[] args) {

		int board[][] = {

				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 3, 0, 0, 9, 0, 4, 2, 6, 7 }, 
				{ 6, 8, 4, 0, 5, 7, 3, 0, 0 }, 
				{ 0, 9, 0, 0, 0, 1, 0, 2, 4 }, 
				{ 2, 0, 0, 7, 0, 8, 0, 0, 9 }, 
				{ 1, 4, 0, 5, 0, 0, 0, 3, 0 }, 
				{ 0, 0, 9, 6, 1, 0, 5, 4, 2 }, 
				{ 5, 3, 2, 4, 0, 9, 0, 0, 8 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				
		};
		
		System.out.println("Sudoku problem is: \n");
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		
		if(sudokuSolver(board)) {
			System.out.println("Solution for the above sudoku problem is: \n");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("Can't be solved");
		}
		
	}

	static boolean sudokuSolver(int board[][]) {

		// find the empty cell
		int row = -1;
		int col = -1;
		boolean isEmpty = false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == 0) {
					isEmpty = true;
					row = i;
					col = j;
					break;
				}
			}
			if (isEmpty)
				break;
		}

		if (!isEmpty)
			return true;

		for (int num = 1; num <= board.length; num++) {

			if (canPlaceNum(board, num, row, col)) {
				board[row][col] = num;
				if (sudokuSolver(board))
					return true;
				board[row][col] = 0;
			}
		}

		return false;
	}

	static boolean canPlaceNum(int board[][], int num, int row, int col) {

		if (!isRowSafe(board, num, row))
			return false;

		if (!isColSafe(board, num, col))
			return false;

		if (!isBoxSafe(board, num, row, col))
			return false;

		return true;
	}

	static boolean isRowSafe(int board[][], int num, int row) {
		for (int j = 0; j < board.length; j++) {
			if (board[row][j] == num)
				return false;
		}
		return true;
	}

	static boolean isColSafe(int board[][], int num, int col) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num)
				return false;
		}
		return true;
	}

	static boolean isBoxSafe(int board[][], int num, int row, int col) {
		int boxLength = (int) Math.sqrt(board.length);
		int rowStart = row - row % boxLength;
		int colStart = col - col % boxLength;

		for (int i = rowStart; i < rowStart + boxLength; i++) {
			for (int j = colStart; j < colStart + boxLength; j++) {
				if (board[i][j] == num)
					return false;
			}
		}
		return true;
	}

}
