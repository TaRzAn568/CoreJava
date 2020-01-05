import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams/0
Given a word S and a text C. Return the count of the occurences of anagrams of the word in the text.
*/
public class CountOccurencesofAnagrams {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            String s = br.readLine();
            String c = br.readLine();
            int result = getOccurencesofAnagrams(s,c);
            System.out.println("res = "+result);
        }
    }
    public static int getOccurencesofAnagrams(String s1, String s2){
        int count =0;
        for(int t=0 ; t<s1.length()-s2.length()+1 ;t++){
            int []a = new int[26];
            for(int i = t ; i<s2.length()+t; i++){
                int pos = s1.charAt(i)-'a';
                a[pos]++;

            }

            for(int j=0;j<s2.length();j++){
                int pos = s2.charAt(j)-'a';
                a[pos]--;
            }

            int flag = 1;
            for(int i=0;i<26;i++){
                if(a[i] != 0){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1)
                count++;
        }
        return count;
    }
}
