package BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class KnightMoveMain{
    public static void main(String []  ajb)throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());
            int C = Integer.parseInt(br.readLine());
            int D = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());
            int F = Integer.parseInt(br.readLine());

            int r = new KnightMove().knight(A,B,C,D,E,F);
            System.out.println(r);


    }
}

public class KnightMove {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(C,D));
        boolean[][] vis = new boolean[A+1][B+1];
        vis[C][D] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            if(qSize == 0){
                return -1;
            }
            moves++;

            for(int i=0; i<qSize; i++){
                Point parent = q.poll();
                int x = parent.x;
                int y = parent.y;
                System.out.println(x+" "+y);
                if(x == E && y ==F){
                    return moves-1;
                }
                if(valid(x+1,y-2,A,B,vis)){
                    q.add(new Point(x+1,y-2));
                }
                if(valid(x+2,y-1,A,B,vis)){
                    q.add(new Point(x+2,y-1));
                }
                if(valid(x+2,y+1,A,B,vis)){
                    q.add(new Point(x+2,y+1));
                }
                if(valid(x+1,y+2,A,B,vis)){
                    q.add(new Point(x+1,y+2));
                }
                if(valid(x-1,y+2,A,B,vis)){
                    q.add(new Point(x-1,y+2));
                }
                if(valid(x-2,y+1,A,B,vis)){
                    q.add(new Point(x-2,y+1));
                }if(valid(x-2,y-1,A,B,vis)){
                    q.add(new Point(x-2,y-1));
                }if(valid(x-1,y-2,A,B,vis)){
                    q.add(new Point(x-1,y-2));
                }
            }
        }
        return -1;
    }
    public boolean valid(int x, int y,int A, int B, boolean[][] vis){
        boolean res = true;
        if(x <= 0 || x >A || y<=0 || y>B || vis[x][y]){
            res = false;
            return res;
        }
        vis[x][y] = true;
        return res;
    }
}

