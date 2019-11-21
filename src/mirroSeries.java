import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;
public class mirroSeries {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i <= 2*Math.abs(n); i++){
            if(n<0){
                    System.out.print(i - Math.abs(n) + " ");
            }else {
                System.out.print(n - i + " ");
            }
        }

    }
}

