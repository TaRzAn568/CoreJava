import java.util.*;
import java.util.stream.Collectors;


public class StreamExamp {
    public static void main(String [] args) {

        List<Integer> all = new ArrayList<>();
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        all.add(5);

        List<Integer> max = all.stream().map(i -> i * i).collect(Collectors.toList());
        /*Comparator<Integer> cmp = new Comparator() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        };*/
        //Integer maxVal = max.stream().max((i1,i2) ->i1.compareTo(i2)).get();
        //Integer maxVal = max.stream().sorted().filter();

        System.out.println(max);
        //System.out.println(maxVal);
    }


}
