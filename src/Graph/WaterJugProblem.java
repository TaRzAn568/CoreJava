package Graph;


import java.util.*;
import java.io.*;

public class WaterJugProblem {
    static class Pair{
        int x;
        int y;
        Pair parent;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
            this.parent = null;
        }
    }
    public static void main(String []  ajb)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- >0){
            String[] mnd = br.readLine().split(" ");
            int m = Integer.parseInt(mnd[0]);
            int n = Integer.parseInt(mnd[1]);
            int d = Integer.parseInt(mnd[2]);
            int r = BFS(m, n, d);
            System.out.println(r);

            boolean visited[][] = new boolean[m+1][n+1];
            Res res = new Res(Integer.MAX_VALUE,"");
           /*dfs(new Pair(0,0),m,n,d,visited,0,res);
            if(res.operation != Integer.MAX_VALUE) {
                System.out.println(res.path);
                System.out.print(res.operation);
            }else{
                System.out.println(-1);
            }*/
        }
    }
    static class Res{
        int operation;
        String path;
        Res(int operation, String path){
            this.operation = operation;
            this.path = path;
        }
    }
    public static void dfs(Pair p, int m, int n, int d, boolean visited[][],int curr, Res res){
        if((p.x == d || p.y == d) && res.operation > curr){
            Pair temp = p;
            res.path = "";
            while(temp.parent != null){
                res.path += "<-("+temp.x+","+temp.y+")";
                temp = temp.parent;
            }
            res.path += "<-("+temp.x+","+temp.y+")";
            res.operation = curr;
            return ;
        }
        int x = p.x;
        int y = p.y;
        visited[x][y] = true;
        //empty x
        if(!visited[0][y]){
            Pair p1 = new Pair(0,y);
            p1.parent = p;
             dfs(p1,m,n,d,visited,curr+1,res);

        }
        // fill x
        if(!visited[m][y]){
            Pair p1 = new Pair(m,y);
            p1.parent = p;
             dfs(p1,m,n,d,visited,curr+1,res);

        }
        // pour from x to y
        if(x+y <= n){
            if(!visited[0][x+y]){
                Pair p1 = new Pair(0,x+y);
                p1.parent = p;
                 dfs(p1,m,n,d,visited,curr+1,res);
            }
        }else{
            if(x-(n-y) >=0 && !visited[x-(n-y)][n]){
                Pair p1 = new Pair(x-(n-y), n);
                p1.parent = p;
                dfs(p1,m,n,d,visited,curr+1,res);
            }
        }


        if(!visited[x][0]){
            Pair p1 = new Pair(x,0);
            p1.parent = p;
            dfs(p1,m,n,d,visited,curr+1,res);
        }
        // fill y
        if(!visited[x][n]){
            Pair p1 = new Pair(x,n);
            p1.parent = p;
             dfs(p1,m,n,d,visited,curr+1,res);
        }
        // pour from y to x
        if(x+y <= m){
            if(!visited[x+y][0]){
                Pair p1 = new Pair(x+y, 0);
                p1.parent = p;
                 dfs(p1,m,n,d,visited,curr+1,res);
            }
        }
        else{
            if(y-(m-x)>=0 && !visited[m][y-(m-x)]){
                Pair p1 = new Pair(m, y-(m-x));
                p1.parent = p;
                dfs(p1,m,n,d,visited,curr+1,res);
            }
        }
        visited[x][y] = false;
        return;
    }

    public static int BFS(int m, int n, int d){
       /* Arrays.stream(Thread.currentThread().getStackTrace()).forEach(s -> System.out.println(
                "\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s
                        .getLineNumber() + ")"));

        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        for(StackTraceElement s : ss){
            System.out.println("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s
                    .getLineNumber() + ")");

        }*/

        boolean visited[][] = new boolean[m+1][n+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        q.add(null);
        visited[0][0] = true;
        int res = 0;
        while (!q.isEmpty()){
            Pair polled = q.poll();
            if(polled == null){
                q.add(null);
                res++;
                if(q.size() == 1)
                    return -1;
                continue;
            }
            int x = polled.x;
            int y = polled.y;
            // System.out.println("x = "+x+" y = "+y);
            if(x == d || y == d){
                Pair p = polled;
                while(p.parent != null){
                    System.out.print("<-("+p.x+","+p.y+")");
                    p = p.parent;
                }
                System.out.println("<-("+p.x+","+p.y+")");
                break;
            }
            //empty x
            if(!visited[0][y]){
                Pair p = new Pair(0,y);
                p.parent = polled;
                q.add(p);
                visited[0][y] = true;
            }
            // fill x
            if(!visited[m][y]){
                Pair p = new Pair(m,y);
                p.parent = polled;
                q.add(p);
                visited[m][y] = true;
            }
            // pour from x to y
            if(x+y <= n){
                if(!visited[0][x+y]){
                    Pair p = new Pair(0,x+y);
                    p.parent = polled;
                    q.add(p);
                    visited[0][x+y] = true;
                }
            }else{
                if(x-(n-y) >=0 && !visited[x-(n-y)][n]){
                    Pair p = new Pair(x-(n-y), n);
                    p.parent = polled;
                    q.add(p);
                    visited[x-(n-y)][n] = true;
                }
            }
            //empty y
            if(!visited[x][0]){
                Pair p = new Pair(x,0);
                p.parent = polled;
                q.add(p);
                visited[x][0] = true;
            }
            // fill y
            if(!visited[x][n]){
                Pair p = new Pair(x,n);
                q.add(p);
                p.parent = polled;
                visited[x][n] = true;
            }
            // pour from y to x
            if(x+y <= m){
                if(!visited[x+y][0]){
                    Pair p = new Pair(x+y, 0);
                    q.add(p);
                    p.parent = polled;
                    visited[x+y][0] = true;
                }
            }
            else{
                if(y-(m-x)>=0 && !visited[m][y-(m-x)]){
                    Pair p = new Pair(m, y-(m-x));
                    p.parent = polled;
                    q.add(p);
                    visited[m][y-(m-x)] = true;
                }
            }
        }
        return res;
    }
}
