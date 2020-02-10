import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;



public class SubSequenceOfArray {
    public static void  main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(br.readLine());
        List<List> resultList = new ArrayList<List>();
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            for(int l=0; l<n; l++){
                a[l] = Integer.parseInt(br.readLine());
            }
            ArrayList result = new ArrayList();
            for(int i=0; i<n-m+1; i++){
                for(int j=i+1; j<n-m+2; j++){
                    for(int k=j+1; k<n-m+3; k++){
                        ArrayList temp = new ArrayList();
                        temp.add(a[i]);
                        temp.add(a[j]);
                        temp.add(a[k]);
                        result.add(temp);
                    }
                }
            }
            resultList.add(result);
            t--;
        }
        for(List x : resultList){
            System.out.println(x);
            System.out.println("size = "+x.size());

        }

    }
}
