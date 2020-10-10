package DP;

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapSack01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int W = Integer.parseInt(br.readLine());
            int val[] = new int[n];
            int wt[] = new int[n];

            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            for(int i =0;i<n;i++){
                val[i] = Integer.parseInt(s1[i]);
                wt[i] = Integer.parseInt(s2[i]);
            }

            int [][] dp = new int [1002][1002];
            int res1 = knapsackWithMemo(wt,val,n,W,dp);
            int res = knapsack(wt,val,n,W);

            int res2 = knapSackTabulatioon(wt,val,n,W);
            System.out.println(res +" "+ res1+" "+res2);

        }
    }

    public static int knapsack(int[] wt,int[] val, int n, int W){
        if(n == 0 || W == 0)
            return 0;

        if(wt[n-1] <= W){
            return  Math.max(val[n-1] + knapsack(wt,val,n-1,W-wt[n-1]), knapsack(wt,val,n-1,W));
        }
        return knapsack(wt,val,n-1,W);
    }
    public static int knapsackWithMemo(int[] wt,int[] val, int n, int W,int[][] dp){
        if(n == 0 || W == 0)
            return 0;

        if(dp[n][W] != 0){return dp[n][W];}
        if(wt[n-1] <= W){
            dp[n][W] = Math.max(val[n-1] + knapsackWithMemo(wt,val,n-1,W-wt[n-1],dp), knapsackWithMemo(wt,val,n-1,W,dp));
            return dp[n][W];

        }
        dp[n][W] = knapsackWithMemo(wt,val,n-1,W,dp);
        return dp[n][W];
    }

    public static int knapSackTabulatioon(int[] wt, int [] val, int n, int W){
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=W; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1] <= j)
                    dp[i][j] = Math.max((val[i-1] + dp[i-1][j-wt[i-1]]) , dp[i-1][j] );
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];
    }
}