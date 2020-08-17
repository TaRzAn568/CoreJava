package SlidingWindow;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstNegativeInEachWindow {

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

            printFirstNegativeFromWindow(a,n,k);
            System.out.println();
        }
    }

    public static void printFirstNegativeFromWindow(int[] a, int n, int k){
        Deque<Integer> dq = new LinkedList<>();
        for(int i =0; i<k;i++){
            if(a[i] < 0)
            dq.addLast(i);
        }
        if(!dq.isEmpty()){
            System.out.print(a[dq.getFirst()]+" ");
        }else{
            System.out.print(0+" ");
        }
        for(int i=k; i<n; i++){
            if(!dq.isEmpty() && dq.getFirst() < i-k+1){
                dq.removeFirst();
            }
            if(a[i] <0){
                dq.addLast(i);
            }
            if(!dq.isEmpty()){
                System.out.print(a[dq.getFirst()]+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }



}
