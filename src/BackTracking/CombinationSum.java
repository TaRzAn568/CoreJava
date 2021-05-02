package BackTracking;


import java.util.*;
import java.io.*;
import java.lang.*;

class CombinationSum
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");
            int sum = Integer.parseInt(str[0]);

            res = new Sum().combinationSum(list, sum);
            if (res.size() == 0) {
                System.out.print("Empty");
            }

            // Print all combinations stored in res.
            for (int i = 0; i < res.size(); i++) {
                if (res.size() > 0) {
                    System.out.print("(");
                    List<Integer> ij = res.get(i);
                    for (int j = 0; j < ij.size(); j++) {

                        System.out.print(ij.get(j));
                        if(j < ij.size()-1)
                            System.out.print(" ");
                    }
                    System.out.print(")");
                }
            }
            System.out.println();
            res.clear();
        }
    }

}

// } Driver Code Ends


class Sum
{
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        solve(A,0,B,curr,res);
        return res;
    }

    static void solve(ArrayList<Integer> A,int j, int B,ArrayList<Integer> curr,
                      ArrayList<ArrayList<Integer>> res){
       // System.out.println(curr+" qqppp");


        if(B == 0){
            System.out.println(curr+"ppp");
            res.add(new ArrayList<>(curr));
            return;
        }
        if(B<0){
            return;
        }
        for(int i=j; i<A.size(); i++){
            if(A.get(i) <= B){
                curr.add(A.get(i));
                solve(A,i+1,B-A.get(i),curr,res);
                curr.remove(curr.size()-1);
            }else{
                break;
            }
        }

    }
}
