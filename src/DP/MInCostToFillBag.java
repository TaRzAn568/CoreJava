package DP;

import java.io.*;
import java.util.*;
class MInCostToFillBag
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int cost[] = new int[n];
            for(int i = 0;i<n;i++)
                cost[i] = sc.nextInt();
            MInCostToFillBagSolution ob = new MInCostToFillBagSolution();
            System.out.println(ob.minimumCost(cost,n,w));
        }
    }
}    // } Driver Code Ends



class MInCostToFillBagSolution
{
    public int minimumCost(int cost[], int N,int W)
    {
        // Your code goes here
        int dp[][] = new int[N+1][W+1];


        for(int i=0; i<=N; i++)
            dp[i][0] = 0;

        for(int i=0; i<=W; i++)
            dp[0][i] = Integer.MAX_VALUE-1;


        for(int i=1; i<=N; i++){
            for(int j=1; j<=W; j++){

                if(i <= j){
                    dp[i][j] = Math.min(cost[i-1] + dp[i][j-i], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[N][W];
    }
}
