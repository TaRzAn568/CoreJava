
// { Driver Code Starts
import java.util.*;
class TripletWithSumZero{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            Triplet g=new Triplet();
            if(g.findTriplets(a,n))
                System.out.println("1");
            else
                System.out.println("0");

        }
    }
}// } Driver Code Ends
/*Complete the function below*/


class Triplet
{
    // Function to check if triplet is present
    // arr[]: input array
    // n: size of the array
    public boolean findTriplets(int a[] , int n)
    {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i=0; i<n;i++){
            m.put(a[i],m.getOrDefault(a[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int pair = -1*a[i];
            m.put(a[i],m.getOrDefault(a[i],0)-1);
            for(int j=0; j<n && j!=i ; j++){
                int rem = pair-a[j];
                m.put(a[j],m.getOrDefault(a[j],0)-1);
                if(m.containsKey(rem) && m.getOrDefault(rem,0) > 0)
                {
                    return true;
                }
                m.put(a[j],m.getOrDefault(a[j],0)+1);
            }
            m.put(a[i],m.getOrDefault(a[i],0)+1);
        }
        return false;
    }

}