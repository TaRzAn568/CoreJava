/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TripletSum {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int res = checkTriplet(a,n,k);
            System.out.println(res);
        }

    }
    public static int checkTriplet(int[] a, int n, int k){
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<n; i++)
            m.put(a[i], m.getOrDefault(a[i],0)+1);
        for(int i=0; i<n; i++){
            m.put(a[i],m.getOrDefault(a[i],0) - 1);
            int psum = k-a[i];
            for(int j=0; j<n && j != i;j++){
                int diff = psum-a[j];
                m.put(a[j],m.getOrDefault(a[j],0) - 1);
                if(m.containsKey(diff) && m.get(diff) >0){
                    System.out.println(a[i] +" "+ a[j]+ " "+ diff);
                    return 1;
                }
                m.put(a[j],m.getOrDefault(a[j],0) + 1);
            }
            m.put(a[i],m.getOrDefault(a[i],0) + 1);
        }
        return 0;
    }
}