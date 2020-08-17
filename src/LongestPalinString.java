

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalinString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s = br.readLine();

            String  res = longestPalin(s,s.length());
            System.out.println(res);

        }
    }

    public static String longestPalin(String s, int n){

        if(n == 1 || n==0)return s;
        if(n == 2){
            if(s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0,1);
        }

        int maxi = -1;
        int maxj = -1;
        int best = 0;
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            a[i][i] = 1;
            if(best < 1) {
                best = 1;
                maxi = i;
                maxj = i;
            }
            if(i+1 < n && s.charAt(i) == s.charAt(i+1)){
                a[i][i+1] = 1;
                if(best < 2){
                    best = 2;
                    maxi = i;
                    maxj = i+1;
                }
            }
        }



        for(int i=0;i<n;i++){
            int k = 0;
            for(int j=2; i+j<n; j++){
                if(s.charAt(k) == s.charAt(i+j) && a[k+1][i+j-1] ==1){
                    a[k][i+j] = 1;
                    if(i+j-k+1 > best){
                        best = i+j-k+1;
                        maxi = k;
                        maxj = i+j;
                    }
                }
                k++;
            }
        }
        return s.substring(maxi,maxj+1);
    }

}

