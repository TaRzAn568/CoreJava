package SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfMinimumOfEveryWindow {
    public static void main (String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            //String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(br.readLine());
            //int k = Integer.parseInt(nk[1]);
            String[] s = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i=0;i<n; i++)
                a[i] = Integer.parseInt(s[i]);

            printMaximumOfMinimumOfEveryWindow(a,n);
            System.out.println();
        }
    }

    public static void printMaximumOfMinimumOfEveryWindow(int[] a, int n){
        for(int ki=1; ki<=n; ki++){
            int maxki = Integer.MIN_VALUE;
            Deque<Integer> dq = new LinkedList<>();
            for(int i=0; i<ki; i++){
                while(!dq.isEmpty() && a[dq.getLast()] >= a[i])
                    dq.removeLast();
                dq.addLast(i);
            }
            if(!dq.isEmpty() && a[dq.getFirst()] > maxki){
                maxki = a[dq.getFirst()];
            }
            
            for(int i=ki; i<n; i++){
                if(!dq.isEmpty() && dq.getFirst() < i-ki +1)
                    dq.removeFirst();

                while(!dq.isEmpty() && a[dq.getLast()] >= a[i])
                    dq.removeLast();
                dq.addLast(i);
                
                if(a[dq.getFirst()] > maxki){
                    maxki = a[dq.getFirst()];
                }
                
            }
        System.out.print(maxki+" ");
        }
    }

}
