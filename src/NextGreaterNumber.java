import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextGreaterNumber {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());
            int res = getSumOfSubArrayLength(a,n,k);
            System.out.println(res);
        }
    }
    public static int getSumOfSubArrayLength(int[] a, int n, int k){
        int res = 0;
        int temp = 0;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(a[i]<k){
                temp += 1;
                if(i == n-1){
                    res += temp;
                }
            }else if(a[i] == k){
                temp += 1;
                flag = true;
                if(i == n-1){
                    res += temp;
                }
            }else if(a[i]>k || i == n-1){
                if(flag){
                    res += temp;
                }
                temp = 0;
                flag = false;

            }
        }
        return res;
    }

}
