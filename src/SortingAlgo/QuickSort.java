package SortingAlgo;

import java.util.*;
class QuickSort
{
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    /* The main function that implements QuickSort()
       arr[] --> Array to be sorted,
       low  --> Starting index,
       high  --> Ending index */
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {

            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = new QuickSortSol().partition(arr, low, high);
            /*System.out.println("pi = "+pi);
            printArray(arr);*/
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    // Driver program
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


            quickSort(arr,0,n-1);
            printArray(arr);
            T--;
        }
    } }// } Driver Code Ends


/* The main function that implements QuickSort() (present in a class
   different from QuickSort)
   arr[] --> Array to be sorted,   low  --> Starting index,  high  --> Ending index
static void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {

        int pi = new QuickSort().partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    } }*/
class QuickSortSol
{
    /* This function takes last element as pivot, places  the pivot element
    at its correct position in sorted  array, and places all smaller (smaller
    than pivot) to left of pivot and all greater elements to right  of pivot */
    static int partition(int a[], int low, int high)
    {
        int pivot = high;
        int i = low;
        int j = low;
        for(;i< high && j < high;i++){
            if( a[i] < a[pivot]){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }

        }
        int temp = a[j];
        a[j] = a[pivot];
        a[pivot] = temp;

        return j;
    }
}