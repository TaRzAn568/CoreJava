import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

class TrappingWaterProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            int res = getKthSmallestElement(a, n, k);
            System.out.println(res);
        }
    }

    //1 1 5 2 7 6 1 4 2 3


    public static int getKthSmallestElement(int[] a, int n, int k){
        int res = -1;

        for(int i = n/2; i>=0; i--){
            minHeapify(a,n,i);
        }
        for(int i=0;i<k;i++){
            res = extractMin(a,n,i+1);
        }

        return res;
    }
    public static void minHeapify(int[] a, int n, int i){
        int min = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < n && a[min] > a[l]){
            min = l;
        }
        if(r < n && a[min]> a[r]){
            min = r;
        }
        if(min != i){
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            minHeapify(a,n,min);
        }
    }
    public static int extractMin(int [] a, int n, int k){
        int val = a[0];
        a[0] = a[n-k];
        minHeapify(a,n-k+1,0);
        return val;
    }
}

