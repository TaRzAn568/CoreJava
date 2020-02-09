import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextGreaterNumber {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        br.close();
        int n = Integer.parseInt(s);
        int[] arr = new int[s.length()];
        int i = 0;
        int t = n;
        while (t > 0) {
            arr[s.length() - 1 - i] = t % 10;
            t = t / 10;
            i++;
        }
        int res = getNextgreaterNum(arr, s.length());
        System.out.println(res);
    }
    //not optimized
    public static int getNextgreaterNum(int[] a, int n){
        boolean flag = false;
        for(int i=n-2; i >= 0; i--){
            int j = n-1;
            while(j > i){
                if(a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    flag = true;
                    i= i+1;
                    j= n-1;

                    for(int z :a){
                        System.out.print(z+" ");
                    }
                    while(i < j){
                        int temp1 = a[i];
                        a[i] = a[j];
                        a[j] = temp1;
                        i++;
                        j--;
                    }
                    break;
                }else {
                    j--;
                }
            }
            if(flag){
                break;
            }
        }
        int res = 0;
        for(int k=n-1;k>=0;k--){
            res += (int)a[k]*(Math.pow(10,n-1-k));
        }

        return res;
    }

}
