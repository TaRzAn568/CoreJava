
import java.util.*;
class MergeKSortedArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    a[i][j] = sc.nextInt();
            MergeKSortedArraySolution g = new MergeKSortedArraySolution();
            ArrayList<Integer> arr= g.mergeKArrays(a, n);
            printArray(arr,n*n);
        }
    }
    public static void printArray(ArrayList<Integer> arr, int size){
        for(int i = 0; i < size ; i++)
            System.out.print(arr.get(i)+" ");
        System.out.println();
    }
}// } Driver Code Ends
/*Complete the function below*/
class MergeKSortedArraySolution
{
    public static ArrayList<Integer> mergeKArrays(int[][] a,int k){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<k;i++){
            res.add(a[0][i]);
        }
        for(int i=1; i<k; i++){
            int l = 0;
            int r = 0;
            int z=0;
            ArrayList<Integer> al = new ArrayList<>();

            while(l<res.size() && r < k){
                if(res.get(l) > a[i][r]){
                    al.add(z,a[i][r]);
                    r++;
                    z++;
                }else{
                    al.add(z,res.get(l));
                    l++;
                    z++;
                }


            }
            while(l<res.size()){
                al.add(z,res.get(l));
                l++;
                z++;
            }
            while(r<k){
                al.add(z,a[i][r]);
                r++;
                z++;
            }
            res.clear();
            res.addAll(al);
            al.clear();

        }
        return res;
    }
}
