package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Permutation {
    public static void main(String []  ajb)throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- >0) {
            String s = br.readLine();
            List<String> res = new ArrayList<>();
            printPermutations(s,0,s.length()-1,res);
            Collections.sort(res);
            int i=1;
            for(String s1 : res){
                System.out.print(i+"->"+s1+", ");
                i++;
            }
        }
    }
    public static void printPermutations(String s, int l, int r, List<String> res){

        if(l == r){
            if(!res.contains(s))
            res.add(s);
            return;
        }
        for (int i=l; i<=r; i++){
            s = swap(s,l,i);
            printPermutations(s,l+1,r,res);
            s = swap(s,i,l);
        }
    }
    public static String swap(String s, int l, int r){
        char [] ch = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
        return String.valueOf(ch);
    }
}
