package gfgProblems;

import java.util.Scanner;

public class RodCutting {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0){
		    int N = sc.nextInt();
		    int length[] = new int[N];
		    for(int i = 0; i < N; i++) length[i] = i+1;
		    int price[] = new int[N];
		    for(int i = 0; i < N; i++) price[i] = sc.nextInt();
		    
		    System.out.println(rodCut(N, length, price, N));
		}
	}
	
	static int rodCut(int N, int length[], int price[], int n){
        int dp[][] = new int[n + 1][N + 1];
        
        for(int j = 0; j <= N; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= N; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j - length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][N];
    }
}

