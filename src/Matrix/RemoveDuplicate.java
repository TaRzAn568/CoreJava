package Matrix;
import java.util.*;

public class RemoveDuplicate {

    public static void main(String[] args){

        List<String> l = new LinkedList<>();
        //ipList = ["Matt", "George", "Matt", "Matt", "Lucy", "George"]
        l.add("Matt");
        l.add("George");
        l.add("Matt");
        l.add("Matt");
        l.add("Lucy");
        l.add("George");
        l.add("George");
        l.add("George");
        l.add("George");
        Map<String,Integer> m = new LinkedHashMap<>();

        for(String x: l){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        Map<String,Integer> res = sortByValues(m);

        for (String x2: res.keySet()){
            System.out.println(x2);
        }
    }

    public  static Map<String,Integer> sortByValues(Map<String,Integer> m){
        List<Map.Entry<String,Integer>> l = new LinkedList<>(m.entrySet());

        Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });

        Map<String,Integer> res = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> etry : l){
            res.put(etry.getKey(),etry.getValue());
        }
        return res;
    }

}
