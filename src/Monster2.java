import java.util.*;
import java.io.*;

public class Monster2 {

    public static void main(String[] khd)throws Exception{

        //testException();
        matrixMethod();
    }

    public static void testException()throws Exception{
        int i = 5;
        while(i-- >=3) {
            System.out.println("i -> "+i);
            throw new FileNotFoundException("File Not found");
        }
    }


    static void matrixMethod(){
        int n = 5;
        int [][] a = buildMatrix(n);
        printMatrix(a);

        System.out.println(" Reversed matrix");
        a = reverseMatrix(a);
        printMatrix(a);
    }

    static void printMatrix(int [][] a){
        int n = a.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int [][] reverseMatrix(int [][] a){
        int n = a.length;
        for(int i=0; i<n; i++){
            int l = 0;
            int r = n-1;
            while(l < r){
                int temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;
                r--;
            }
        }

        for(int i=0; i<n; i++){
            int t = 0;
            int d = n-1;
            while(t < d){
                int temp = a[t][i];
                a[t][i] = a[d][i];
                a[d][i] = temp;
                t++;
                d--;
            }
        }
        return a;
    }

    static int[][] buildMatrix(int n){
        int [][] a = new int[n][n];
        int k = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = k++;
            }
        }

        return a;
    }





    //n - size of mat.
    /*          a[i][j] -->1-- 9
    *           1 2 3
    *           4 5 6
         *      7 8 9     ->
    *
    * */

}
