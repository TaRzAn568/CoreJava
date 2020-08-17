package ExceptionHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintSpiralPattern {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            String[] hn = br.readLine().split(" ");
            int h = Integer.parseInt(hn[0]);
            int n = Integer.parseInt(hn[1]);
            String s = br.readLine();
            int a[][] = spiralPat(h, n, s);
            for(int i=0; i<a.length; i++){
                for(int j=0;j<a.length;j++){
                    if(a[i][j]== -1){
                        System.out.print(" ");
                    }else{
                        System.out.print((char)a[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
    public static int[][] spiralPat(int h, int n, String s){
        int matLen = 2*h-1;
        int[][] a = new int[matLen][matLen];
        for(int i=0; i<matLen; i++){
            for(int j=0;j<matLen;j++){
                a[i][j] = -1;
            }
        }
        int start = 0;
        int end = h-1;
        int index = 0;
        while(start <= end){
            index = fillMatrix(a, start, end, s, s.length() , index);

            start++;
            end--;
        }
        return a;
    }
    public static int fillMatrix(int[][] a, int start, int end, String s, int len, int index){

        /*for(int i=end; i>= start; i--){
            for(int j=start; j<= end; j++){
                a[i][j] = s.charAt(index % len);
                index++;
            }
        }*/
        int j = end;

        int k = start;
        for(int i=start; i<=end; i++){
            a[j][k] = s.charAt(index % len);
            j--;
            k++;
            index++;
        }
        j = start+1;
        k = end+1;
        for(int i=end+1; i<=2*end; i++){
            a[j][k] = s.charAt(index % len);
            j++;
            k++;
            index++;
        }
        j = end+1;
        k = 2*end-1;
        for(int i=end+1; i<=2*end; i++){
            a[j][k] = s.charAt(index % len);
            j++;
            k--;
            index++;
        }
        j = 2*end-1;
        k = end-1;
        for(int i=2*end-1; i>=end+1; i--){
            a[j][k] = s.charAt(index % len);
            j--;
            k--;
            index++;
        }

        return index;
    }
}
