
import java.util.*;
        import java.lang.*;
        import java.io.*;

class SwappingPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] n1n2 = br.readLine().split(" ");
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(n1n2[0]);
            int n2 = Integer.parseInt(n1n2[1]);
            int[] a = new int[n1];
            int[] b = new int[n2];
            for(int i = 0; i < n1 || i<n2; i++){
                if(i<n1)
                    a[i] = Integer.parseInt(s1[i]);
                if(i<n2)
                    b[i] = Integer.parseInt(s2[i]);
            }
            int res = getPair(a, b, n1,n2);
            System.out.println(res);
        }
    }
    public static int getPair(int[] a, int[] b,int n1, int n2){
        Set<Integer> aset = new HashSet<>(),bset = new HashSet<>();
        int asum =0,bsum = 0;
        for(int i = 0; i < n1 || i<n2; i++){
            if(i<n1){
                aset.add(a[i]);
                asum += a[i];
            }
            if(i<n2){
                bset.add(b[i]);
                bsum += b[i];
            }
        }
        if(Math.abs(asum - bsum) % 2 == 0){
            int diff = Math.abs(asum - bsum)/2;
            for(int  x : aset){
                int rem = asum > bsum ? x - diff : x+diff;
                if(bset.contains(rem)){
                    return 1;
                }
            }
        }
        return -1;
    }
}
