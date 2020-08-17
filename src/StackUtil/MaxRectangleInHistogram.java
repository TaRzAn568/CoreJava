package StackUtil;



import java.util.*;
        import java.lang.*;
        import java.io.*;

class MaxRectangleInHistogram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int  res = getMaxArea(a,n);
            System.out.println(res);

        }
    }
    public static int getMaxArea(int[] a, int n){
        int res = -1;
        for(int i=0; i<n; i++){
            int start = i;
            int end = i;
            while(start >= 0 && a[start] >= a[i]){
                start--;
            }
            while(end <= n-1 && a[end] >= a[i]){
                end++;
            }
            int temp = (end-start-1)*a[i];
            if(temp > res){
                res = temp;
            }
        }
        return res;
    }

}
