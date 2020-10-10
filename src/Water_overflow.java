import java.util.*;
import java.lang.*;
import java.io.*;
// https://practice.geeksforgeeks.org/problems/champagne-overflow/0/
class Water_overflow{
 public static void main (String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int k = Integer.parseInt(br.readLine());
            int i = Integer.parseInt(br.readLine());
            int j = Integer.parseInt(br.readLine());
            System.out.println(getWater(k,i,j));
            //System.out.println(findSubString(s));

        }
    }
	public static float getWater(int k, int i, int j){
		float [][] a = new float[i+2][i+2];
			a[1][1] = k;
			float ans = 0;
		for(int row = 1; row <= i; row++){
			for(int col = 1; col <= row; col++){
				float water = a[row][col];
				a[row][col] = water > 1f ? 1f : water;
				if(row == i && col == j){
					ans = a[row][col];
					break;
				}
				a[row+1][col] += water > 1f ? (water -1)/2 : 0;
				a[row+1][col+1] += water > 1f ? (water -1)/2 : 0;
			}
		}
		return ans;
	}
}
