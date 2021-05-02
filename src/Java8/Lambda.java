package Java8;

import java.util.function.*;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] hd){
        BiFunction f  = ( a, b)->(Integer.parseInt(a.toString())+Integer.parseInt(b.toString()));
        String sum = f.apply(1,3).toString();
        System.out.println(sum);
        Process addFun = (a,b)->(a+b);
        int add = addFun.doProcess(1,3);
        System.out.println(add);

        Process subFun = (a,b)->(a-b);
        int sub = subFun.doProcess(1,3);
        System.out.println(sub);

        Process mulFun = (a,b)->(a*b);
        int mul = mulFun.doProcess(1,13);
        System.out.println(mul);
    }
}

interface Process{
    int doProcess(int a, int b);
}