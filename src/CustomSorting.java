/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class CustomSorting {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            String res = getMaxNum(s,s.length);
            System.out.println(res);
        }

    }
    public static String getMaxNum(String[] s, int n){

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                return Integer.parseInt(s1+s2) > Integer.parseInt(s2+s1) ? -1 : 1;
            }
        };
        Arrays.sort(s,com);
        StringBuffer res = new StringBuffer();
        for(String x : s) {
            res.append(x);
        }
        return res.toString();
    }

}