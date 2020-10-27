package Graph;

import java.util.*;

/*https://leetcode.com/problems/course-schedule-ii/*/

public class TopologicalSort {
    public static void main(String[] js){
        int V = 4;
        int edges[][] = {{1,0},{2,0},{3,1},{3,2}};
        // 0 needs to complete first then 1, hence 0 is parent and 1 is child

        int sortArray[] = new TopologicalSortSolution().findOrder(V, edges);
        for(int x :  sortArray){
            System.out.print(x+" ");
        }
    }

}


class TopologicalSortSolution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int i=0; i<prerequisites.length; i++){
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            if(adj.containsKey(parent)){
                List<Integer> children = adj.get(parent);
                children.add(child);
                adj.put(parent,children);
            }
            else{
                List<Integer> children = new ArrayList<>();
                children.add(child);
                adj.put(parent,children);
            }
        }

        Stack<Integer> st = new Stack<>();
        boolean isCycle = isCycle(adj,numCourses, st);
        int res[] = new int[0];
        if(!isCycle){
            res = new int[numCourses];
            int i=0;
            while(!st.isEmpty()){
                res[i] = st.pop();
                i++;
            }

        }
        return res;
    }


    public boolean isCycle(Map<Integer,List<Integer>> adj, int numCourses, Stack<Integer> st){

        boolean visited[] = new boolean[numCourses];
        boolean explored[] = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                boolean ans = dfs(adj,i, visited, explored, st);
                if(ans) return true;
            }
        }
        return false;
    }

    public static boolean dfs(Map<Integer,List<Integer>> adj, int u, boolean[] visited, boolean[] explored, Stack<Integer> st){
        visited[u] = true;
        explored[u] = true;

        List<Integer> children = adj.get(u);
        if(children != null )
            for(int i=0; i<children.size(); i++){
                if(explored[children.get(i)]) return true;
                if(!visited[children.get(i)]){
                    boolean res = dfs(adj, children.get(i), visited, explored, st);
                    if (res) return true;
                }
            }

        explored[u] = false;
        st.push(u);
        return false;

    }
}
