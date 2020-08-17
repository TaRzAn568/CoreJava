

import java.util.*;
        import java.lang.*;
        import java.io.*;

class LongestUniqueSubString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s = br.readLine();

            String  res = longestSubString(s,s.length());
            System.out.println(res);
            System.out.println(res.length());

        }
    }
    public static String longestSubString(String s, int n){
        int a[][] = new int[n][n];
        for(int i=0; i<n;i++){
            a[i][i] = 1;
        }
        int max=1;
        int start = 0;
        int end = 0;
        for(int k=2; k<=n; k++){
            int i=0;
            for(int j=k-1; j<n; j++){
                if(a[i][j-1] == 1 && !(s.substring(i,j).contains(Character.toString(s.charAt(j)))))
                {
                    a[i][j] = 1;
                    if(max < j-i+1){
                        max = j-i +1;
                        start = i;
                        end = j;
                    }
                }
                else{
                    a[i][j] = 0;
                }
                i++;
            }
        }
        return s.substring(start,end+1);
    }
}
