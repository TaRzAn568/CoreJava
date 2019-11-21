/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
/*
https://practice.geeksforgeeks.org/problems/rectangles-in-nn-board/0

Find total number of Rectangles (excluding squares) in a N*N cheesboard.

Input:

The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an integer N that is the side of the chessboard.


Output:

Each seperate line showing the maximum number of rectangles possible.


Constraints:

1 ≤ T ≤ 1000
1 ≤ N ≤ 10000

*/
class RectanglesInChessBoard {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Long> resultList = new ArrayList<Long>();
        while(t-- >0){
            long n = Integer.parseInt(br.readLine());
           /* int result = 0;
            for(int i=1;i<=n-1;i++){
                int tempSum = 0;
                for(int y=1;y<=n-i;y++){
                    int x = n-i+1;
                    tempSum += y*x;
                }
                result += tempSum;
            }
            resultList.add(2*result);*/
            long squareAndRactangles = (long)((n*n+n)/2)*((n*n+n)/2);
            long squares = (long)((n*(n+1)*(2*n+1))/6);
            long onlyRactangles = squareAndRactangles-squares;

            resultList.add(onlyRactangles);
        }
        for(Long x : resultList)
            System.out.println(x);
    }
}



