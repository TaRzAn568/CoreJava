import java.util.*;
import java.io.*;

public class BinarySearch {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().trim().split(" ");
            int k = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            int i = 0;
            for(String x : s){
                a[i] = Integer.parseInt(x);
                i++;
            }
            int result = binarySearch(a,0,n-1,k);

            System.out.println(result);
        }
    }
    static int binarySearch(int[] a,int start,int end, int k){
     if(start <= end){
         int mid = start + (end-start)/2;
         System.out.println("mid = "+mid);
         if(k == a[mid]){
             return mid;
         }
         else if(k > a[mid]){
             return binarySearch(a,start,mid-1,k);
         }else{
             return binarySearch(a,mid+1,end,k);
         }
     }
     return -1;
    }
}
