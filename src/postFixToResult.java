package Stack;

import java.util.*;
import java.lang.*;
import java.io.*;

class postFixToResult {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            int res = getRes(s);
            System.out.println(res);
        }
    }
    public static int getRes(String s){
        Integer res = 0;
        String numString = "0123456789";
        Stack<String> st = new Stack<>();
        for(char y : s.toCharArray()){
            String x = Character.toString(y);
            if(numString.contains(x)) {
                st.push(x);
            }else {
                if(x.equals("+")) {
                    //res += Integer.parseInt(Character.toString(st.pop())) + Integer.parseInt(Character.toString(st.pop()));
                    res = Integer.parseInt(st.pop()) + Integer.parseInt(st.pop());
                    st.push(res.toString());
                }
                else if(x.equals("-")) {
                    res = -(Integer.parseInt(st.pop()) - Integer.parseInt(st.pop()));
                    st.push(res.toString());
                }
                else if(x.equals("*")) {
                    res = Integer.parseInt(st.pop()) * Integer.parseInt(st.pop());
                    st.push(res.toString());
                }
                else if(x.equals("/")) {
                    res = 1/(Integer.parseInt(st.pop()) / Integer.parseInt(st.pop()));
                    st.push(res.toString());
                }
            }
        }
        return res;
    }
}
