package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] dksh)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){

            int n = Integer.parseInt(br.readLine());
            int maze[][] = new int[n][n];
            for(int i=0; i<n; i++) {
                String[] inputI = br.readLine().split(" ");
                for(int j=0; j<n; j++){
                    maze[i][j] = Integer.parseInt(inputI[j]);
                }
            }

           /*int maze[][] = {{1, 0, 0, 0},
                   {1, 1, 0, 1},
                   {1, 1, 0, 0},
                   {0, 1, 1, 1}};*/
            List<String> res = new ArrayList<>();
            String curr = "";
            boolean visited[][] = new boolean[n][n];

            ratInMaze(maze, n, 0,0, res, curr, visited);
            if(res.size()==0){
                res.add("-1");
            }
            for(String x : res) {
                System.out.print(x+" ");
            }
        }
    }

    public static void ratInMaze(int[][] maze, int n, int i, int j, List<String> res, String curr, boolean [][] visited){

        if(i == -1 || j == -1 || i== n || j == n || maze[i][j] ==0 ){
            return;
        }
        if(i == n-1 && j == n-1){
            res.add(curr);
            return;
        }

        visited[i][j] = true;

        if(check(maze, n, i+1, j,visited)){
            curr += "D";
            ratInMaze(maze, n, i+1, j, res, curr, visited);
            curr = curr.substring(0,curr.length()-1);
        }

        if(check(maze, n, i, j-1,visited)){
            curr += "L";
            ratInMaze(maze, n, i, j-1, res, curr, visited);
            curr = curr.substring(0,curr.length()-1);
        }

        if(check(maze, n, i, j+1, visited)){
            curr += "R";
            ratInMaze(maze, n, i, j+1, res, curr,visited);
            curr = curr.substring(0,curr.length()-1);
        }

        if(check(maze, n, i-1, j,visited)){
            curr += "U";
            ratInMaze(maze, n, i-1, j, res, curr,visited);
            curr = curr.substring(0,curr.length()-1);
        }
        visited[i][j] = false;
    }


    public static boolean check(int[][] maze, int n, int i, int j, boolean[][] visited){
        if(i<0 || j< 0 || i>n-1 || j>n-1 || maze[i][j] == 0 || visited[i][j]){
            return false;
        }
        return true;
    }
}
