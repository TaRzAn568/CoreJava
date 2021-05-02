package BinarySearch;

import java.io.*;
import java.util.*;

public class MedianOfSortedArrays    {
    public static void main(String [] ars)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int a1[] = new int[n1];
        String[] s1 = br.readLine().split(" ");

        for(int i=0; i<n1; i++){
            a1[i] = Integer.parseInt(s1[i]);
        }
        int n2 = Integer.parseInt(br.readLine());
        int a2[] = new int[n2];
        String[] s2 = br.readLine().split(" ");
        for(int i=0; i<n2; i++){
            a2[i] = Integer.parseInt(s2[i]);
        }
        double res = new MedianOfSortedArraysSolution().findMedianSortedArrays(a1,a2);
        System.out.println(res);

    }

}


class MedianOfSortedArraysSolution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n1 = a1.length;
        int n2 = a2.length;
        int m1 = (n1+n2+1) /2;
        boolean even = ((n1+n2)&1) == 0;

        int val1 = getMedian(a1,a2,m1-1);
        System.out.println(m1+"_"+val1);
        if(even){
            int val2 = getMedian(a1,a2,m1);
            System.out.println(val2);
            return (double)(val1+val2)/2;
        }
        return (double) val1;
    }


    int getMedian(int[] a1, int[] a2, int m1){

        if(a1.length == a2.length && a1[0] == a2[a1.length-1] && a1[0] == a1[a1.length-1]){
            return a1[0];
        }
        int l1 = 0;
        int r1 = a1.length-1;
        int mid = 0;
        while(l1<=r1){
            mid = (l1+r1)/2;
            int ubOfMid = bs(a2,a1[mid]);

            if(mid+ubOfMid == m1){
                return a1[mid];
            }else if(mid+ubOfMid < m1){
                l1 = mid+1;
            }
            else{
                r1 = mid-1;
            }
        }
        int x = getMedian(a2,a1,m1);
        System.out.println(x);
        return x;

    }

    int bs(int[] a, int x){
        int l = 0;
        int r = a.length-1;
        if(x < a[l]){
            return 0;
        }
        if(x > a[r]){
            return a.length;
        }
        int best = 0;
        while(l<=r){
            int m = (l+r)/2;
            if(a[m] > x){
                r = m-1;
            }
            else {
                best = m;
                l = m+1;
            }
        }
        return best+1;
    }

}