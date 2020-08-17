package SlidingWindow;
import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumInEachWindow {
    public static void main (String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i=0;i<n; i++)
                a[i] = Integer.parseInt(s[i]);

            printMaxFromWindow(a,n,k);
        }
    }
    //deque solution
    public static void printMaxFromWindow(int[] a, int n, int k){
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && a[dq.getLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.print(a[dq.peekFirst()]+" ");

        for(int i=k; i<n; i++){
            if(dq.getFirst() < i-k+1){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && a[dq.getLast()] <= a[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            System.out.print(a[dq.getFirst()]+" ");
        }
    }


}
