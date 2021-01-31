package dynamicProgramming;

public class UnboundedKnapsack {

}

class Solution{
    
    
    static int knapSack(int n, int W, int val[], int wt[]){
        //Simple Recursive approach
        // return knapSack1(W, wt, val, n);
        
        // //Top down approach
        return knapSack3(W, wt, val, n);
    }
    
    static int knapSack1(int W, int wt[], int val[], int n){
        if(n == 0 || W == 0) return 0;
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapSack1(W - wt[n-1], wt, val, n), knapSack1(W, wt, val, n-1));
        } else {
            return knapSack1(W, wt, val, n-1);
        }
    }
    
    static int knapSack3(int W, int wt[], int val[], int n){
        int dp[][] = new int[n + 1][W + 1];
        
        for(int j = 0; j <= W; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][W];
    }
}