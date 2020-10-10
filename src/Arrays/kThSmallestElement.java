package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

class kThSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());
            int [] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = Integer.parseInt(s[i]);
            }
            //int  res = getKthMinEle(a,n,k);
            int  res = getKthMinEleUsingQuickSelect(a,n,k);
            System.out.println(res);

        }
    }
    static int res = -1;
    public static int getKthMinEleUsingQuickSelect(int[] a, int n, int k){

        //quickSort(a,0,n-1,k);
        return quickSort(a,0,n-1,k);

    }

    public static int quickSort(int[] a, int low, int high,int k){
        int res = Integer.MAX_VALUE;
        System.out.println("low = "+low+" high = "+high);
        if(low == high) res = a[low];
        if (k > 0 && k <= high - low + 1){
            int pI = getPI(a,low,high);
            if(pI == k-1){
                //res = a[pI];
                return a[pI];
            }
            else if(pI > k-1){
                return quickSort(a, low, pI-1,k);
            }
            else
                return quickSort(a, pI+1, high, k);
        }
        return res;
    }


    public static int getPI(int []a, int l, int r){
        int p = r;
        int j=l;
        for(int i=l; i < r; i++){
            if(a[i] < a[p]){
                swap(a,i,j);
                j++;
            }
        }
        swap(a,j,p);
        return j;

    }
    public static void swap(int[] a,int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static int getKthMinEle(int[] a, int n, int k){
        buildHeap(a,n);
        int min = 0;
        for(int i =0; i<k; i++){
            min = a[0];
            a[0] = a[n-1-i];
            a[n-1-i] = min;

            heapify(a, n-i-1, 0);
        }
        return min;
    }
    static void buildHeap(int[] a, int n){
        for(int i=n/2 -1 ;i >=0; i--)
            heapify(a,n,i);
    }
    static void heapify(int[] a, int n, int i){
        int min = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l < n && a[min] > a[l]){
            min = l;
        }
        if(r < n && a[min] > a[r]){
            min = r;
        }
        if(min != i){
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
            heapify(a,n,min);
        }

    }


}