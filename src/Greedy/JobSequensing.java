package Greedy;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobSequensing {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            //function call
            int[] res = new solve().JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class solve{
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n){
        // Your code here
        Arrays.sort(arr, (j1,j2)->j2.profit-j1.profit);
        int c = 0;
        int k = 0;
        int maxProfit = 0;
        for(Job job : arr){
            if(job.deadline > k){
                c++;
                k++;
                maxProfit += job.profit;
            }

        }
        int a[] = {c,maxProfit};
        return a;

    }


}
