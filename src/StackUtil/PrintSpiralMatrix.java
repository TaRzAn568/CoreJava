/*package whatever //do not write package name here *//*


import java.util.*;
import java.lang.*;
import java.io.*;

class PrintSpiralMatrix {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] s = br.readLine().split(" ");
            int[][] a = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    a[i][j] = Integer.parseInt(s[i+j]);
                }
            }
            printSpiral(a,n,m);
            System.out.println();
        }
    }
    public static void printSpiral(int[][] a, int n, int m){
        int iMin = 0;
        int iMax = n;
        int jMin = 0;
        int jMax = m;

        for(int j=jMin; j<jMax; i++){
            System.out.print(a[iMin][j]+" ");
        }
        iMin++;
        jMax--;
        for(int i=iMin; i<iMax; i++){
            System.out.print(a[i][jMax]+" ");
        }
        iMax--;


    }

}*/
