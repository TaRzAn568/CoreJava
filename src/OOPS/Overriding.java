package OOPS;

public class Overriding {
    public static void main(String[]  args){
    new Overriding().m1();
    P1 p = new P1();
    p.m2();

    P1 p2 = new C();
    p2.m2();

    C c = new C();
    c.m2();
    }
    public  float m1(){
        System.out.println("No  args m1");
        return  1.2f;
    }
    public  int m1(int a){
        System.out.println("int args m1");
        return 2;
    }
}


class P1{
    void m2(){
        System.out.println("parent m2");
    }
}

class C extends P1{
    void m2(){
        System.out.println("child  m2");
    }
}