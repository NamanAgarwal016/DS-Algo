package gfgProblems;

// if length becomes 0 return 0 but if index becomes 0 and length is not equal to zero dn return 0 ,  
//instead return the minimum integer vaue,  and at last while giving the final answer check if the final 
//answwr is positive or negative, if its negative then it means rod wasnt filled fully.


public class MaximizeCut {

}


class Solution{
    public int maximizeCuts(int N, int x, int y, int z){
       int length[] = {x, y, z};
       return maxCut(N, length, 3);
    }
    
    public int maxCut(int N, int length[], int n){
        int dp[][] = new int[n + 1][N + 1];
        
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int j = 0; j <= N; j++) dp[0][j] = Integer.MIN_VALUE;
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= N; j++){
                if(length[i-1] <= j){
                    dp[i][j] = Math.max(1 + dp[i][j - length[i-1]], dp[i-1][j]);
                    
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return  (dp[n][N] >= 0) ? dp[n][N] : 0;
    }
}