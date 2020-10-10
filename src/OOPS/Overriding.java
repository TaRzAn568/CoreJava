package OOPS;

public class Overriding {
    public static void main(String[]  args){
        m1(1);
    }
    public static float m1(){
        System.out.println("No  args m1");
        return  1.2f;
    }
    public static int m1(int a){
        System.out.println("int args m1");
        return 2;
    }
}
