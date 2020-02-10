import java.lang.reflect.Array;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;
import java.util.Arrays;


//https://practice.geeksforgeeks.org/problems/sort-by-absolute-difference/0/?ref=self
/*public class KthSmallestelement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input[i]);
            int k = Integer.parseInt(br.readLine());
            findKthSmallest(n, arr, k);

        }
    }

    public static void findKthSmallest(int n, int[] arr, int k) {
        int smallest = 100001;
        int smallestIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        arr[smallestIndex] = 100001;
        if(k != 1) {
            findKthSmallest(n, arr, --k);
        }
        else {
            Random r = new Random();
            int pivot  = r.nextInt(33);
            System.out.println(pivot + " "+  smallest);
        }
    }
}*/



class KthSmallestelement
{
    static int kthsmallest(int arr[], int l, int r, int k)
    {
        System.out.println("kthsmallest called, arr = "+ Arrays.toString(arr) + " , l = "+l+ " r = "+r+" k = "+k);

        // If k is smaller than number of elements in array
        if (k > 0 && k <= r - l + 1)
        {

            // partitioning the array along the pivot
            int pos = randomPartition(arr, l, r);
            System.out.println("pos = "+pos);


            // check if current element gives you the kth smallest element
            if (pos-l == k-1)
                return arr[pos];

            // else recurse for the left and right half accordingly
            if (pos-l > k-1)
                return kthsmallest(arr, l, pos-1, k);
            return kthsmallest(arr, pos+1, r, k-pos+l-1);
        }

        return Integer.MAX_VALUE;
    }


    static int partition(int arr[], int l, int r)
    {
        System.out.println("partition called, arr = "+ Arrays.toString(arr)+" , l = "+l+" r = "+r);
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        System.out.println("arr = "+Arrays.toString(arr));
        return i;
    }

    // Function to partition the array along the random pivot
    static int randomPartition(int arr[], int l, int r)
    {
        Random rand = new Random();
        int n = r-l+1;
        int pivot = rand.nextInt(n);
        System.out.println("pivot = "+pivot);

        int temp = arr[r];
        arr[r] = arr[l+pivot];
        arr[l+pivot] = temp;

        return partition(arr, l, r);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int k = sc.nextInt();
            System.out.println(kthsmallest(arr, 0, n-1, k));
        }
    }
}

