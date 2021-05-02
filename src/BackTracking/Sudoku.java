package BackTracking;


import java.util.*;
import java.io.*;
import java.lang.*;

class Sudoku
{
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            //int grid[][] = new int[9][9];
           /* for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                    grid[i][j] = sc.nextInt();
            }*/

            int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                    { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                    { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                    { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                    { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                    { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                    { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

            if(new SudokuSol().SolveSudoku(grid) == true)
                new SudokuSol().printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();

        }
    }
}



// } Driver Code Ends


//User function Template for Java

class SudokuSol
{
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here


        return helper(grid, 0,0);


    }

    static boolean helper(int[][] a, int i, int j){

        if(i==8 && j==9){
            return true;
        }

        if(j==9){
            i=i+1;
            j=0;
        }

        if(a[i][j] != 0){
            return helper(a,i,j+1);
        }
        if(a[i][j] == 0){
            for(int k=1; k<=9; k++){
                if(isValid(a,i,j,k)){
                    a[i][j] = k;
                    if( helper(a,i,j+1)){
                        return true;
                    }
                    a[i][j] = 0;
                }
            }
        }
        return false;


    }

    static boolean isValid(int[][] a, int row, int col,int val){
        boolean res = true;
        for(int i=0;i<9; i++){
            if(a[i][col] == val){
                res = false;
                return res;
            }
        }
        for(int i=0;i<9; i++){
            if(a[row][i] == val){
                res = false;
                return res;
            }
        }
        int boxI = row / 3;
        int boxJ = col / 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(a[i+3*boxI][j+3*boxJ] == val){
                    res = false;
                    return false;
                }
            }
        }
        return res;

    }

    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<9;i++){
            for(int j=0; j<9;j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}