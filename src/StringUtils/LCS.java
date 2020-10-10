package StringUtils;

import java.util.*;
import java.lang.*;
import java.io.*;

class LCS {
    static String val = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] n1n2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(n1n2[0]);
            int n2 = Integer.parseInt(n1n2[1]);
            String s1 = br.readLine();
            String s2 = br.readLine();
            //printSubSeq(s1, "");
            String lcs = printLCS(s1, s2);
            System.out.print("lcs = " + lcs.length() + " val = " + lcs);
        }
    }

    public static void printSubSeq(String s,String res){
        if(s.length() == 0) {
         System.out.println(res);
            return;
        }




        printSubSeq(s.substring(1), res+ s.charAt(0));
        printSubSeq(s.substring(1),res );
    }

    public static String printLCS(String s1, String s2){
        System.out.println("here s1 = "+s1+" s2 = "+s2);
        if(s1.length() == 0 || s2.length() == 0) return "";

        if(s1.charAt(0) == s2.charAt(0)){
            //val += s1.charAt(0);
            return (s1.substring(0,1)+printLCS(s1.substring(1), s2.substring(1)));
        }
        else if(s2.length() > 1){
            return printLCS(s1, s2.substring(1));
        }
        else if(s1.length() > 1){
            return printLCS(s1.substring(1),s2);
        }
        return printLCS(s1.substring(1),s2.substring(1));
    }

}