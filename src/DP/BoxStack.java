package DP;

import java.util.*;
import java.lang.*;
import java.io.*;

class BoxStack
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        //sc.next();
        while(t-- > 0)
        {
            int n = sc.nextInt();

            int A[]  =new int[1000];
            int B[] = new int[1000];
            int C[] = new int[1000];

            for(int i = 0; i < n; i++)
            {
                int a =sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                A[i] = a;
                B[i] = b;
                C[i] = c;
            }

            BoxStackSol ob = new BoxStackSol();
            System.out.println(ob.maxHeight(A,B,C,n));
        }
    }
}// } Driver Code Ends


//User function Template for Java



class BoxStackSol
{
   static class Box{
        int h;
        int l;
        int w;
        Box(int h, int l, int w)
        {
            this.h = h;
            this.l = l;
            this.w = w;
        }
    }
   static class BoxComprator implements Comparator<Box>{
        public int compare(Box b1, Box b2){
            return b1.w * b1.l > b2.w * b2.l ? -1 : 1;
        }
    }

    public static int maxHeight(int height[], int width[], int length[], int n)
    {
        List<Box> al = new ArrayList<>();
        for(int i=0; i<n; i++){
          /*  al.add(new Box(height[i], width[i], length[i]));
            al.add(new Box(height[i], length[i], width[i]));
            al.add(new Box(length[i], width[i], height[i]));*/


            al.add(new Box(height[i], Math.max(length[i], width[i]), Math.min(length[i], width[i])));
            //al.add(new Box(height[i], width[i], length[i]));
            al.add(new Box(width[i], Math.max(length[i], height[i]), Math.min(length[i], height[i])));
            //al.add(new Box(width[i], length[i], height[i]));
            al.add(new Box(length[i],Math.max(width[i], height[i]), Math.min(width[i], height[i])));
            //al.add(new Box(length[i], height[i], width[i]));

        }
       //System.out.println( al.size());
        Collections.sort(al,new BoxComprator());
     //   System.out.println(al);
        int [][][] dp = new int[6*n+1][101][101];
        int sum1 = LIS(al,0,Integer.MAX_VALUE,Integer.MAX_VALUE,al.size(),dp);

        System.out.println(sum1);
        int sum = LISBottomUp(al,al.size());
        return sum;
    }
    public static int LIS(List<Box> al,int i,int prevW,int prevL, int n,int[][][] dp){
       if(i == n){
           return 0;
       }
       int temp1 = 0;
       if(prevL != Integer.MAX_VALUE && prevW != Integer.MAX_VALUE && dp[i][prevW][prevL] != 0){
        //System.out.println("use of dp "+i+" "+prevW+" "+prevL);
           return dp[i][prevW][prevL];
       }
       //System.out.println("Not using dp "+i+" "+prevW+" "+prevL);
       if(prevW > al.get(i).w && prevL > al.get(i).l){
           temp1 = al.get(i).h + LIS(al, i+1, al.get(i).w, al.get(i).l, n, dp);
       }
       int temp2 = LIS(al, i+1, prevW, prevL, n, dp);
       if(prevL != Integer.MAX_VALUE && prevW != Integer.MAX_VALUE)
           dp[i][prevW][prevL] = Math.max(temp2,temp1);
       return (prevL != Integer.MAX_VALUE && prevW != Integer.MAX_VALUE) ? dp[i][prevW][prevL] : Math.max(temp2,temp1);
    }

    public static int LISBottomUp(List<Box> al, int n){
        //for(int i=0; i<n;i++)
       // System.out.println(al.get(i).l+" "+al.get(i).w+" "+al.get(i).h);
        int [] a = new int [n];
        for(int i=0; i<n; i++){
            a[i] = al.get(i).h;
        }
        for(int i=1; i<n; i++){
            int temp = a[i];
            for(int j=i-1; j>=0; j--){
                if(al.get(i).w < al.get(j).w && al.get(i).l < al.get(j).l){
                     temp = Math.max(temp,a[i]+a[j]);
                }
            }
            a[i] = temp;
        }

        return Arrays.stream(a).max().orElse(-1);
    }
}
