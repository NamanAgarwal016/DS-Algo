package graphs_Algorithms;

// https://www.youtube.com/watch?v=zWS2fCJGxmU&ab_channel=codebix

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
	public static void main(String[] args) {
		int board[][] = { 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, 15, -1, -1, -1, -1 } 
			};
		
		int minSteps = snakesAndLadders(board);
		
		System.out.println("Min steps required: " + minSteps);
		
	}
	
	public static int snakesAndLadders(int board[][]) {
		int n = board.length;
		
		int steps = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean visited[][] = new boolean[n][n];
		
		q.add(1);
		visited[n-1][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				
				int x = q.poll();
				
				if(x == n*n) return steps; 		// Won the GAME!!
				
				// Throw the dice: k = 1 -> 6
				for(int k = 1; k <= 6; k++) {
					int newPos = k + x;
					
					if(newPos > n*n) break;   // moving out of board
					
					int pos[] = findCoordinates(newPos, n);
					int r = pos[0];
					int c = pos[1];
					
					if(visited[r][c] == true) continue;
					
					visited[r][c] = true;
					
					if(board[r][c] == -1) {
						q.add(newPos);
					} else {					// means there is a snake or a ladder
						q.add(board[r][c]);
					}
				}
			}
			
			steps++;
			
		}
		
		return -1;
	}
	
	// Func for mapping 2D array to real chess board
	public static int[] findCoordinates(int curr, int n) {
		int r = n - (curr-1) / n - 1;
		int c = (curr -1) % n;
		
		if(r%2 == n%2) {	
			return new int[] {r, n-1-c};
		} else {
			return new int[] {r, c};
		}
	}
}
