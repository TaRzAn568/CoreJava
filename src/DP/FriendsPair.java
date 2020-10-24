package DP;

import java.io.*;
        import java.util.*;
class FriendsPair
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            FriendsPairSolution ob = new FriendsPairSolution();
            System.out.println(ob.countFriendsPairings(n));
        }
    }
}    // } Driver Code Ends


//User function Template for Java

class FriendsPairSolution
{
    public long countFriendsPairings(int n)
    {
        //code here
        if(n == 1) return 1;
        if(n == 2) return 2;
            int mod = 1000000007;
        long a[] = new long [n+1];
        a[1] = 1;
        a[2] = 2;
        for(int i=3; i<n+1;i++)
        {
            a[i] = (a[i-1] + (i-1)* a[i-2]) % mod;
        }
        return a[n] ;
    }
}
