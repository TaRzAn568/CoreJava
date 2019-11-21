import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class MergeSort {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<int[]> resultList = new ArrayList<int[]>();
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(input[i]);

            mergeSort(arr,0,arr.length-1);
            resultList.add(arr);
            t--;
        }
        for(int[] x : resultList){
            for(int y : x)
            System.out.print(y+" ");
            System.out.println("");
        }
    }
    public static void mergeSort(int [] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            //divide in first and second halves
            System.out.println("left half, l = "+l+" m = "+m+" r = "+r);
            mergeSort(arr, l , m);
            System.out.println("right half, l = "+l+" m = "+m+" r = "+r);
            mergeSort(arr , m+1 , r);

            //Conquer
            System.out.println("merge method, l = "+l+" m = "+m+" r = "+r);
            merge(arr , l , m , r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r){
        //find size of two subarrays to be merged
        int n1 = m-l+1;
        int n2 = r-m;

        //create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //copy data to temp arrays
        for(int i=0; i<n1; i++)
            L[i] = arr[l+i];
        for(int j=0; j<n2; j++)
            R[j] = arr[m+1+j];

        //merge temp arrays
        int i=0,j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        for(int z : arr)
            System.out.print(z+" ");
            System.out.println("");
    }
}
