import java.util.*;
import java.io.*;
import java.util.Arrays;

class Main1 {

    public static void main(String[] dksh)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int [] board = buildBoardArray(br);


            Graph g = new Graph(30);
            GraphImpl gs = new GraphImpl();
            gs.buildGraph(g,board);

            // gs.printAdjacencyList(g);
            int minDice = gs.BFS(g,1,30);
            System.out.println(minDice);
        }

    }


    public static int[] buildBoardArray(BufferedReader br){
        int [] board = new int[31];
        try{

            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            for(int i=0; i<s.length; i = i+2){

                    board[Integer.parseInt(s[i])] = Integer.parseInt(s[i+1]) - Integer.parseInt(s[i]);

            }

        }
        catch(Exception e){

        }
        return board;
    }
}
class GraphImpl {
    void buildGraph(Graph g,int[] board){
        for(int i=1; i<=30; i++){
            for(int j =1; j<=6; j++){
                if(i+j <=30)
                    g.addEdge(i,i+j+board[i+j]);
            }
        }



    }

    public  void printAdjacencyList(Graph g){
        for(Map.Entry entry : g.map.entrySet()){

            System.out.println(entry.getKey() +"-> "+ entry.getValue());

        }
    }


    public int BFS(Graph g, int source, int destination){

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
            if(neighbours != null)
            for (int neighbour : neighbours){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                    dist[neighbour] = dist[parent] +1;
                    parentArray[neighbour] = parent;
                    //System.out.println("Shortest distance of "+neighbour+" from "+source+" is "+dist[neighbour]);
                }
            }
        }
        return dist[destination];

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
