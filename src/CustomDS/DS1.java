package CustomDS;

import java.util.LinkedHashSet;
import java.util.*;

// create a dataStructure which supports insert/ remove/ search/ getRandon in O(1) with duplicates;
// https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-getrandom-in-o1-with-duplicates/
public class DS1 {

    public static void main(String[]  args){
        MyDS1 ds = new MyDS1();
        ds.insert(1);
        ds.insert(2);
        ds.insert(3);
        ds.insert(5);
        ds.insert(2);

        System.out.println(ds.list);
        System.out.println(ds.getRandom());
        //  ds.insert(4);
        System.out.println(ds.search(4));
        ds.remove(2);

        System.out.println(ds.list);
        System.out.println(ds.getRandom());

        Iterator<Integer> itr = ds.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }

}

class MyDS1{
    Map<Integer, LinkedHashSet<Integer>> map ;
    List<Integer> list;

    MyDS1(){
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    boolean insert(int x){
        int insertIndex = list.size();
        boolean res = false;
        if(!map.containsKey(x)){
            LinkedHashSet<Integer> hs = new LinkedHashSet<>();
            hs.add(insertIndex);
            map.put(x,hs);
            res = true;
        }
        else{
            LinkedHashSet<Integer> set = map.get(x);
            set.add(insertIndex);
            map.put(x, set);
        }
        list.add(x);
        return res;
    }

    boolean search(int x){
        return map.containsKey(x);
    }
    boolean remove(int x){
        if(!map.containsKey(x)){
            return false;
        }
        LinkedHashSet set = map.get(x);
        int removeIndex = (int) set.stream().findFirst().get();
        if(set.size() == 1){
            map.remove(x);
        }else{
            set.remove(x);
        }
            list.set(removeIndex, list.get(list.size() - 1));
            list.remove(list.size() - 1);


        return true;
    }

    int getRandom(){
        Random r = new Random();
        int x = r.nextInt(list.size());
        return list.get(x);
    }
    Iterator<Integer> iterator(){
        return list.iterator();
    }

}
