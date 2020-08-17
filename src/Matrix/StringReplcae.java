package Matrix;


import java.io.*;
import java.util.*;

class StringReplcae {
    BufferedReader in;
    StringTokenizer st;
    public String minimumString(int n, int k, String s, String t, int[] li, int[] ri) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        while(true){
            int c = 0;
            for(int i=0;i<k;i++) {
                c += 1;
                boolean flag = false;
                if (ta[li[i]] >= sa[li[i]]){
                    if (sa[li[i]] > ta[ri[i]]) {
                        flag = true;
                    }
                    if (!flag) {
                        if (sa[ri[i]] > ta[li[i]]) {
                            flag = true;
                        }
                    }
                }

                if (flag) {
                    char temp = ta[li[i]];
                    ta[li[i]] = ta[ri[i]];
                    ta[ri[i]] = temp;
                    c = 0;
                }
                System.out.println("c = "+c);

            }
            if(c == k){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n;i++){
            if(sa[i] > ta[i]){
                sa[i] = ta[i];
            }
            sb.append(sa[i]);
        }
        return sb.toString();
    }
    public void run() throws IOException {
        in=new BufferedReader(new InputStreamReader(System.in));
        int testcase = ni();
        while(testcase-- > 0) {
            int n = ni();
            int k = ni();
            String s = ns();
            String t = ns();
            int[] li = new int[k];
            int[] ri = new int[k];
            for(int i = 0; i < k; i++) {
                li[i] = ni();
                ri[i] = ni();
            }
            String ans = minimumString(n, k, s, t, li, ri);
            System.out.println(ans);
        }
    }
    public static void main(String[] args) throws IOException {
        new StringReplcae().run() ;
    }
    String ns() throws IOException {
        return nextToken();
    }
    long nl() throws IOException {
        return Long.parseLong(nextToken());
    }
    int ni() throws IOException {
        return Integer.parseInt(nextToken());
    }
    double nd() throws IOException {
        return Double.parseDouble(nextToken());
    }
    String nextToken() throws IOException {
        if(st==null || !st.hasMoreTokens())
            st=new StringTokenizer(in.readLine());
        return st.nextToken();
    }







}