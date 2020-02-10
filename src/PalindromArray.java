/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromArray {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(input[i]);
            }
            System.out.println(pArray(a,0,n-1,0));
        }
    }
    public static int pArray(int [] a, int start, int end,int c){
        if(start >= end){
            return c;
        }
        if(a[start] == a[end]){
            c++;
            pArray(a,start+1,end-1,c);
        }
        else if((a[start] < a[end]) && (a[start]+a[start+1] == a[end])){
                c++;
                pArray(a,start+2,end-1,c);
        }
        else if((a[start] > a[end]) && (a[start] == a[end]+a[end-1])){
                c++;
                pArray(a,start+2,end-1,c);
        }
        else if(a[start]+a[start+1] == a[end]+ a[end-1]){
            c++;
            pArray(a,start+2,end-2,c);
        }
        else{
            c = end - start;
        }

        return c;
    }
}
