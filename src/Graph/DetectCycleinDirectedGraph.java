package Graph;

import java.util.*;
import java.io.*;
import java.lang.*;


/*https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#*/
class DetectCycleinDirectedGraph
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        // add your code here

        boolean visited[] = new boolean[V];
        boolean helper[] = new boolean[V];
        for(int i=0; i<V; i++){

            if(!visited[i]){
                boolean ans =  dfs(adj,i, visited, helper) ;
                if(ans){
                    return true;
                }
            }

        }
        return false;

    }


    static boolean dfs(ArrayList<ArrayList<Integer>> adj,int u, boolean[] visited,
                       boolean[] helper){

        visited[u] = true;
        helper[u] = true;

        if(adj.get(u) != null){
            for(int x : adj.get(u)){
                if(helper[x]) return true;
                if(!visited[x]){

                    boolean ans =  (dfs(adj, x, visited, helper));
                    if(ans) return true;
                }
            }
        }
        helper[u] = false;
        return false;
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj, int V){
        boolean [] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        boolean res = false;
        while(!q.isEmpty()){
            int parent = q.poll();
            ArrayList<Integer> childs = adj.get(parent);
            for(int child : childs){
                if(!visited[child]){
                    q.add(child);
                    visited[child] = true;
                }else{
                    res = true;
                    break;
                }
            }
            if(res)
            {
                break;
            }
        }
        return res;
    }
}
