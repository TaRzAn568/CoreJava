import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingAndRepeatingNumber {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().split(" ");
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            getMissingAndRepeatUsingXor(arr,n);
        }

    }
    public static void getMissingAndRepeatUsingXor(int[] arr,int n){
        int xorAll = 0;
        for(int i = 0; i<n; i++){
            xorAll ^= arr[i] ^ (i+1);
        }
        int k = 0;
        while(!hasSetBit(xorAll,k)){k++;}
        int x = xorAll;
        int y = xorAll;
        int missing = 0;
        int repeat = 0;
        for(int i=0;i<n;i++){
            if(hasSetBit(arr[i],k)){
                x ^=  arr[i];
            }
            else{
                y ^=  arr[i];
            }
        }
        for(int i = 1; i<=n; i++){
            if(hasSetBit(i,k)){
                x = x^i;
            }
            else{
                y = y^i;
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] == x){
                repeat = x;
                break;
            }
        }
        if(repeat != 0){
            missing = y;
        }
        else{
            repeat = y;
            missing = x;
        }
    System.out.println(repeat+" "+missing);
    }
    public static boolean hasSetBit(int x, int k){
        return ((1 <<(k-1) ) & (x)) != 0;
    }

}
