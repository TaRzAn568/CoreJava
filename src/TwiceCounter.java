import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
https://practice.geeksforgeeks.org/problems/twice-counter/0
Finding the number of words which exactly appears 2 times in a string
*/
public class TwiceCounter {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int result = findTwiceCounter(s);
            System.out.println("res = "+result);

        }
    }
    public static int findTwiceCounter(String s){
        Map<String,Integer> m = new HashMap<String,Integer>();
        int c = 0;
        for(String x : s.split(" ")){
            if(m.keySet().contains(x)) {
                m.put(x, m.get(x)  + 1);
            }
            else
                m.put(x,1);
        }
        System.out.println(m);
        List<Integer> l = new ArrayList(m.values());
        int c1=0;
        for(int x : l){
            if(x == 2){
                c1++;
            }
        }
        return c1;
    }

}
