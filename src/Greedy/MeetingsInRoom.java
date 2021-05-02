package Greedy;


import java.io.*;
import java.util.*;
import java.lang.*;

class MeetingsInRoom {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);
            new Meeting().maxMeetings(start, end, n);
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Meeting {

    static class Pair{
        int s;
        int e;
        int d;
        Pair(int s, int e){
            this.s = s;
            this.e = e;
            this.d = e-s;
        }
    }
    static void maxMeetings(int start[], int end[], int n) {
        // add your code here
        List<Pair> timeList = new ArrayList<>();
        List<Pair> durationList = new ArrayList<>();
        List<Pair> indexList = new ArrayList<>();
        for(int i=0; i<n; i++){
            Pair p = new Pair(start[i],end[i]);
            timeList.add(p);
            durationList.add(p);
            indexList.add(p);
        }
        Collections.sort(timeList,(p1,p2)->(p1.s-p2.s));
        Collections.sort(durationList,(p1,p2)->(p1.d-p2.d));



        int s = -1;
        int e = -1;
        int c = 0;
        for(Pair p : timeList){
            if(e <= p.s && timeList.indexOf(p) - durationList.indexOf(p) >= 0){
                s = p.s;
                e = p.e;
                c++;
                System.out.print(indexList.indexOf(p)+1+" ");
            }
        }
    }
}