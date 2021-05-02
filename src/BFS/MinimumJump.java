package BFS;

import java.lang.*;
import java.io.*;
import java.util.*;
class MinimumJump
{
    public static void main (String[] args) throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new MinimumJumpSol().minJumps(arr));
        }
    }

}
class MinimumJumpSol{




    static int minJumps(int[] arr){
        // your code here
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int n = arr.length;
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i=0; i<size; i++){
                int polled = q.poll();

                int val = arr[polled-1];
                if(val != 0){
                    for(int j=1; j<=val; j++) {
                        q.add(polled + j);
                        if(polled+j == n){
                            return res;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
