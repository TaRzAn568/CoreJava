import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.*;


//https://practice.geeksforgeeks.org/problems/sort-by-absolute-difference/0/?ref=self
public class SortByAbsoluteDifference {
    public static void  main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<int[]> resultList = new ArrayList<int[]>();
        while(t>0){
            String [] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String [] input = br.readLine().split(" ");
            int [] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(input[i]);
            //resultList.add(sortByAbsoluteDiff(arr, n, k)); -->O(n2)
            resultList.add(rearrange(arr, n, k));          // -->O(nlog(n))
            t--;
        }
        for(int[] x : resultList){
            for(int y : x)
                System.out.print(y +" ");
            System.out.println("");

        }
    }
    public static int[] sortByAbsoluteDiff(int[] arr, int n, int k){
        int [] cloneArr = arr.clone();
        for(int i=0; i<n-1; i++){
            int min_Index = i;
            for(int j=i+1; j<n; j++){
                if(Math.abs(arr[j] - k) < Math.abs(arr[min_Index] - k))
                    min_Index = j;
                else if(Math.abs(arr[j] - k) == Math.abs(arr[min_Index] - k)){
                    if(indexOfArray(cloneArr , arr[j]) < indexOfArray(cloneArr, arr[min_Index]))
                        min_Index = j;
                }
            }
            int temp = arr[min_Index];
            arr[min_Index] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public static int indexOfArray(int[] arr, int num){
        int index = -1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] == num)
            {
                index = i;
                break;
            }
            i++;
        }
        return index;
    }

    public static int[] rearrange(int [] arr, int n, int k){
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for(int i = 0; i<n; i++){
            Integer absDiff = Math.abs(arr[i]-k);
            if(map.containsKey(absDiff)){
                List<Integer> al = map.get(absDiff);
                al.add(arr[i]);
                map.put(absDiff,al);
            }else{
                List<Integer> al = new ArrayList<Integer>();
                al.add(arr[i]);
                map.put(absDiff,al);
            }
        }
        int m = 0;
        for(Map.Entry<Integer,List<Integer>> x : map.entrySet()){
            List<Integer> temp = x.getValue();
            for(int j =0;j<temp.size();j++){
                arr[m] = temp.get(j);
                m++;
            }
        }
        return arr;
    }
}
