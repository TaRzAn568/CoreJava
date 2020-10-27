package Graph;


import java.util.*;
import java.io.*;
import java.lang.*;
/*        https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1*/
class DetectCycleUndirectedGraph
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
                list.get(v).add(u);
            }
            if(new DetectCycleUndirectedGraphSolution().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycleUndirectedGraphSolution
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
        int parent[] = new int[V];
        Arrays.fill(parent, -1);
        boolean visited[] = new boolean[V];
        boolean res =  false;

        for(int i=0; i<V; i++){
            if(!visited[i]){
                //res = dfs(g, i, visited, parent);
                res = bfs(g, i, visited, parent);
                if(res){
                    break;
                }
            }
        }
        return res;
    }

    static boolean bfs(ArrayList<ArrayList<Integer>> adj, int u, boolean [] visited,
                       int[] parent){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()){
            int polled = q.poll();
            ArrayList<Integer> children = adj.get(polled);
            for(int i=0; i<children.size(); i++)
            {
                int child = children.get(i);
                if(!visited[child]){
                    parent[child] = polled;
                    visited[child] = true;
                    q.add(child);
                }
                else if(parent[polled] != child){
                    return true;
                }
            }
        }
        return false;

    }


    static boolean dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean [] visited,
                       int[] parent){
        visited[u] = true;
        ArrayList<Integer> children = adj.get(u);
        for(int i=0; i< children.size(); i++){
            int child = children.get(i);
            if(!visited[child]){
                parent[child] = u;
                boolean res = dfs(adj, child, visited, parent);
                if(res) {
                    return res;
                }
            }
            else if(parent[u] != child){
                return true;
            }
        }
        return false;
    }
}
