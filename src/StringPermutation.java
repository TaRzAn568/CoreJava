/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


//https://practice.geeksforgeeks.org/problems/total-number-of-strings/0
class StringPermutation {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){

            int n = Integer.parseInt(br.readLine());
            long result = 0;

            result = 1+ 2*permutation(n,1)+(3*permutation(n,2)+permutation(n,3))/2;

            System.out.println(result);
            System.out.println((2+n*n*n+3*n)/2);

        }

    }
    /**
     * only a's -> 1
     * ------------------------------------------------------------------------
     * (n-1)a's and 1c => n!/(n-1)! => n*(n-1)!/(n-1)! => n
     * ------------------------------------------------------------------------
     * (n-1)a's and 1b => n!/(n-1)! => n*(n-1)!/(n-1)! => n
     * ------------------------------------------------------------------------
     * (n-2)a's and 2c => n!/(n-2)!*2! => n*(n-1)*(n-2)!/(n-2)!*2 => n*(n-1)/2
     * ------------------------------------------------------------------------
     * (n-2)a's and 1b and 1c => n!/(n-2)! => n*(n-1)*(n-2)!/(n-2)! => n*(n-1)
     * ------------------------------------------------------------------------
     * (n-3)a's and 1b and 2c => n!/(n-3)!*2! => n*(n-1)*(n-2)*(n-3)!/(n-3)!*2 => n*(n-1)*(n-2)/2

     Finally add them all 1 + (2*n) + (n*(n - 1) / 2) + (n*(n - 1)) + (n*(n - 1)*(n - 2) / 2)
     */

    public static long permutation(int n, int r){
        long res = 0;
        if(n>=r) {
            res = factorial(n) / factorial(n - r);
        }
        return res;
    }

    public static long factorial(int n){
        long res = 1;
        while(n>0)
        {
            res = res*n;
            n--;
        }
        return res;
    }
}
