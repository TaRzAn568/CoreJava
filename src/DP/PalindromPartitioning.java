package DP;

import java.io.*;
import java.util.*;

class PalindromPartitioning{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            PalindromPartitioningSolution ob = new PalindromPartitioningSolution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class PalindromPartitioningSolution{
    static int palindromicPartition(String str)
    {
        int [][]dp = new int[str.length()+1][str.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j] = -1;
            }
        }
        return util(str,0,str.length(),dp);


    }

    static int util(String s, int i, int j,int[][] dp){
        if(i>=j || isPalin(s,i,j))
            return 0;
        else{

            if(dp[i][j] != -1) return dp[i][j];
            int min = Integer.MAX_VALUE;
            int cost = 0;
            for(int k=i+1;k<j;k++){
               cost  = 1 + util(s,i,k,dp) + util(s,k,j,dp) ;
                //System.out.println(cost);
                if(cost < min){
                    min = cost;
                }
            }


            return dp[i][j] = min;
        }
    }

    static boolean isPalin(String s, int i, int j){
        boolean res = true;


        while(i<j){
            if(s.charAt(i) != s.charAt(j-1)){
                return false;
            }
            i++;
            j--;
        }
        return res;
    }

}
