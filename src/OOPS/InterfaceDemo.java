package OOPS;


interface A{
    public default void show(){System.out.println("interface A");}
}
interface B{
    public default void show1(){System.out.println("interface B");}
}

public class InterfaceDemo implements A,B{
    public static void main(String [] args){
        InterfaceDemo c = new InterfaceDemo();
        c.show();
    }

}
