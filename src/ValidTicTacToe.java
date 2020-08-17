// { Driver Code Starts
import java.util.*;
class ValidTicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            VTTTSolution g = new VTTTSolution();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}// } Driver Code Ends
/*Complete the function below*/
class VTTTSolution {
    public int findExtra(int a[], int b[], int n) {

        return binarySearch(a,b,0,n-2,n);


    }
    public static int binarySearch(int[] a, int[] b, int low, int high,int n){
        int mid = low + (int)(high-low)/2;
        int res = -1;
        if(n == 2){
            if(a[0] == b[0])
                res = 1;
            else
                res = 0;
            return res;

        }
        if(low == high){
            return low;
        }
        if(!(a[low] == b[low] && a[mid]==b[mid])){
            res =  binarySearch(a,b,low,mid,n);
        }
        else if(!(a[mid] == b[mid] && a[high]==b[high])){
            res =  binarySearch(a,b,mid+1,high,n);
        }
        else{
            res = high+1;
        }
         return res;

    }
}