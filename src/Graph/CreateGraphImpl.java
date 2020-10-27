package Graph;
import java.nio.channels.FileChannel;
import java.util.*;
class Main {

    public static void main(String[] dksh){
        Graph g = new Graph(4);
        GraphImpl gs = new GraphImpl();
        gs.buildGraph(g);

        gs.printAdjacencyList(g);
        gs.BFS(g,0,3);

    }





}

class GraphImpl {
    void buildGraph(Graph g){
        g.addEdge(0,4,true);
        g.addEdge(4,3,true);
        g.addEdge(4,1,true);
        g.addEdge(3,1,true);
        g.addEdge(3,2,true);
        g.addEdge(2,1,true);
        g.addEdge(0,1,true);
    }

    public  void printAdjacencyList(Graph g){
        for(Map.Entry entry : g.map.entrySet()){

            System.out.println(entry.getKey() +"-> "+ entry.getValue());

        }
    }


    public void BFS(Graph g, int source, int destination){

        boolean[] visited = new boolean[g.V+1];
        visited[source] = true;

        int dist[] = new int[g.V+1];
        int parentArray[] = new int[g.V+1];
        Arrays.fill(parentArray,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        dist[source] = 0;
        while (!q.isEmpty()){
            int parent = q.poll();
           // System.out.print(parent+" ");
            List<Integer> neighbours = g.map.get(parent);
            for (int neighbour : neighbours){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                    dist[neighbour] = dist[parent] +1;
                    parentArray[neighbour] = parent;
                    System.out.println("Shortest distance of "+neighbour+" from "+source+" is "+dist[neighbour]);
                }
            }
        }
        int temp = destination;
        while(temp != -1){
            System.out.print(temp +"<--");
            temp = parentArray[temp];
        }

    }
}




class Graph{
    int V;
    Map<Integer,List<Integer>> map;
    Graph(int v){
        this.V = v;
        this.map =  new HashMap<>();
    }

    void addEdge(int u, int v, boolean biDir){
        addEdge(u,v);
        if(biDir){
            addEdge(v,u);
        }

    }

    void addEdge(int u, int v){
        if(!map.containsKey(u)){
            List<Integer> al = new ArrayList();
            al.add(v);
            map.put(u,al);
        }
        else {
            List<Integer> al = map.get(u);
            al.add(v);
            map.put(u,al);
        }
    }
}
