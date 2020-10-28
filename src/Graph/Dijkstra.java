package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
//import for Scanner and other utility classes
import java.util.*;
class Node{
    int dest;
    int wt;
    Node(int dest, int wt){
        this.dest = dest;
        this.wt = wt;
    }
}
class Dijkstra {
    public static void main(String args[] ) throws Exception {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- >0){
            int V = Integer.parseInt(br.readLine());
            List<List<Node>> adj = new ArrayList<>();
            for(int i=0; i<V;i++){
                String[] input = br.readLine().split(" ");
                List<Node> children = new ArrayList<>();
                for(int j=0; j<V; j++){
                    int ij = Integer.parseInt(input[j]);
                    if(ij !=0)
                        children.add(new Node(j,ij));
                }
                adj.add(children);

            }
            String [] sd = br.readLine().split(" ");
            int s = Integer.parseInt(sd[0]);
            int d = Integer.parseInt(sd[1]);

            String [] res = dijkstra(V,adj, s, d);
            System.out.println(res[0]);
            System.out.println(res[1]);
        }
    }
    static class pair implements Comparable<pair>{
        int v;
        String psf;
        int dsf;
        pair(int v, String psf, int dsf){
            this.v = v;
            this.psf = psf;
            this.dsf = dsf;
        }
        public int compareTo(pair p1){
            return   this.dsf - p1.dsf;
        }
    }
    static String[] dijkstra(int V, List<List<Node>> adj, int s, int d){
        String res[] = new String[2];
        boolean visited[] = new boolean[V];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(s, Integer.toString(s),   0));
        visited[0] = true;
        while(!pq.isEmpty()){
            pair polled = pq.poll();

            if(polled.v == d){
                res[0] = Integer.toString(polled.dsf);
                res[1] = polled.psf.trim();
                break;
            }
            visited[polled.v] = true;
            int parent = polled.v;
            List<Node> children = adj.get(parent);
            if(children != null){
                for(int i=0; i<children.size(); i++){
                    Node child = children.get(i);
                    if(!visited[child.dest] ){
                       // visited[child.dest] = true;
                        int dsf = polled.dsf+child.wt;
                        String psf = polled.psf+" " +Integer.toString(child.dest);


                        pq.add(new pair(child.dest, psf ,dsf ));

                    }

                }
            }

        }
        return res;
    }
}
