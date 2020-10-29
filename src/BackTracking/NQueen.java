package BackTracking;

import java.util.*;
import java.io.*;
public class NQueen {

    public static void main(String[] dksh)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){

            int n = Integer.parseInt(br.readLine());
            int chess[][] = new int[n+1][n+1];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
                    nQueen(chess, n, 1, res, curr);
            for(List<Integer> al : res) {
               System.out.print(al.toString().replaceAll(",", "").replaceAll("]"," ] ") );
            }
            }


        }

    public static void nQueen(int[][] chess, int n, int row, List<List<Integer>> res, List<Integer> curr){

        if(row == chess.length){
            List<Integer> copy = new ArrayList<>(curr);
            res.add(copy);
            return;
        }

        for(int j=1; j<chess.length; j++){
            if(check(chess,row,j)){
                chess[row][j] = 1;
                curr.add(j);
                nQueen(chess, n, row+1, res, curr);
                chess[row][j] = 0;
                curr.remove(new Integer(j));
            }
        }

    }


    public static boolean check(int[][] chess, int row, int col){
        boolean res = true;

        for (int i=1; i<row; i++){
            if(chess[i][col] == 1){
                res = false;
                return res;
            }
        }
        int i = row-1, j = col-1;
        while(i>=1 && j >= 1){
            if(chess[i][j] == 1){
                res = false;
                return res;
            }
            i--;
            j--;
        }
         i = row-1; j = col+1;
        while(i>=1 && j < chess.length){
            if(chess[i][j] == 1){
                res = false;
                return res;
            }
            i--;
            j++;
        }
        return res;
    }

}
