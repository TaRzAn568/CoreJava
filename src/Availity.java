import java.util.*;
import java.io.*;



public class Availity {

    public static void main(String [] abs)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // System.out.println("hello");
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n = Integer.parseInt(br.readLine());
       // System.out.println(isPalin(s.toCharArray(), s.length()));
        System.out.println(isAnagram(s1,s2));
        System.out.println(isAnagram(s1,s2, n));
    }



    public static boolean isAnagram(String s1, String s2 ,int n){
        int l1 = s1.length();
        int l2 = s2.length();

        int [] hash = new int[255];     // abbc  abz n=1
        for(int i=0; i<l1; i++){
            char iChar = s1.charAt(i);
            hash[iChar] += 1;
        }
        int mathingInS2 = 0;
        for(int i=0; i<l2; i++){
            char iChar = s2.charAt(i);
            if(hash[iChar] > 0){
                hash[iChar]--;
                mathingInS2 += 1;
            }
        }
        return Math.abs(mathingInS2 - l1) <= n ? true : false;
    }


    public static boolean isAnagram(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2){
            return false;
        }
        int [] hash = new int[255];     // abbc  abz n=1
        for(int i=0; i<l1; i++){
            char iChar = s1.charAt(i);
            hash[iChar] += 1;
        }
        int c2 = 0;
        for(int i=0; i<l2; i++){
            char iChar = s2.charAt(i);
            if(hash[iChar] > 0){
                hash[iChar]--;
                c2 += 1;
            }
        }
        return c2 == l1 ? true : false;
    }

    public static boolean isPalin(char[] ch, int n){
        int l = 0;
        int r = n-1;
        while(l<r){
            if(ch[l] == ch[r]){
                l++;
                r--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    //save vase asev
}
