package StringUtils;

import java.util.*;
import java.lang.*;
import java.io.*;

class SecondRepeatingString {
    public static void main(String[] ajd)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            //String  res = secondRepeatedString(s.split("\\s"),n);
            String  res = secondRepeatedString2(s.split("\\s+"),n);

            System.out.println(res);
        }
        br.close();
    }
    public static String secondRepeatedString2(String[] s, int n){
        String res = "";
        class Entity {
            String word;
            int freq;

            Entity(String word, int freq) {
                this.word = word;
                this.freq = freq;
            }
        }
        class MyComparator implements Comparator<Entity>{
            public int compare(Entity e1, Entity e2){
                return e1.freq > e2.freq ? -1 : 1;
            }
        }
        Map<String,Integer> map = new HashMap<>();
        for(String x : s){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        System.out.println(map);
        PriorityQueue<Entity> pq = new PriorityQueue<>(new MyComparator());
        for(String x : map.keySet() ){
            pq.add(new Entity(x,map.get(x)));
        }
        int k = 0;
        while(!pq.isEmpty() && k<2){
            String peek = pq.peek().word;
            pq.poll();
            if(res == ""){
                res = peek;
                k++;
            }
            else{
                if(peek != res){
                    res = peek;
                    k++;
                }
            }
        }


        return res;
    }


    public static String secondRepeatedString(String[] s, int n){
        Map<String, Integer> map = new HashMap<>();
        for(String x : s){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Map.Entry<String,Integer>> al = new ArrayList<>();
        for(Map.Entry<String,Integer> m : map.entrySet()){
            al.add(m);
        }
        System.out.println(al);
        Collections.sort(al,new MyComparator());
        System.out.println(al);
        return al.get(1).getKey();
    }

    static class MyComparator implements Comparator<Map.Entry<String,Integer>>{
        public int compare(Map.Entry<String,Integer> m1, Map.Entry<String,Integer> m2){
            return m1.getValue()> m2.getValue() ? -1 : 1;
        }
    }

}