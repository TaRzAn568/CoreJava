
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SnakeLaderProblem {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            TreeMap<Integer,Integer> lmap = new TreeMap<>();
            TreeMap<Integer,Integer> smap = new TreeMap<>();
            for(int i=0; i<=2*n-2; i = i+2){
                int val1 = Integer.parseInt(s[i]);
                int val2 = Integer.parseInt(s[i+1]);
                if(val1 < val2){
                    lmap.put(val1,val2);
                }else{
                    smap.put(val1,val2);
                }
            }
            ArrayList<Integer> al = new ArrayList<>();


            Map<String,Integer> res = getCount(1,lmap,smap,al);
            System.out.println("res = "+res);
            System.out.println("al = "+al);

        }

    }
    public static Map<String,Integer> getCount(int sum, TreeMap<Integer,Integer> lmap, TreeMap<Integer,Integer> smap, ArrayList<Integer> al){
        TreeMap<Integer,Integer> tempMap = new TreeMap<>();
        for(int x: lmap.keySet()){
            if(x>sum){
                tempMap.put(x,lmap.get(x));
            }
        }
        if(sum == 30){
            return null;
        }
        int c = 0;
        if(tempMap.size()>0){
            for(int x : tempMap.keySet()){

                int diff = x-sum;
                int val = tempMap.get(x);
                if(x > sum && diff <= 6 && !smap.containsKey(val)){
                    sum = val;
                    c++;
                }
                else if(diff > 6){
                    for(int i = 6; i>=0; i--){
                        if(!smap.containsKey(sum+i) && sum+i < 30){
                            sum = sum+i;
                            c++;
                            break;
                        }
                    }
                }
                Map<String,Integer> res = getCount(sum,tempMap,smap,al);
                c = c + res.get("c");
                if(res.get("sum") == 30){

                    al.add(c);
                    c=0;
                    res.put("sum", sum);

                }
            }
        }
        else{
            while(sum <= 30){
                for(int i=6;i >=1; i--){
                    if(!smap.containsKey(sum+i) && sum+i <= 30){
                        sum += i;
                        c++;
                    }
                }
                if(sum == 30)
                    break;
            }
        }
        HashMap<String, Integer> res = new HashMap<>() ;

        res.put("c",c);
        res.put("sum",sum);
        return res;
    }
}
