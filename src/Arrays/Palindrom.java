package Arrays;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
class Palindrom {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here\\\

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int [] a = new int[n];
            for(int i=0; i<n; i++)
                a[i] = Integer.parseInt(s[i]);

            int res = isPalin(a, n)  ;
            System.out.println(res);
        }

    }
    public static int isPalin(int[] a, int n){
        int res = 0;
        int l = 0;
        int r = n-1;
        while(l < r){
            if(a[l] == a[r]){
                l++;
                r--;
            }else{
                if(a[l] < a[r]){
                    a[l+1] += a[l];
                    l++;
                    res++;
                }
                else {
                    a[r-1] += a[r];
                    r--;
                    res++;
                }

            }
        }

        return res;

    }

}
