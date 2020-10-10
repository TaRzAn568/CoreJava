package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumDiffSubset {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int a[] = new int[n];

            String[] s1 = br.readLine().split(" ");

            for(int i =0;i<n;i++){
                a[i] = Integer.parseInt(s1[i]);
            }
        System.out.println(new MinimumDiffSubsetSolution().minDiffernce(a,n));

        }
    }
}

class MinimumDiffSubsetSolution
{
    int min = Integer.MAX_VALUE;
    public int minDiffernce(int arr[], int n)
    {
        if(n==1) return arr[0];

        //minDiffMemoization(arr,n);

        return minDiffTable(arr,n);

        // return min;
    }
    int minDiffTable(int[] arr, int n){

        int sum = 0;

        for(int x : arr)
            sum += x;

        boolean [][]dp = new boolean [n+1][(sum/2)+1];
        for(int i=0; i<=sum/2;i++){
            dp[0][i] = false;
        }
        for(int i=0; i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum/2;j++){
                if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int min_diff = Integer.MAX_VALUE;
        for(int i=1 ;i<=sum/2; i++){
            int temp = Math.abs((sum - i)-i);
            if(dp[n][i] &&  temp < min_diff){
                min_diff = temp;
            }
        }
        return min_diff;

    }


    void minDiffMemoization(int arr[], int n){
        min = Integer.MAX_VALUE;
        int sum = 0;

        for(int x : arr)
            sum += x;
        for(int i=sum/2;i>0;i--)  {
            boolean [][] dp = new boolean[n+1][i+1];
            int diff = minDiffUtil(arr,n,i,dp) ? Math.abs((sum - i)-i) : sum;
            if(diff < min)
                min = diff;
        }
    }


    public boolean minDiffUtil(int[] a,int n, int sum,boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(n == 0 && sum != 0){
            return false;
        }

        if(dp[n][sum]) return dp[n][sum];

        if(a[n-1] <= sum){
            dp[n][sum] = minDiffUtil(a,n-1,sum-a[n-1],dp) ||
                    minDiffUtil(a,n-1,sum,dp);
        }else{
            dp[n][sum] = minDiffUtil(a,n-1,sum,dp);

        }
        return dp[n][sum];
    }
}

