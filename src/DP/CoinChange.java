package DP;

import java.io.*;
import java.util.*;


/*https://practice.geeksforgeeks.org/problems/coin-change2448/1*/
class CoinChange
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for(int i = 0;i<m;i++)
                Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr,m,n));
        }
    }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public long count(int S[], int m, int n)
    {   long [][] dp = new long[m+1][n+1];
        return countRecursive(S,m,n,dp);



    }


    long countRecursive(int[]S,int m,int n,long[][] dp){
        if(n==0) return 1;
        if(m==0 && n!=0) return 0;

        if(dp[m][n] != 0) return dp[m][n];

        if(S[m-1] <= n){
            dp[m][n] = countRecursive(S, m,n-S[m-1],dp) + countRecursive(S,m-1,n,dp);
            return dp[m][n];
        }
        dp[m][n] = countRecursive(S,m-1,n,dp);
        return dp[m][n];


    }
}