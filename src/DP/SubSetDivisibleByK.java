package DP;

import java.util.*;
import java.lang.*;
import java.io.*;
class SubSetDivisibleByK
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String a = br.readLine().trim();
            String[] a1 = a.split(" ");
            int n = Integer.parseInt(a1[0]);
            int m = Integer.parseInt(a1[1]);
            String b = br.readLine().trim();
            String[] b1 = b.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < b1.length; i++)
                nums[i] = Integer.parseInt(b1[i]);
            SubSetDivisibleByKSolution ob = new SubSetDivisibleByKSolution();
            int ans = ob.DivisibleByM(nums, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class SubSetDivisibleByKSolution
{
    public int DivisibleByM(int [] nums, int m)
    {
        // Code here
        if(nums.length == 1){
            if(nums[0] % m == 0){
                return 1;
            }
            else{
                return 0;
            }
        }
        int total=0;
        for(int i=0;i<nums.length;i++)
            total += nums[i];

        int dp[][] = new int[nums.length+1][total+1];
        for(int x[] :dp){
            Arrays.fill(x,-1);
        }
        return solve(nums, m, nums.length-1,0,dp);
    }
    public int  solve(int [] a, int m, int n,int sum, int[][] dp){
        if(sum%m == 0 && sum != 0){
            return 1;
        }
         if(n < 0)
            return 0;

        if(dp[n][sum] != -1) return dp[n][sum];

        return dp[n][sum] = (solve(a,m,n-1,sum+a[n],dp) | solve(a,m,n-1,sum,dp));


    }
}