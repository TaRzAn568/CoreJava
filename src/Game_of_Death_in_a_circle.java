import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Game_of_Death_in_a_circle {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<Integer>();
        while(t>0){
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            al.add(i+1);
        }
       int result = luckyPerson(n,k);
            System.out.println("result = "+result);



            t--;
        }
        for(int x : resultList){
            System.out.println(x);
        }

    }
    public static int luckyPerson(int n, int k){
            if(n == 1){
                return 1;
            }else{
                return (luckyPerson(n-1,k) + k-1)%(n)+1;
            }

    }

}



