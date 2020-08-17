package StackUtil;


import java.util.*;
        import java.lang.*;
class MaximumRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[1000][1000];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
            MaximumRectangleSol g = new MaximumRectangleSol();

            System.out.println(g.maxArea(a, m, n));
        }
    }
}
// } Driver Code Ends
/*Complete the function given below*/
class MaximumRectangleSol {
    public int maxArea(int a[][], int m, int n) {
        int res = -1;
        int [] a1 = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 0){
                    a1[j] = 0;
                }else{
                    a1[j] += a[i][j];
                }
            }
            int temp = getMaxAreaOfHistogram(a1,n);
            if(temp > res)
                res = temp;
        }
        return res;
    }
    static int getMaxAreaOfHistogram(int [] a,int n){
        int res = -1;
        Stack<Integer> s = new Stack<>();
        int i=0;
        while(i<n){
            if(s.empty() || a[s.peek()] < a[i]){
                s.push(i++);
            }else{
                int top = a[s.pop()];
                int temp = top * (s.empty() ? i : (i-s.peek()-1));
                if(temp > res)
                    res = temp;
            }
        }
        while(!s.empty()){
            int top = a[s.pop()];
            int temp = top * (s.empty() ? i : (i-s.peek()-1));
            if(temp > res)
                res = temp;
        }
        return res;
    }
}
