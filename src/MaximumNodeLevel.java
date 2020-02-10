import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumNodeLevel {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(input[i]);
            }
        }
    }

}
