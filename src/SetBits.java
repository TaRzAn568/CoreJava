
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/*  https://practice.geeksforgeeks.org/problems/set-bits/0*/


/**
 * Given a positive integer N, print count of set bits in it. For example, if the given number is 6(binary: 110), output should be 2 as there are two set bits in it.

 Input:
 The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each testcase contains single line of input containing the N.

 Output:
 For each test case, in a new line, print count of set bits in it.

 Constraints:
 1 ≤ T ≤ 100
 1 ≤ N ≤ 106
 */
public class SetBits {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<Integer>();
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            while(n>0){
                count += n%2;
                n = n/2;
            }
            resultList.add(count);
            t--;
        }
        for(int x : resultList){
            System.out.println(x);
        }
    }
}
