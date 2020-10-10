package StringUtils;
import java.util.*;
import java.lang.*;
import java.io.*;


class ReverseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends



class Solution {
    String reverseWords(String s) {
        if(s.length() <=1) return s;
        String a[] = s.split("\\.");
        s = "";
        for(int i=a.length-1;i>=0; i--){
            s = s+a[i] +".";
        }
        return s.substring(0,s.length()-1);
    }
}