import java.util.*;
import java.util.stream.Collectors;

/*      [1,2,3,4,5]
        [2,4,6,8,10]*/


public class Streams2 {
    public  static void main(String []djwj){
        int n = 80;

        //String res = getResult(n);
        //System.out.println(res);

        List <Integer> al = new ArrayList<>();

        al.stream().map(i-> i*2).collect(Collectors.toList());

    }




}



