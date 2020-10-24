import java.io.*;
import java.util.*;

class UglyNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            System.out.println(new UglyNumberSolution().getNthUglyNo(n));
        }
    }
}// } Driver Code Ends


class UglyNumberSolution {
    /* Function to get the nth ugly number*/
    long getNthUglyNo(int n) {
        // code here
        if(n < 6) return n;
        int c = 6;
        Map<Integer,Boolean> m = new HashMap<>();
        m.put(1,true);
        m.put(2,true);
        m.put(3,true);
        m.put(4,true);
        m.put(5,true);

        for(int i=6;i<=n;){
            if(check(c,m)){
                c++;
                i++;
            }else{
                c++;
            }
        }
        return c-1;

    }
    boolean check(int n,Map<Integer,Boolean> m){
        boolean res = false;
        for(int i=n/2; i>=2;i--){
            if(m.get(i)){
                if(n % i ==0)
                    res = true;
            }else{
                break;
            }

        }

        m.put(n,res);
        return res ;
    }
}