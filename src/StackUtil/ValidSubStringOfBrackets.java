package StackUtil;


import java.util.*;
import java.lang.*;
import java.io.*;

class ValidSubStringOfBrackets {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            String s = br.readLine();
            int res = getValidSubstringLengthStackSol(s, s.length());
            System.out.println(res);
        }

    }
    public static int getValidSubstringLengthStackSol(String s , int n){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;

        for (int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.empty())
                {
                    st.push(i);
                }else{
                    max = Math.max(max, i-st.peek());
                }
            }
        }
        return max;
    }

    public static int getValidSubstringLengthWithoutExtraSpace(String s, int n){
        int left = 0, right = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                left++;
            }
            else {
                right++;
            }
            if(right > left){
                left = right = 0;
            }else if(left ==  right){
                res = Math.max(res, 2* right);
            }
        }

        left = right = 0;
        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == '('){
                left++;
            }
            else {
                right++;
            }
            if(right < left){
                left = right = 0;
            }else if(left ==  right){
                res = Math.max(res, 2* left);

            }
        }
        return res;
    }
    public static int getValidSubstringLengthUsingDP(String s, int n){
        int [] dp = new int[n];
        int res = 0;
        for(int i=1; i<n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i > 1 ? dp[i-2] : 0) + 2;
                }else if(i > i-dp[i-1] && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] +( i-dp[i-1]-2 >= 0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}