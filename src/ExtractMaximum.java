
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

/*  https://practice.geeksforgeeks.org/problems/extract-maximum/0/?ref=self   */
public class ExtractMaximum {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<Integer>();
        while(t>0){
            String s = br.readLine();
            String intArr[] = s.split("\\D");
            int max = -1;
            for(String x : intArr){
                if(!x.isEmpty() && Integer.parseInt(x) > max){
                    max = Integer.parseInt(x);
                }
            }
            resultList.add(max);
            t--;
        }
        for(int x : resultList){
            System.out.println(x);
        }
    }
}
