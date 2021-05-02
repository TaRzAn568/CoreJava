package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EditDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            String s1 = br.readLine();
            String s2 = br.readLine();
            //printSubSeq(s1, "");
            //String [][] dp = new String [s1.length()+1][s2.length()+1];
            int  editDis = new EditDistance().minDistance(s1, s2);
            System.out.print(editDis);

        }
    }
    public int minDistance(String s1, String s2) {

        Map<String,Integer> dp = new HashMap<>();
        return solve(s1,s2,0,0,dp);

    }

    int solve(String s1, String s2, int i, int j,Map<String,Integer> dp){
        if(j>=s2.length()) return s1.length() - i;
        if(i>=s1.length()) return s2.length() - j;

        if(dp.containsKey(i+""+j)) return dp.get(i+""+j);
        if(s1.charAt(i) == s2.charAt(j)){
            return solve(s1,s2,i+1,j+1,dp);
        }
        else{
            int insert = solve(s1, s2, i, j+1,dp);
            int del = solve(s1 ,s2, i+1,j,dp);
            int replace = solve(s1,s2 , i+1,j+1,dp );
            dp.put(i+""+j, 1 + Math.min(insert, Math.min(del, replace)));
            return dp.get(i+""+j);

        }
    }
}



