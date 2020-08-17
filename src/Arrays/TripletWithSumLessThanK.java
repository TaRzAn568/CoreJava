package Arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

class TripletWithSumLessThanK {
    public static void main (String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int [] a = new int[n];
            String[] s = br.readLine().split(" ");

            for(int i=0;i< n;i++)
                a[i] = Integer.parseInt(s[i]);

            System.out.println(countTriplet(a,n,k));
            //findTriplets2(a,n,k);

        }
    }
    public static int countTriplet(int[] a, int n, int k){
        Map<Integer,Integer> m = new HashMap<>();

        for(int i=0;i<n;i++){
            m.put(a[i],m.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int pairSum = k-a[i];
            m.put(a[i],m.getOrDefault(a[i],0)-1);
            for(int j=i+1;j<n; j++){
                int key = pairSum - a[j];
                m.put(a[j],m.getOrDefault(a[j],0)-1);
                if(m.containsKey(key) && m.getOrDefault(key,0) >0){
                    System.out.println(a[i]+" "+a[j]+" "+key);
                    /*m.put(a[j],m.getOrDefault(a[j],0)-1);
                    m.put(a[i],m.getOrDefault(a[i],0)-1);
                    m.put(key,m.getOrDefault(key,0)-1);*/

                }
                    //m.put(key,m.getOrDefault(key,0)+1);
                    //m.put(a[j], m.getOrDefault(a[j], 0) + 1);

            }
            //m.put(a[i],m.getOrDefault(a[i],0)+1);
        }
        return 0;
    }

    static void findTriplets2(int arr[], int n, int sum)
    {
        for (int i = 0; i < n - 1; i++) {
            // Find all pairs with sum equals to
            // "sum-arr[i]"
            HashSet<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int x = sum - (arr[i] + arr[j]);
                if (s.contains(x))
                    System.out.printf(
                            "%d %d %d\n", x, arr[i], arr[j]);
                else
                    s.add(arr[j]);
            }
        }
    }

}