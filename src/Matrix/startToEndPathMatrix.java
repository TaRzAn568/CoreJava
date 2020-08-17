package Matrix;

import java.util.*;
import java.lang.*;
import java.io.*;

public class startToEndPathMatrix {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String mn[] = br.readLine().split(" ");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
           // System.out.println(fun(m-1,n-1));
            int a[][] = new int[m][n];
            String [] s = br.readLine().split(" ");
            int k = 0;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                   a[i][j] = Integer.parseInt(s[k]);
                   k++;
                }
            }

            boolean v[][] = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    v[i][j] = false;
                }
            }

            printPath(a,v,0,0,m,n);
        }
    }

    //regular recurssion to find number of paths from 00 to mn
    public static int fun(int m, int n){
        //if(m==0 && n==0) return 0;
        if(m==0 || n==0) return 1;
        return fun(m-1,n)+fun(m,n-1);
    }

    public static void printPath(int[][] a, boolean[][] v, int i, int j, int m, int n){

        if(i >= m || j >= n){
            return;
        }
        if(i == m-1 && j == n-1){
            for(int k=0; k<m-1; k++){
                for(int l=0; l<n-1; l++){
                    if(v[k][l]){
                        System.out.print(a[k][l]+" ");
                    }
                }
            }
        }
        if(i<m-1) {
            v[i + 1][j] = true;
            printPath(a, v, i + 1, j, m, n);
        }
        if(j<n-1) {
            v[i][j + 1] = true;
            printPath(a, v, i, j + 1, m, n);
        }
    }

}
