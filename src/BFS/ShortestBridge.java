package BFS;
import java.util.*;

public class ShortestBridge {
public static void main(String[] args){
    int a[][] = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
    Solution sol = new Solution();
    sol.shortestBridge(a);
}

}

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return 31* new Integer(this.x).hashCode() * new Integer(this.y).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Pair p = (Pair) obj;
        return this.x == p.x && this.y == p.y;
    }

    public String toString(Pair p){
        return "(" + p.x + " " + p.y + ")";
    }
}

class Solution {
    public int shortestBridge(int[][] a) {
        Queue<Pair> q1 = new LinkedList<>();
        Set<Pair> q2 = new HashSet<>();
        boolean flag = true;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        List<Pair> al = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(a[i][j] == 1){
                    dfs(a,i,j,al,dir);


                    if(flag){
                        q1.addAll(al);
                    }
                    else{
                        q2.addAll(al);
                    }
                    flag = !flag;
                    al = new ArrayList<>();
                }

            }
        }


        printList(q1);
        Pair p2 = new Pair(2,21);

        System.out.println(q2.contains(p2));
       // printList(q2);
        return 1;
    }

    public void printList(Queue<Pair> q){
        Iterator<Pair> itr = q.iterator();
        while (itr.hasNext()){
            Pair p = itr.next();
            System.out.print("("+p.x +" "+p.y+"),  " );
        }
    }



    void dfs(int[][] a, int i, int j, List<Pair> al,int[][] dir){

        int n = a.length;
        if(i<0 || i>n-1 ||j<0 || j>n-1 || a[i][j] != 1){
            return ;
        }
        a[i][j] = 2;
        al.add(new Pair(i, j));
        for(int[] x : dir){
            dfs(a, i + x[0], j + x[1],al,dir );
        }


    }

}