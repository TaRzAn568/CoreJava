package DP;

import java.io.*;
import java.util.*;

/*https://practice.geeksforgeeks.org/problems/number-of-coins1824/1*/
class MinimumCoinNeedForChange
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for(int i = 0;i<m;i++)
                coins[i] = sc.nextInt();
            MinimumCoinNeedForChangeSolution ob = new MinimumCoinNeedForChangeSolution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}    // } Driver Code Ends


class MinimumCoinNeedForChangeSolution{

    public int minCoins(int coins[], int M, int V)
    {
        // Your code goes here
        int [][] dp = new int[M+1][V+1];
        int y = minCoinRecursive(coins,M,V,dp);
        System.out.println(y+" ");
        int x = minCoinBottomUp(coins, M, V);
        return x == Integer.MAX_VALUE-1 ? -1 : x;


    }

    int minCoinRecursive(int coins[], int M, int V, int[][] dp){
        if(V == 0) return 0;

        if(M==0 && V != 0) return Integer.MAX_VALUE-1;

        if(dp[M][V] != 0) return dp[M][V];
        if(coins[M-1] <= V){
            dp[M][V] = Math.min((1+minCoinRecursive(coins,M,V-coins[M-1],dp)),
                    (minCoinRecursive(coins,M-1,V,dp)));
            return dp[M][V];
        }
        dp[M][V] = minCoinRecursive(coins,M-1,V,dp);
        return dp[M][V];
    }


    int minCoinBottomUp(int coins[], int M, int V){

        int [][]dp = new int[M+1][V+1];

        for(int i=0;i<=V;i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=0;i<=M;i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=M;i++){
            for(int j=1; j<=V;j++){
                if(coins[i-1] <= j){

                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] =  dp[i-1][j];
                }
            }
        }
        return dp[M][V];
    }

}