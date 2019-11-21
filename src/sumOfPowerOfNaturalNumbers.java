import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class sumOfPowerOfNaturalNumbers {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<Integer>();
        while(t>0){
            int x = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            resultList.add(getCountOfSumOfPowerOfNaturalNumbers(x,n));
            t--;
        }
        for(int x : resultList){
            System.out.println(x);
        }
    }
    public static int getCountOfSumOfPowerOfNaturalNumbers(int x, int n){
        int result;
        int oneByNthRoot = (int)(Math.pow(x,(double)1/n));
        int count = 0;
        for(int i=oneByNthRoot; i>=1; i--){
         int powi = (int)Math.pow(i,n);
         int sum = powi;
            for(int j=i-1; j>=0; j--){
                int powj = (int)Math.pow(j,n);
                sum = sum + powj;
                if(sum == x){
                    count++;
                    sum = sum - powj;
                }
                else if(sum > x){
                    sum = sum - powj;
                }
                else if(sum < x){
                    continue;
                }
            }
        }
        return count;
    }
}
