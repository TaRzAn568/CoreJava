import java.io.*;
import java.util.*;

public class Count2InNumber {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = getCountOf2InNumber(n);
        System.out.println(res);
    }

    public static long getCountOf2InNumber(int n){
        double d = Math.log10(n);
        System.out.println(d);
        return (long)d;
    }
}
