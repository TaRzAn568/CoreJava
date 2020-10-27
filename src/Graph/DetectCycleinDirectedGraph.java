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
        boolean dfsAns = false;
        for(int i=0; i<V; i++){

            if(!visited[i]){
                boolean dfsAns =  dfs(adj,i, visited, helper) ;
                if(dfsAns){
                    break;
                }
            }

        }

        //boolean bfsAns = bfs(adj,V);
        return dfsAns;

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
        boolean res = false;
        int[] indegree = new int[V];
        for(List<Integer> children : adj){
            for(int child : children){
                indegree[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V; i++){
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int polled = q.poll();
            count += 1;
            List<Integer> children = adj.get(polled);
            if(children != null){
                for(int child : children){
                    indegree[child]--;
                    if(indegree[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        return count < V;
    }


}