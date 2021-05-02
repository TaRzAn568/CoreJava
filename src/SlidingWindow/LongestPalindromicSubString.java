package SlidingWindow;



import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalindromicSubString {
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

        int bestL = -1;
        int bestR = -1;
        int bestLen = 0;
        char a[] = s.toCharArray();

        for(int i=0;i<n-1;i++){
            int l = i;
            int r = i;
            if(a[i] == a[i+1]){
                r += 1;
            }

            while(l>0 && r<n-1){
                if(a[l-1] == a[r+1]){
                    l--;
                    r++;
                }else{
                    break;
                }
            }

            if(bestLen < r-l+1){
                bestL = l;
                bestR = r;
                bestLen = r-l+1;
            }
        }
        return s.substring(bestL,bestR+1);
    }

}

