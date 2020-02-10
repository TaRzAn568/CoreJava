import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Arrays {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int a[][] = new int[n][n];
            String intput = br.readLine();
            int k=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    a[i][j] = Integer.parseInt(intput.split(" ")[k]);
                    k++;
                }
            }
            List<Integer> result = antiDiagonalElement(a,n);
            resultList.add(result);

            t--;
        }
        for(List<Integer> x : resultList){
            for(int y : x)
                System.out.print(y+" ");
            System.out.println(" ");

        }
    }
    public static List<Integer> antiDiagonalElement(int [][] a, int n){

        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<2*n-1; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(j+k == i){
                        result.add(a[j][k]);
                    }
                }
            }
        }
        return result;
    }
}
