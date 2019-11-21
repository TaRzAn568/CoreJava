import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class ModularExponentiation {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<Integer> resultList = new ArrayList<Integer>();
        while(t>0){
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();

            int res = get(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c));
            System.out.println(res);

            BigInteger bg = new BigInteger(a);
            bg = bg.pow(Integer.parseInt(b));
            bg = bg.mod(new BigInteger(c));
            System.out.println(bg);


        t--;
        }
        for(int x : resultList){
            System.out.println(x);
        }

    }

    //2 3 5
    public static int get(int a,int b,int c){
        int rem=1;
        while(b-->0){
            int temp = a*rem;
            rem = temp%c;
        }
        return rem;
    }
}
