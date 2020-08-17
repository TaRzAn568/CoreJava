/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Sort012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s1 = br.readLine().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(s1[i]);

            }
            int[] res = sort012(a,n);
            for(int x: res)
                System.out.print(x+" ");
            System.out.println();
        }
    }

    public static int[] sort012(int[] a, int n){
        int fOne = -1;
        int fTwo = n-1;
        int m=0;
        while(m < fTwo){
            switch(a[m]){
                case 0:
                    if(fOne>-1){
                        int temp = a[m];
                        a[m] = a[fOne];
                        a[fOne] = temp;
                        fOne++;
                    }
                    m++;
                    break;
                case 1:
                    if(fOne ==-1){
                        fOne = m;
                    }
                    m++;
                    break;
                case 2:
                    int temp = a[m];
                    a[m] = a[fTwo];
                    a[fTwo] = temp;
                    fTwo--;
            }
        }
        return a;
    }
}