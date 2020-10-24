package DP;

import java.util.*;
import java.lang.*;
import java.io.*;

class BooleanExpression {
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            BooleanSolution ob = new BooleanSolution();
            int  dp[][] = new int [str.length()][str.length()];
            for(int[] x : dp)
                Arrays.fill(x,-1);
            //System.out.println(ob.booleanExpression(str,0,str.length()-1,dp));
            ob.booleanExpression(str,0,str.length()-1,dp);
            System.out.println(BooleanSolution.val);
        }
    }

}

class BooleanSolution{
    static int val ;
    boolean booleanExpression(String s, int i, int j,int[][] dp){
        if(i >= j-2 || i == j){
            if(i == j)  return s.charAt(i) == 'T' ? true : false;
            return check(s,i,j);
        }else{
           /* if(dp[i][j] != -1) {
                if(dp[i][j] == 1)
                    val += 1;
                return dp[i][j] == 1 ? true : false;
            }*/

            boolean checkRes = false;
            int total = 0;

            for(int k = i; k<=j-2;k = k+2){
                boolean left = booleanExpression(s,i,k,dp);
                boolean right = booleanExpression(s,k+2,j,dp);
                char x = left ? 'T' : 'F';
                char y = right ? 'T' : 'F';
                checkRes = check(new StringBuffer().append(x).append(s.charAt(k+1)).append(y).toString(),0,2);
                total += checkRes ? 1 : 0;
            }
            val = total;
            dp[i][j] = checkRes ? 1 : 0;
            return checkRes;
        }
    }
    boolean check(String s, int i, int j){
        boolean x = s.charAt(i) == 'T' ? true : false;
        boolean y = s.charAt(j)  == 'T' ? true : false;
        boolean res = false;
        switch(s.charAt(i+1)){
            case('|'):
                res = x | y;
                break;

            case('&'):
                res = x & y;
                break;

            case('^'):
                res = x^y;
                break;

        }
        return res;
    }


}
