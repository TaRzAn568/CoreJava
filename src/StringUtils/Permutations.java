package StringUtils;

import Graph.WaterJugProblem;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutations {
    public static void main(String []  ajb)throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- >0) {
            String s = br.readLine();
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            printPermutations(new String(ch),s.length(),"");
        }
    }
    public static void printPermutations(String s, int n, String res){

        if(res.length() == n){
            System.out.print(res+" ");
            return;
        }
        for (int i=0; i<s.length(); i++){
            printPermutations(s.substring(0,i)+s.substring(i+1,s.length()), n, res+s.charAt(i));
        }
    }
}
