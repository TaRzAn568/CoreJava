
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MAxInSubArray {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            //int k = Integer.parseInt(nk[1]);
            String[] s = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            //printMaxInSubArray(arr,n,k);
            int res = missingNumber(arr,n);
            System.out.println(res);
        }

    }
    public static int[] getMax(int[] a, int l,int r){
        int max = -1;
        int index = -1;
        for(int i=l;i<r;i++){
            if(a[i]>max){
                max = a[i];
                index = i;
            }
        }
        return new int[]{max,index};
    }
    /*public static void printMaxInSubArray(int[] a,int n, int k){

        int[] res = getMax(a,0,k);
        int max = res[0];
        int index = res[1];
        System.out.print(max+" ");

          for(int i=k; i<n; i++){
            if(i < index+k ){
                if(a[i]>max){
                    max = a[i];
                    index = i;
                }
            }
            else{
                res = getMax(a,index+1,i+1);
                max = res[0];
                index = res[1];
            }
            System.out.print(max+" ");
        }

    }*/

    static int missingNumber(int arr[], int n) {
        Deque<Integer> dq = new LinkedList<>();
        int j = -1;
        int max = -1;
        for(int i=0;i<n;i++){
            if(arr[i] > 0 && j ==-1){
                j = i;
            }
            if(arr[i]<= 0 && i != j && j != -1){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            if(arr[i]> max){
                max = arr[i];
            }
        }
        if(j == -1){
            return 1;
        }
        int res[] = new int[n-j];
        int k=0;
        for(int i = j; i<n; i++){
            res[k] = arr[i];
            k++;
        }
        for(int i = 0;i<k;i++){
            int x = java.lang.Math.abs(res[i]);
            if(x-1 < k && res[x-1] >0){
                res[x-1] = -res[x-1];
            }
        }
        for(int i = 0 ; i<k ;i++){
            if(res[i]>0){
                return i+1;
            }
        }
        return k+1;
    }

}