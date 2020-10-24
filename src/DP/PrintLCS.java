package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintLCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            String s1 = br.readLine();
            String s2 = br.readLine();
            //printSubSeq(s1, "");
            //String [][] dp = new String [s1.length()+1][s2.length()+1];
            String  lcs = printLCS(s1, s2, s1.length(), s2.length());
            System.out.print("lcs = " + lcs);

        }
    }
    public static String  printLCS(String s1,String s2,int m,int n){
        int [][] dp = new int [s1.length()+1][s2.length()+1];

        for(int i=0; i<m+1;i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<n+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<m+1;i++){
            for(int j=1; j<n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i = m,j=n;
        StringBuffer sb = new StringBuffer();
        while(i != 0 && j != 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1] > dp[i-1][j]){
                   // sb.append(s1.charAt(i-1));
                    j--;
                }else{
                    //sb.append(s2.charAt(j-1));
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
