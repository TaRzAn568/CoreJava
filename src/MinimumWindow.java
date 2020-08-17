

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;

class MinimumWindow{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            String s = br.readLine();
            String s1 = br.readLine();
           // String res = getMinimumWindow(s,s.length());
            //System.out.println(res);
            minWindowSubSequence(s,s1);
        }

    }
    /*public static String getMinimumWindow(String s,int n){
        int l=0,r=0,c=0,minLength = Integer.MAX_VALUE;
        String res = "";
        Map<Character,Integer> ptrMap = new HashMap<>();
        char [] a = s.toCharArray();
        for(int i=0; i<n; i++){
            if(!ptrMap.containsKey(a[i])){
                ptrMap.put(a[i],1);
            }
        }
        Map<Character,Integer> strMap = new HashMap<>();
        for(int i=0; i<n; i++){
            if(strMap.getOrDefault(a[i],0) < ptrMap.getOrDefault(a[i],0)){
                c++;
            }
            strMap.put(a[i],strMap.getOrDefault(a[i],0)+1);
            r++;
            if(c == ptrMap.size()){
                res = s.substring(l,r);
                minLength = res.length();
                break;
            }
        }
        for(;l<n-ptrMap.size()+1;l++){
            if(strMap.getOrDefault(a[l],0) > ptrMap.getOrDefault(a[l],0)){
                strMap.put(a[l],strMap.getOrDefault(a[l],0)-1);
                res = s.substring(l+1,r+1);
                minLength = res.length();
            }
            else{
                char ch = a[l];
                strMap.put(a[l],strMap.getOrDefault(a[l],0)-1);
                for(; r<n;r++){
                    strMap.put(a[r],strMap.getOrDefault(a[r],0)+1);
                    if(a[r] == ch){
                        res = s.substring(l+1,r+1);
                        break;
                    }
                }
            }
        }

        return res;
    }*/

    public static String getMinimumWindow(String s,int n){
        String res = "";

        char[] a = s.toCharArray();
        int [] ptr = new int[255];
        int [] str = new int[255];

        int ptrLen = 0,start=0,c=0,minLen = Integer.MAX_VALUE;
        for(int i=0; i<n;i++){
            if(ptr[s.charAt(i)] == 0)
                ++ptr[s.charAt(i)];
        }
        for(int i=0; i<255; i++){
            if(ptr[i] != 0){
                ptrLen += ptr[i];
            }
        }
        for(int i=0; i<n; i++){
            if(str[a[i]] < ptr[a[i]]){
                c++;
            }
            str[a[i]]++;

            if(c == ptrLen){
                while(str[a[start]] > ptr[a[start]]){
                    str[a[start]]--;
                    start++;
                }
                if(i+1-start < minLen){
                    res = s.substring(start,i+1);
                    minLen = res.length();
                }
            }
        }
        return res;
    }
    public static  void minWindowSubSequence(String s1, String s2){
        char [] a = s1.toCharArray();
        char [] b = s2.toCharArray();
        int j = 0, k = 0;
        for(int i=0; i<a.length ;i++){
            if(a[i] == b[k]){
                if(k == 0){
                    j = i;
                }
                k++;
            }
            if(k == b.length){
                System.out.println(s1.substring(j,i+1));
                break;
            }
        }
    }
}